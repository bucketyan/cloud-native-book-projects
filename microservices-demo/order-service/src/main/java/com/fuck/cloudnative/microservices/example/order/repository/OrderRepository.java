package com.fuck.cloudnative.microservices.example.order.repository;

import com.fuck.cloudnative.microservices.example.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:26
* created by fuck~ 
**/
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    //List<Order> findByCartCustomerId(Long id);
}
