package com.example.coffeeshopD.order;

import com.example.coffeeshopD.order.dto.request.OrderCreateRequest;
import com.example.coffeeshopD.order.dto.request.OrderUpdateRequest;
import com.example.coffeeshopD.order.dto.response.OrderResponse;
import com.example.coffeeshopD.product.ProductService;
import com.example.coffeeshopD.product.dto.request.ProductCreateRequest;
import com.example.coffeeshopD.product.dto.request.ProductUpdateRequest;
import com.example.coffeeshopD.product.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/createOrder")
    public void createProduct(@RequestBody OrderCreateRequest request) {
        orderService.createOrder(request);
    }

    @GetMapping("/getOrders")
    public List<OrderResponse> getOrders() {
        return orderService.getOrders();
    }
    @PutMapping("/updateOrder")
    public void updateOrder(@RequestBody OrderUpdateRequest request) {
        orderService.updateOrder(request);
    }
    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestBody OrderUpdateRequest request) {
        orderService.deleteOrder(request);
    }
    /**/
}
