package com.fuck.cloudnative.monolith.example.order.web;

import com.fuck.cloudnative.monolith.example.order.service.OrderService;
import com.fuck.cloudnative.monolith.example.commons.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午4:16
* created by fuck~
**/
@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

   /* @GetMapping("/customer/{id}")
    public List<OrderDto> findAllByUser(@PathVariable Long id) {
        return this.orderService.findAllByUser(id);
    }*/

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}
