package com.javastudy.javabasics.ifelse.common.abs;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName AbstractHandler.java
 * @Description TODO
 * @createTime 2021/3/30 16:06
 */
public abstract class AbstractHandler<T> {

    /**
     *
     * 策略模式顶级父类
     * 
     * @title handler
     * @author zhengyang.chen
     * @param t
     * @updateTime 2021/3/30 16:07 
     * @return: java.lang.String
     */
    abstract public String handler(T t);
}
