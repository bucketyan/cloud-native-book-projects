package com.fuck.cloudnative.microservices.example.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuck.cloudnative.microservices.example.demo.commons.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.Set;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:11
* created by fuck~ 
**/
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Cart> carts;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    public Customer(String name, @Email String email,
                    String telephone, Set<Cart> carts, Boolean enabled) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.carts = carts;
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(telephone, customer.telephone) &&
                Objects.equals(carts, customer.carts) &&
                Objects.equals(enabled, customer.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, telephone, enabled);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
