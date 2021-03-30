package com.javastudy.javabasics.ifelse.common;

import com.javastudy.javabasics.ifelse.common.abs.AbstractHandler;
import com.javastudy.javabasics.ifelse.common.abs.HandlerType;
import com.javastudy.javabasics.ifelse.entitys.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName NormalHandler.java
 * @Description TODO
 * @createTime 2021/3/30 16:12
 */
@Component
@HandlerType("2")
public class GrouplHandler extends AbstractHandler<OrderDTO> {


    @Override
    public String handler(OrderDTO dto) {
        return "请求团购的订单方法成功！";
    }
}
