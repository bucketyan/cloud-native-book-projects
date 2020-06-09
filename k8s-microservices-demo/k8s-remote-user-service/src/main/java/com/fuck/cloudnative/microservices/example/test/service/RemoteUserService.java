package com.fuck.cloudnative.microservices.example.test.service;

import com.fuck.cloudnative.microservices.example.demo.commons.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * DESCRIPTION:
 *
 * @author zouyan
 * @create 2019-05-22 下午2:50
 * created by fuck~
 **/
@FeignClient(value = "http://customer-service:8080", url = "http://customer-service:8080", fallbackFactory = RemoteUserServiceFactory.class)
public interface RemoteUserService {

    @RequestMapping("/customers")
    List<CustomerDto> findAll();
}