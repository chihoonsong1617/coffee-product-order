package com.example.coffeeshopD.product;

import com.example.coffeeshopD.product.dto.request.ProductCreateRequest;
import com.example.coffeeshopD.product.dto.request.ProductUpdateRequest;
import com.example.coffeeshopD.product.dto.response.ProductResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ProductJDBCRepository {
    private final JdbcTemplate jdbcTemplate;
    public ProductJDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createProduct(ProductCreateRequest request) {
        String sql = "INSERT INTO product (productName, price, description, origin, expirationDate, producer, weight) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, request.getProductName(), request.getPrice(),
                request.getDescription(),
                request.getOrigin(), request.getExpirationDate(),
                request.getProducer(), request.getWeight());
    }
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
                String expirationDate = rs.getString("expirationDate");
                String producer = rs.getString("producer");
                String weight = rs.getString("weight");
                return new ProductResponse(id, productName, price, description,
                        origin, expirationDate, producer, weight);
            }
        });
    }
    public void updateProductPrice(ProductUpdateRequest request) {
        String productCheckSQL = "SELECT * FROM product WHERE id = ?";
        boolean isProductNotExist = jdbcTemplate.query(productCheckSQL, (rs, rowNum) -> 0,
                request.getId()).isEmpty();
        if (isProductNotExist) throw new IllegalArgumentException();
        String updateSQL = "UPDATE product SET price = ? WHERE id = ?";
        jdbcTemplate.update(updateSQL, request.getPrice(), request.getId());
    }

    public void deleteProduct(String productName) {
        String productCheckSQL = "SELECT * FROM product WHERE productName = ?";
        boolean isProductNotExist = jdbcTemplate.query(productCheckSQL, (rs, rowNum) -> 0,
                productName).isEmpty();
        if (isProductNotExist) throw new IllegalArgumentException();
        String deleteSQL = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(deleteSQL, productName);
    }
}