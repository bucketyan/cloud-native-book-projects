package com.fuck.cloudnative.microservices.example.customer.entity;

import com.fuck.cloudnative.microservices.example.customer.entity.enumeration.CartStatus;
import com.fuck.cloudnative.microservices.example.demo.commons.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
* DESCRIPTION:
* 购物车实体类
* @author zouyan
* @create 2020/5/13-下午2:18
* created by fuck~
**/
@Getter //自动生成默认的getter、setter,在类上使用则所有字段生成getter、setter
@Setter
@NoArgsConstructor //生成无参构造
@Entity //表明该类为一个实体类 @Entity，它默认对应数据库中的表名是carts @Table
@Table(name = "carts")
public class Cart extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private Long orderId;

    @ManyToOne
    private Customer customer;

    @NotNull //注解验证，被注释的元素不能为null
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    public Cart(Customer customer) {
        this.customer = customer;
        this.status = CartStatus.NEW;
    }

    public Cart(Customer customer, @NotNull CartStatus status) {
        this.customer = customer;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(customer, cart.customer) &&
                status == cart.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, status);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "customer=" + customer +
                ", status=" + status +
                '}';
    }
}
