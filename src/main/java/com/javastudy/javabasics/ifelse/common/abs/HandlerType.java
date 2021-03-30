package com.javastudy.javabasics.ifelse.common.abs;

import java.lang.annotation.*;

/**
 *
 * 策略模式用来区分不通的数据类型去对应不通的方法
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName HandlerType.java
 * @Description TODO
 * @createTime 2021/3/30 16:14
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {
    String value();
}
