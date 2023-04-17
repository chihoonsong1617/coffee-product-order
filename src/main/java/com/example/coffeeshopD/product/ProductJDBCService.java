package com.example.coffeeshopD.product;

import com.example.coffeeshopD.product.dto.request.ProductCreateRequest;
import com.example.coffeeshopD.product.dto.request.ProductUpdateRequest;
import com.example.coffeeshopD.product.dto.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductJDBCService {
    private final ProductJDBCRepository productJDBCRepository;
    public ProductJDBCService(ProductJDBCRepository productReposistory) {
        this.productJDBCRepository = productReposistory;
    }
    public void createProduct(ProductCreateRequest request) {
        productJDBCRepository.createProduct(request);
    }
    public List<ProductResponse> getProducts() {
        return productJDBCRepository.getProducts();
    }
    public void updateProductPrice(ProductUpdateRequest request) {
        productJDBCRepository.updateProductPrice(request);
    }

    public void deleteProduct(String productName) {
        productJDBCRepository.deleteProduct(productName);
    }
}