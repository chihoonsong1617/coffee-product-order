package com.example.coffeeshopD.product.dto.request;

import java.time.LocalDate;

public class ProductCreateRequest {
    private String description;
    private String expirationDate;
    private String origin;
    private Long price;
    private String producer;
    private String productName;
    private String weight;

    public ProductCreateRequest(String description, String expirationDate, String origin, Long price, String producer, String productName, String weight) {
        this.description = description;
        this.expirationDate = expirationDate;
        this.origin = origin;
        this.price = price;
        this.producer = producer;
        this.productName = productName;
        this.weight = weight;
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
}
