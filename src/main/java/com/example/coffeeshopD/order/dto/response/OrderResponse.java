package com.example.coffeeshopD.order.dto.response;

import com.example.coffeeshopD.product.Product;

import java.util.ArrayList;

public class OrderResponse {
    private Long orderId;
    private String address;
    private String deliveryDepartureTime; // 배송 출발 시간
    private Long deliveryFee;
    private String orderRequest; // 주문 요청 사항
    private ArrayList<Product> product;     // 주문이 가지고 있는 상품들
    private String releaseTime; // 상품 출고 시간
    private boolean withdrawOrder; // 주문 취소 여부

    public OrderResponse(Long orderId, String address, String deliveryDepartureTime,
                         Long deliveryFee, String orderRequest, ArrayList<Product> product,
                         String releaseTime, boolean withdrawOrder) {
        this.orderId = orderId;
        this.address = address;
        this.deliveryDepartureTime = deliveryDepartureTime;
        this.deliveryFee = deliveryFee;
        this.orderRequest = orderRequest;
        this.product = product;
        this.releaseTime = releaseTime;
        this.withdrawOrder = withdrawOrder;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public String getDeliveryDepartureTime() {
        return deliveryDepartureTime;
    }

    public Long getDeliveryFee() {
        return deliveryFee;
    }

    public String getOrderRequest() {
        return orderRequest;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public boolean isWithdrawOrder() {
        return withdrawOrder;
    }
}
