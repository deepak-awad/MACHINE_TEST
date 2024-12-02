package com.example.demo.Dao;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID")
    @SequenceGenerator(name = "CATEGORY_ID", sequenceName = "CATEGORY_SEQ", allocationSize = 1)
    private Long categoryId;

    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

    // Default Constructor
    public Category() {
        super();
    }

    // Parameterized Constructor
    public Category(String name) {
        super();
        this.categoryName = name;
    }

    // Getters and Setters
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    @JsonIgnoreProperties("category")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
 
}
