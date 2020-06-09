package com.fuck.cloudnative.microservices.example.demo.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:49
* created by fuck~ 
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String address;
    private String city;
    private String postcode;
    private String country;
}
