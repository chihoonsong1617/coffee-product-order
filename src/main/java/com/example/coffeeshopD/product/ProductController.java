package com.example.coffeeshopD.product;

import com.example.coffeeshopD.product.dto.request.ProductCreateRequest;
import com.example.coffeeshopD.product.dto.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@RestController
public class ProductController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostMapping("/createProduct")
    public void createProduct(@RequestBody ProductCreateRequest request) {
        String sql = "INSERT INTO product (productName, price, description, origin, expirationDate, producer, weight) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, request.getProductName(), request.getPrice(),
                                 request.getDescription(),
                                 request.getOrigin(), request.getExpirationDate(),
                                 request.getProducer(), request.getWeight());
    }

    @GetMapping("/getProducts")
    public List<ProductResponse> getProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new RowMapper<ProductResponse>() {
            @Override
            public ProductResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String productName = rs.getString("productName");
                long price = rs.getLong("price");
                String description = rs.getString("description");
                String origin = rs.getString("origin");
                Date expirationDate = rs.getDate("expirationDate");
                String producer = rs.getString("producer");
                String weight = rs.getString("weight");
                return new ProductResponse(id, productName, price, description,
                                           origin, expirationDate, producer, weight);
            }
        });
    }
}
