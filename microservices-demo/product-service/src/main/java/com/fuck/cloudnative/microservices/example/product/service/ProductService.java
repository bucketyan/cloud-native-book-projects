package com.fuck.cloudnative.microservices.example.product.service;

import com.fuck.cloudnative.microservices.example.demo.commons.dto.ProductDto;
import com.fuck.cloudnative.microservices.example.product.entity.Product;
import com.fuck.cloudnative.microservices.example.product.entity.Review;
import com.fuck.cloudnative.microservices.example.product.entity.enumeration.ProductStatus;
import com.fuck.cloudnative.microservices.example.product.repository.CategoryRepository;
import com.fuck.cloudnative.microservices.example.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午4:00
* created by fuck~
**/
@Service
@Transactional
public class ProductService {
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public static ProductDto mapToDto(Product product) {
        if (product != null) {
            return new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getStatus().name(),
                    product.getSalesCounter(),
                    product.getReviews().stream().map(ReviewService::mapToDto).collect(Collectors.toSet()),
                    product.getCategory().getId()
            );
        }
        return null;
    }

    public List<ProductDto> findAll() {
        log.debug("Request to get all Products");
        return this.productRepository.findAll()
                .stream()
                .map(ProductService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        log.debug("Request to get Product : {}", id);
        return this.productRepository.findById(id).map(ProductService::mapToDto).orElse(null);
    }

    public ProductDto create(ProductDto productDto) {
        log.debug("Request to create Product : {}", productDto);

        return mapToDto(this.productRepository.save(
                new Product(
                        productDto.getName(),
                        productDto.getDescription(),
                        productDto.getPrice(),
                        ProductStatus.valueOf(productDto.getStatus()),
                        productDto.getSalesCounter(),
                        Collections.emptySet(),
                        categoryRepository.findById(productDto.getCategoryId()).orElse(null)
                )));
    }

    public ProductDto addReview(Long productId, Review review) {
        Product product = this.productRepository
                .findById(productId)
                .orElseThrow(() -> new IllegalStateException("The Product does not exist!"));
        product.getReviews().add(review);
        this.productRepository.saveAndFlush(product);
        return mapToDto(product);
    }

    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        this.productRepository.deleteById(id);
    }
}
