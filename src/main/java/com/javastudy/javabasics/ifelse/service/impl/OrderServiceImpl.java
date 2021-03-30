package com.javastudy.javabasics.ifelse.service.impl;

import com.javastudy.javabasics.ifelse.common.HandlerContext;
import com.javastudy.javabasics.ifelse.common.abs.AbstractHandler;
import com.javastudy.javabasics.ifelse.entitys.OrderDTO;
import com.javastudy.javabasics.ifelse.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2021/3/30 16:02
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO dto) {
        AbstractHandler handler = handlerContext.getInstance(dto.getType());
        String handler1 = handler.handler(dto);
        System.out.println(handler1);
        return "";
    }


}
