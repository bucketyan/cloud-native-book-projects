package com.fuck.cloudnative.monolith.example.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/13-下午4:01
* created by fuck~ 
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String title;
    private String description;
    private Long rating;
}
