package com.fuck.cloudnative.microservices.example.order.web;

import com.fuck.cloudnative.microservices.example.demo.commons.dto.PaymentDto;
import com.fuck.cloudnative.microservices.example.order.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午4:17
* created by fuck~ 
**/
@RestController
@RequestMapping("/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }

    @PostMapping
    public PaymentDto create(@RequestBody PaymentDto orderItemDto) {
        return this.paymentService.create(orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }
}
