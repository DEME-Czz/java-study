package com.javastudy.javabasics.common.uitl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Set;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName Util.java
 * @Description TODO
 * @createTime 2021/3/25 14:27
 */
public class Util {

    public static void main(String[] args) {
        //实现
        String map = "{\"a\":{\"b\":[{\"c\":\"d\",\"c1\":\"d1\",\"c2\":\"d2\"},{\"e\":\"f\"}]}}";

        //实现
//        String map = "{\"c\":\"d\",\"c1\":\"d1\",\"c2\":\"d2\"}";

//        String map = "{\"b\":[{\"c\":\"d\",\"c1\":\"d1\",\"c2\":\"d2\"},{\"e\":\"f\"}]}";

        Object jsonObject = JSONObject.parseObject(map);
        JSONObject jsonObject1 = new JSONObject();
        listJson(jsonObject, jsonObject1, null,"");
        System.out.println(JSON.toJSONString(jsonObject1));
    }

    private static JSONObject TEMP_JSONOBJECT = new JSONObject();
    public static void listJson(Object objJson, JSONObject js, JSONObject currs, String lastValue) {
        if (objJson instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) objJson;
            if (jsonArray.size() > 0) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    listJson(jsonArray.get(i), js, currs, lastValue);
                }
            }
        } else if (objJson instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) objJson;
            Set<String> keySet = jsonObject.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String nkey = key.concat("1");
                Object value = jsonObject.get(key);
                if (value instanceof JSONArray) {
                    JSONObject arro = null;
                    if (!"".equals(lastValue)){
                        arro = (JSONObject)js.get(lastValue);
                        arro.put(nkey, new JSONArray());
                    }else {
                        js.put(nkey, new JSONArray());
                    }
                    JSONArray innerArr = (JSONArray) value;
                    listJson(innerArr, js, arro, nkey);
                } else if (value instanceof JSONObject) {
                    JSONObject arro = null;
                    if (!"".equals(lastValue)){
                        arro = (JSONObject)js.get(lastValue);
                        arro.put(nkey, new JSONObject());
                    }else {
                        js.put(nkey, new JSONObject());
                    }
                    listJson(value, js, arro, nkey);
                } else {
                    if (!"".equals(lastValue)){
                        Object curr = null != currs?currs.get(lastValue):js.get(lastValue);
                        if (curr instanceof JSONArray) {
                            TEMP_JSONOBJECT.put(nkey, value.toString());
                            if (!iterator.hasNext()){
                                JSONObject jsonObject1 = new JSONObject();
                                jsonObject1.putAll(TEMP_JSONOBJECT);
                                ((JSONArray) curr).fluentAdd(jsonObject1);
                                TEMP_JSONOBJECT.clear();
                            }
                        } else if (curr instanceof JSONObject) {
                            ((JSONObject)curr).put(nkey, value.toString());
                        }
                    }else {
                        js.put(nkey, value);
                    }
                }
            }
        }
    }
}
