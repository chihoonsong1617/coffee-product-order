package com.example.coffeeshopD.product.dto.response;

import java.time.LocalDate;
import java.util.Date;

public class ProductResponse {
    private long id;
    private String productName;
    private Long price;
    private String description;
    private String origin;
    private String expirationDate;
    private String producer;
    private String weight;

    public ProductResponse(long id, String productName, Long price,
                           String description, String origin,
                           String expirationDate,
                           String producer, String weight) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.origin = origin;
        this.expirationDate = expirationDate;
        this.producer = producer;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getOrigin() {
        return origin;
    }

    public String getExpirationDate() { return expirationDate; }

    public String getProducer() {
        return producer;
    }

    public String getWeight() {
        return weight;
    }
}
