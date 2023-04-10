package com.example.coffeeshopD.product;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 255, name = "productName")
    private String productName;                // 제품명

    @Column(nullable = false, name = "price")
    private Long price;                        // 가격

    @Column(nullable = false, name = "description")
    private String description;                // 설명

    @Column(nullable = false, name = "origin")
    private String origin;                     // 원산지

    @Column(nullable = false, name = "expirationDate")
    private Date expirationDate;          // 유통기한

    @Column(nullable = false, name = "producer")
    private String producer;                   // 생산자

    @Column(nullable = false, name = "weight")
    private String weight;                     // 용량

    protected Product() {}
    public Product(String productName, Long price, String description, String origin,
                   Date expirationDate, String producer, String weight) {
        this.productName = productName;
        this.price = price;
        this.origin = origin;
        this.description = description;
        this.expirationDate = expirationDate;
        this.producer = producer;
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public Long getPrice() {
        return price;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDescription() {return description;}

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getProducer() {
        return producer;
    }

    public String getWeight() {
        return weight;
    }
}
