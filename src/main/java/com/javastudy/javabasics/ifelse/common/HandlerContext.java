package com.javastudy.javabasics.ifelse.common;

import com.javastudy.javabasics.ifelse.common.abs.AbstractHandler;

import java.util.Map;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName HandlerContext.java
 * @Description TODO
 * @createTime 2021/3/30 17:12
 */
public class HandlerContext {

    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type){
        try {
            Class clazz = handlerMap.get(type);
            if (null == clazz){
                throw new IllegalArgumentException("not find handler for type： " + type);
            }
            return (AbstractHandler)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
