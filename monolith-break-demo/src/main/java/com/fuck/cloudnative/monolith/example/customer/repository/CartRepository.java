package com.fuck.cloudnative.monolith.example.customer.repository;

import com.fuck.cloudnative.monolith.example.customer.entity.Cart;
import com.fuck.cloudnative.monolith.example.customer.entity.enumeration.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* DESCRIPTION:
* 购物车持久层
* 继承JpaRepository接口可以使用 Spring JPA 里面提供的很多约定的方法查询和注解查询
* @author zouyan
* @create 2020/5/13-下午2:39
* created by fuck~
**/
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    /**
     * 通过购物车状态进行查询
     * @param status
     * @return
     */
    List<Cart> findByStatus(CartStatus status);

    /**
     * 通过购物车状态及买家Id进行查询
     * @param status
     * @param customerId
     * @return
     */
    List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);
}
