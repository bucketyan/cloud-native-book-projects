package com.fuck.cloudnative.microservices.example.demo.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:57
* created by fuck~ 
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private Long quantity;
    private Long productId;
    private Long orderId;
}
