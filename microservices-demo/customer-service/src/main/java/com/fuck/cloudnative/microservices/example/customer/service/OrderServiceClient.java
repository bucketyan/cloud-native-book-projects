package com.fuck.cloudnative.microservices.example.customer.service;

import com.fuck.cloudnative.microservices.example.demo.commons.dto.CartDto;
import com.fuck.cloudnative.microservices.example.demo.commons.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/25-下午4:49
* created by fuck~
**/
@FeignClient(name = "order-service")
public interface OrderServiceClient {

    @RequestMapping(value = "/orders", method = POST)
    OrderDto create(CartDto cartDto);

}
