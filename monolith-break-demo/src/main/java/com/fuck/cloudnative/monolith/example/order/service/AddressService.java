package com.fuck.cloudnative.monolith.example.order.service;

import com.fuck.cloudnative.monolith.example.order.entity.Address;
import com.fuck.cloudnative.monolith.example.commons.dto.AddressDto;
import org.springframework.stereotype.Service;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午3:47
* created by fuck~
**/
@Service
public class AddressService {

    public static AddressDto mapToDto(Address address) {
        if (address != null) {
            return new AddressDto(
                    address.getAddress(),
                    address.getCity(),
                    address.getPostcode(),
                    address.getCountry()
            );
        }
        return null;
    }

    public static Address createFromDto(AddressDto addressDto) {
        if (addressDto != null) {
            return new Address(
                    addressDto.getAddress(),
                    addressDto.getCity(),
                    addressDto.getPostcode(),
                    addressDto.getCountry()
            );
        }
        return null;
    }
}
