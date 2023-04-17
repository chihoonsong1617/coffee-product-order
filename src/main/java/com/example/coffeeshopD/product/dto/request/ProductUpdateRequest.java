package com.example.coffeeshopD.product.dto.request;

import java.time.LocalDate;

public class ProductUpdateRequest {
    private Long id;
    private String productName;
    private Long price;
    private String origin;
    private String description;
    private String expirationDate;
    private String producer;
    private String weight;
    public Long getId() {return id;}
    public String getProductName() {
        return productName;
    }

    public Long getPrice() {
        return price;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDescription() {
        return description;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getProducer() {
        return producer;
    }

    public String getWeight() {
        return weight;
    }
}
