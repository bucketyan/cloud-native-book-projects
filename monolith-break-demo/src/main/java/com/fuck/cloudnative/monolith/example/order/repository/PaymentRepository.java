package com.fuck.cloudnative.monolith.example.order.repository;

import com.fuck.cloudnative.monolith.example.order.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:24
* created by fuck~ 
**/
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
