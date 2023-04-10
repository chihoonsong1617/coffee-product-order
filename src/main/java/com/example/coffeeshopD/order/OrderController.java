package com.example.coffeeshopD.order;

import com.example.coffeeshopD.order.dto.request.OrderCreateRequest;
import com.example.coffeeshopD.order.dto.request.OrderUpdateRequest;
import com.example.coffeeshopD.order.dto.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class OrderController {

    @Autowired
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Create
    @PostMapping("/order")
    public void createOrder(@RequestBody OrderCreateRequest request) {
        orderService.createOrder(request);
    }
//    @GetMapping("/order")
//    public List<OrderResponse> readOrders() {
//        return orderService.getOrders();
//    }
////    @PutMapping("/order")
//    public void updateUser(@RequestBody OrderUpdateRequest request) {
//        orderService.updateOrder(request);
//    }
}
