package com.fuck.cloudnative.microservices.example.product.web;

import com.fuck.cloudnative.microservices.example.demo.commons.dto.CategoryDto;
import com.fuck.cloudnative.microservices.example.product.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午4:13
* created by fuck~
**/
@RestController
@RequestMapping("/categories")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> findAll() {
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return this.categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto create(CategoryDto categoryDto) {
        return this.categoryService.create(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.categoryService.delete(id);
    }
}
