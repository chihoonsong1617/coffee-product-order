package com.example.coffeeshopD.order;

import com.example.coffeeshopD.product.Product;

import java.time.LocalDateTime;

public class Order {
    private Long orderId;
    private Product productName;
    private String address;
    private Long deliveryFee;
    private String deliveryDepartureTime; // 배송 출발 시간
    private String releaseTime; // 상품 출고 시간
    private String orderRequest; // 주문 요청 사항
    private boolean withdrawOrder; // 주문 취소 여부

    protected Order() {

    }

    public Order(Long orderId, Product productName, String address,
                 Long deliveryFee, String deliveryDepartureTime,
                 String releaseTime, String orderRequest,
                 boolean withdrawOrder) {
        this.orderId = orderId;
        this.productName = productName;
        this.address = address;
        this.deliveryFee = deliveryFee;
        this.deliveryDepartureTime = deliveryDepartureTime;
        this.releaseTime = releaseTime;
        this.orderRequest = orderRequest;
        this.withdrawOrder = withdrawOrder;
    }
    public Long getOrderId() {
        return orderId;
    }

    public Product getProductName() {
        return productName;
    }

    public String getAddress() {
        return address;
    }

    public Long getDeliveryFee() {
        return deliveryFee;
    }

    public String getDeliveryDepartureTime() {
        return deliveryDepartureTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public String getOrderRequest() {
        return orderRequest;
    }

    public boolean isWithdrawOrder() {
        return withdrawOrder;
    }
}
