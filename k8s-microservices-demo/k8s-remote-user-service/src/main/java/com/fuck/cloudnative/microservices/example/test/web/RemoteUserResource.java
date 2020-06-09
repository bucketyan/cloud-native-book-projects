package com.fuck.cloudnative.microservices.example.test.web;

import com.fuck.cloudnative.microservices.example.demo.commons.dto.CustomerDto;
import com.fuck.cloudnative.microservices.example.test.service.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/4/8-下午3:58
* created by fuck~ 
**/
@RestController
@RequestMapping("/remote-users")
public class RemoteUserResource {

    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<CustomerDto> findAll() {
        return this.remoteUserService.findAll();
    }

    @GetMapping("/rest-template")
    public List<CustomerDto> findAllByRestTemplate() {
        List<CustomerDto> productResponseEntity
                = this.restTemplate.getForObject(
                "http://customer-service:8080/customers",
                List.class
        );
        return productResponseEntity;
    }

    @GetMapping("/rest-template/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
        ResponseEntity<CustomerDto> productResponseEntity
                = this.restTemplate.getForEntity(
                "http://customer-service:8080/customers/{id}",
                CustomerDto.class,
                id
        );
        return productResponseEntity;
    }


}