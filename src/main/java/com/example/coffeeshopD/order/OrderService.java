package com.example.coffeeshopD.order;

import com.example.coffeeshopD.order.dto.request.OrderCreateRequest;
import com.example.coffeeshopD.order.dto.request.OrderUpdateRequest;
import com.example.coffeeshopD.order.dto.response.OrderResponse;
import com.example.coffeeshopD.product.Product;
import com.example.coffeeshopD.product.ProductRepository;
import com.example.coffeeshopD.product.dto.request.ProductCreateRequest;
import com.example.coffeeshopD.product.dto.request.ProductUpdateRequest;
import com.example.coffeeshopD.product.dto.response.ProductResponse;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void createOrder(OrderCreateRequest request) {
        orderRepository.save(new Order(request.getAddress(),
                                       request.getDeliveryDepartureTime(),
                                       request.getDeliveryFee(),
                                       request.getOrderRequest(),
                                       request.getProduct(),
                                       request.getReleaseTime(),
                                       request.isWithdrawOrder()));
    }
    @Transactional
    public List<OrderResponse> getOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream()
                .map(order -> new OrderResponse(order.getOrderId(),
                        order.getAddress(),
                        order.getDeliveryDepartureTime(),
                        order.getDeliveryFee(),
                        order.getOrderRequest(),
                        order.getProduct(),
                        order.getReleaseTime(),
                        order.isWithdrawOrder()))
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateOrder(OrderUpdateRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(IllegalAccessError::new);
        orderRepository.save(order);
    }
    @Transactional
    public void deleteOrder(OrderUpdateRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(IllegalAccessError::new);
        orderRepository.delete(order);
    }
}