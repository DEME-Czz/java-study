package com.javastudy.javabasics.ifelse.service;

import com.javastudy.javabasics.ifelse.entitys.OrderDTO;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2021/3/30 15:54
 */
public interface OrderService {

    /**
     *
     * 根据不同类型的订单做出不通的处理
     * @title handle
     * @author zhengyang.chen
     * @param
     * @param dto 订单实体
     * @updateTime 2021/3/30 15:55
     * @return: java.lang.String
     */
    String handle(OrderDTO dto);

}
