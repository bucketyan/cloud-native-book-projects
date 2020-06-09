package com.fuck.cloudnative.monolith.example.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuck.cloudnative.monolith.example.commons.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午3:02
* created by fuck~
**/
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends AbstractEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;

    public Category(@NotNull String name, @NotNull String description, Set<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(description, category.description) &&
                Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
