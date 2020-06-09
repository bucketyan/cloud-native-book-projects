package com.fuck.cloudnative.monolith.example.order.service;

import com.fuck.cloudnative.monolith.example.order.entity.Order;
import com.fuck.cloudnative.monolith.example.order.entity.OrderItem;
import com.fuck.cloudnative.monolith.example.order.repository.OrderItemRepository;
import com.fuck.cloudnative.monolith.example.order.repository.OrderRepository;
import com.fuck.cloudnative.monolith.example.commons.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:57
* created by fuck~ 
**/
@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public List<OrderItemDto> findAll() {
        log.debug("Request to get all OrderItems");
        return this.orderItemRepository.findAll()
                .stream()
                .map(OrderItemService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderItemDto findById(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return this.orderItemRepository
                .findById(id)
                .map(OrderItemService::mapToDto)
                .orElse(null);
    }

    public OrderItemDto create(OrderItemDto orderItemDto) {
        log.debug("Request to create OrderItem : {}", orderItemDto);
        Order order =
                this.orderRepository
                        .findById(orderItemDto.getOrderId())
                        .orElseThrow(() -> new IllegalStateException("The Order does not exist!"));

        return mapToDto( this.orderItemRepository.save(
                new OrderItem( orderItemDto.getQuantity(),
                        orderItemDto.getProductId(),
                        order
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        this.orderItemRepository.deleteById(id);
    }

    public static OrderItemDto mapToDto(OrderItem orderItem) {
        if (orderItem != null) {
            return new OrderItemDto(
                    orderItem.getId(),
                    orderItem.getQuantity(),
                    orderItem.getProductId(),
                    orderItem.getOrder().getId()
            );
        }
        return null;
    }

}