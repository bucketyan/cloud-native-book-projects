package com.fuck.cloudnative.microservices.example.customer.web;

import com.fuck.cloudnative.microservices.example.customer.service.CartService;
import com.fuck.cloudnative.microservices.example.demo.commons.dto.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午4:07
* created by fuck~
**/
@RestController
@RequestMapping("/carts") //访问路径将为http://SERVER_URL:SERVER_PORT/carts
public class CartResource {

    private final CartService cartService;

    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartDto> findAll() { //CartDto对象作为REST web服务的响应返回。当调用时，Spring Boot将使用Jackson将对象序列化为JSON
        return this.cartService.findAll();
    }

    @GetMapping("/active")
    public List<CartDto> findAllActiveCarts() {
        return this.cartService.findAllActiveCarts();
    }

    @GetMapping("/customer/{id}")
    public CartDto getActiveCartForCustomer(@PathVariable("id") Long customerId) {
        return this.cartService.getActiveCart(customerId);
    }

    @GetMapping("/{id}")
    public CartDto findById(@PathVariable Long id) {
        return this.cartService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.cartService.delete(id);
    }

    @PostMapping("/customer/{id}")
    public CartDto create(@PathVariable("id") Long customerId) {
        return this.cartService.create(customerId);
    }
}
