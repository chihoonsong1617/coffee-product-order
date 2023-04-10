package com.example.coffeeshopD.order;

import com.example.coffeeshopD.order.dto.request.OrderCreateRequest;
import com.example.coffeeshopD.order.dto.request.OrderUpdateRequest;
import com.example.coffeeshopD.order.dto.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void createOrder(OrderCreateRequest request) {
        orderRepository.saveOrder(request);
    }
//    public List<OrderResponse> getOrders() {
//        return orderRepository.getOrders();
//    }

//    public void deleteOrder(OrderUpdateRequest request) {
//    }
}