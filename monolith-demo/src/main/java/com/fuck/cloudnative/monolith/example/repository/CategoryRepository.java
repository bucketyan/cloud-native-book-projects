package com.fuck.cloudnative.monolith.example.repository;

import com.fuck.cloudnative.monolith.example.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
