package com.fuck.cloudnative.monolith.example.order.web;

import com.fuck.cloudnative.monolith.example.order.service.OrderItemService;
import com.fuck.cloudnative.monolith.example.commons.dto.OrderItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午4:15
* created by fuck~
**/
@RestController
@RequestMapping("/order_items")
public class OrderItemResource {

    private final OrderItemService itemService;

    public OrderItemResource(OrderItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<OrderItemDto> findAll() {
        return this.itemService.findAll();
    }

    @GetMapping("/{id}")
    public OrderItemDto findById(@PathVariable Long id) {
        return this.itemService.findById(id);
    }

    @PostMapping
    public OrderItemDto create(@RequestBody OrderItemDto orderItemDto) {
        return this.itemService.create(orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.itemService.delete(id);
    }
}
