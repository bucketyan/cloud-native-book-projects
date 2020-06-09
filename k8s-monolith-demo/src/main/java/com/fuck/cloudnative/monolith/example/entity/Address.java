package com.fuck.cloudnative.monolith.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午2:55
* created by fuck~
**/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable //表示一个非Entity类可以嵌入到另一个Entity类中作为属性而存在
public class Address implements Serializable {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    //@NotNull
    @Size(max = 10)
    @Column(name = "postcode", length = 10)//, nullable = false)
    private String postcode;

    //@NotNull
    @Size(max = 2)
    @Column(name = "country", length = 2)//, nullable = false)
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(address, address.address) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postcode, address.postcode) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, postcode, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
