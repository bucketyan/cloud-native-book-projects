package com.fuck.cloudnative.monolith.example.order.repository;

import com.fuck.cloudnative.monolith.example.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
