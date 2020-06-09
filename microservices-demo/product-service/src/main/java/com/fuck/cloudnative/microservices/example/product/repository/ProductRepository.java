package com.fuck.cloudnative.microservices.example.product.repository;

import com.fuck.cloudnative.microservices.example.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:26
* created by fuck~ 
**/
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
