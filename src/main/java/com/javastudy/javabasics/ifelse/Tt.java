package com.javastudy.javabasics.ifelse;

import com.javastudy.javabasics.ifelse.entitys.OrderDTO;
import com.javastudy.javabasics.ifelse.service.OrderService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName tt.java
 * @Description TODO
 * @createTime 2021/3/30 17:25
 */
@Component
public class Tt {

    @Resource
    private OrderService orderService;

    @PostConstruct
    public void mm(){
        OrderDTO orderDTO = new OrderDTO("1", "3");
        orderService.handle(orderDTO);
    }
}
