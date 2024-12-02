package com.example.demo.Dao;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_ID")
    @SequenceGenerator(name = "PRODUCT_ID", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    private Long productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_PRICE", nullable = false)
    private double productPrice;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;


    // Default Constructor
    public Product() {
        super();
    }

    // Parameterized Constructor
    public Product(String name, double price, Category category) {
        super();
        this.productName = name;
        this.productPrice = price;
        this.category = category;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
}
