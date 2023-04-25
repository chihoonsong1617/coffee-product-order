package com.example.coffeeshopD.order;

import com.example.coffeeshopD.product.Product;
import jakarta.persistence.*;

import java.util.ArrayList;


@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false, name = "address")
    private String address;
    @Column(nullable = false, name = "deliverayDepartureTime")
    private String deliveryDepartureTime; // 배송 출발 시간
    @Column(nullable = false, name = "deliveryFee")
    private Long deliveryFee;
    @Column(nullable = false, name = "orderRequest")
    private String orderRequest; // 주문 요청 사항
    @Column(nullable = false, name = "product")
    @OneToMany(mappedBy = "order")   // 주문 하나당 여러개의 product를 가지게 된다.
    private ArrayList<Product> product;
    @Column(nullable = false, name = "releaseTime")
    private String releaseTime; // 상품 출고 시간
    @Column(nullable = false, name = "withdrawOrder")
    private boolean withdrawOrder; // 주문 취소 여부

    protected Order() {

    }

    public Order(String address, String deliveryDepartureTime,
                 Long deliveryFee, String orderRequest, ArrayList<Product> product,
                 String releaseTime, boolean withdrawOrder) {
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
