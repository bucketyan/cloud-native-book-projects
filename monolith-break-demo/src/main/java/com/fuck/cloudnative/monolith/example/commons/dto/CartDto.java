package com.fuck.cloudnative.monolith.example.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:47
* created by fuck~ 
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private Long orderId;
    private CustomerDto customerDto;
    private String status;
}
