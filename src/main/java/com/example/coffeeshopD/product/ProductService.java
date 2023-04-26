package com.example.coffeeshopD.product;

import com.example.coffeeshopD.product.dto.request.ProductCreateRequest;
import com.example.coffeeshopD.product.dto.request.ProductUpdateRequest;
import com.example.coffeeshopD.product.dto.response.ProductResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void createProduct(ProductCreateRequest request) {
        productRepository.save(new Product(request.getDescription(),
                                           request.getExpirationDate(),
                                           request.getOrigin(),
                                           request.getPrice(),
                                           request.getProducer(),
                                           request.getProductName(),
                                           request.getWeight()));
    }
    @Transactional
    public List<ProductResponse> getProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(product -> new ProductResponse(product.getId(),
                                                    product.getProductName(),
                                                    product.getPrice(),
                                                    product.getOrigin(),
                                                    product.getDescription(),
                                                    product.getExpirationDate(),
                                                    product.getProducer(),
                                                    product.getWeight()))
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateProductPrice(ProductUpdateRequest request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);
        productRepository.save(product);
    }
    @Transactional
    public void deleteProduct(String productName) {
        Product product = productRepository.findByProductName(productName);
        productRepository.delete(product);
    }
}
