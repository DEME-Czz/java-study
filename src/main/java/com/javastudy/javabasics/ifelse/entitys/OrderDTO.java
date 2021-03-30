package com.javastudy.javabasics.ifelse.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName OrderDTO.java
 * @Description TODO
 * @createTime 2021/3/30 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String code;

    /**
     * 
     * 订单类型
     * 1.普通订单
     * 2.团购订单
     * 3.促销订单
     *
     * @title 订单类型
     * @author zhengyang.chen
     * @param 
     * @updateTime 2021/3/30 15:53 
     * @throws 
     */
    private String type;

}
