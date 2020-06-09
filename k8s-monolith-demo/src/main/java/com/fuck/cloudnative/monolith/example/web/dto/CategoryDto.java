package com.fuck.cloudnative.monolith.example.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午3:51
* created by fuck~ 
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Integer products;
}
