package com.example.coffeeshopD.order;

import com.example.coffeeshopD.order.dto.request.OrderCreateRequest;
import com.example.coffeeshopD.order.dto.response.OrderResponse;
import com.example.coffeeshopD.product.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveOrder(OrderCreateRequest request) {
        String sql = "INSERT INTO user (productName, address, deliveryFee, deliveryDepartureTime, releaseTime, orderRequest, withdrawOrder) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, request.getProductName(), request.getAddress(), request.getDeliveryFee(),
                                 request.getDeliveryDepartureTime(), request.getReleaseTime(),
                                 request.getOrderRequest(), request.isWithdrawOrder());
    }

//    public List<OrderResponse> getOrders() {
//        String sql = "SELECT * FROM order";
//        return jdbcTemplate.query(sql, new RowMapper<OrderResponse>() {
//            @Override
//            public OrderResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                Product productName -
//            }
//        })
//    }
}
