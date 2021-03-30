package com.javastudy.javabasics.ifelse.common;

import com.google.common.collect.Maps;
import com.javastudy.javabasics.ifelse.common.abs.HandlerType;
import org.cent.scanner.core.scanner.ClassScanner;
import org.cent.scanner.core.scanner.impl.DefaultClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName HandlerProcessor.java
 * @Description TODO
 * @createTime 2021/3/30 16:22
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.javastudy.javabasics.ifelse.common";

    private ClassScanner classScanner = new DefaultClassScanner();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        HashMap<String, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        classScanner.scanByAnno(Arrays.asList(HANDLER_PACKAGE), HandlerType.class).forEach(clazz ->{
            HandlerType type = (HandlerType)clazz.getAnnotation(HandlerType.class);
            handlerMap.put(type.value(), clazz);
        });
        HandlerContext handlerContext = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), handlerContext);
    }
}
