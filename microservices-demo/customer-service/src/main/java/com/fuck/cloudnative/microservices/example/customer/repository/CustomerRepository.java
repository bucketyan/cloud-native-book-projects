package com.fuck.cloudnative.microservices.example.customer.repository;

import com.fuck.cloudnative.microservices.example.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午3:11
* created by fuck~
**/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * 查询所有用户
     * @param enabled
     * @return
     */
    List<Customer> findAllByEnabled(Boolean enabled);
}
