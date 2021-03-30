package com.javastudy.test;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.Environment;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName Test1.java
 * @Description TODO
 * @createTime 2021/3/29 10:27
 */
@SpringBootTest
public class Test1 {


    @Test
    void t1() throws FileNotFoundException, UnsupportedEncodingException {
//        ApplicationHome home = new ApplicationHome(getClass());
//        File jarFile = home.getSource();
//        String jarUrl = jarFile.getParentFile().toString() + "/app.conf";
//        System.out.println("jar 启动地址 ：" + jarUrl);

        //第一种
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println(path.getAbsolutePath());
        //第二种
        System.out.println(System.getProperty("user.dir"));
        //第三种
        String path1 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(URLDecoder.decode(path1, "utf-8"));
        //第四种
        String path2 = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path2);
        //第五种
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        System.out.println(jarF.getParentFile().toString());
    }
}
