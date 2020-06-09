package com.fuck.cloudnative.monolith.example.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午3:58
* created by fuck~
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private String paymentId;
    private String status;
    private Long orderId;
}
