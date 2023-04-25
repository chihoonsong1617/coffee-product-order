package com.example.coffeeshopD.product;

import com.example.coffeeshopD.order.Order;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, name = "description")
    private String description;                // 설명

    @Column(nullable = false, name = "expirationDate")
    private String expirationDate;          // 유통기한

    @Column(nullable = false, name = "order")
    @ManyToOne
    private Order order;                     // 주문
    @Column(nullable = false, name = "origin")
    private String origin;                     // 원산지

    @Column(nullable = false, name = "price")
    private Long price;                        // 가격

    @Column(nullable = false, name = "producer")
    private String producer;                   // 생산자

    @Column(nullable = false, length = 255, name = "productName")
    private String productName;                // 제품명

    @Column(nullable = false, name = "weight")
    private String weight;                     // 용량

    protected Product() {}

    public Product(String description, String expirationDate,
                   String origin, Long price, String producer, String productName,
                   String weight) {
        this.description = description;
        this.expirationDate = expirationDate;
        this.origin = origin;
        this.price = price;
        this.producer = producer;
        this.productName = productName;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getOrigin() {
        return origin;
    }

    public Long getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    public String getProductName() {
        return productName;
    }

    public String getWeight() {
        return weight;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
