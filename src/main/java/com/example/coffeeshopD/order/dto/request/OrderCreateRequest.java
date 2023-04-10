package com.example.coffeeshopD.order.dto.request;

import com.example.coffeeshopD.product.Product;

import java.time.LocalDateTime;

public class OrderCreateRequest {
    private Product productName;
    private String address;
    private Long deliveryFee;
    private LocalDateTime deliveryDepartureTime; // 배송 출발 시간
    private LocalDateTime releaseTime; // 상품 출고 시간
    private String orderRequest; // 주문 요청 사항
    private boolean withdrawOrder; // 주문 취소 여부


    public Product getProductName() {
        return productName;
    }

    public String getAddress() {
        return address;
    }

    public Long getDeliveryFee() {
        return deliveryFee;
    }

    public LocalDateTime getDeliveryDepartureTime() {
        return deliveryDepartureTime;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public String getOrderRequest() {
        return orderRequest;
    }

    public boolean isWithdrawOrder() {
        return withdrawOrder;
    }

}
