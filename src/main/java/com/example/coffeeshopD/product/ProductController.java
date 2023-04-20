package com.example.coffeeshopD.product;

import com.example.coffeeshopD.product.dto.request.ProductCreateRequest;
import com.example.coffeeshopD.product.dto.request.ProductUpdateRequest;
import com.example.coffeeshopD.product.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/createProduct")
    public void createProduct(@RequestBody ProductCreateRequest request) {
        productService.createProduct(request);
    }

    @GetMapping("/getProducts")
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }
    @PutMapping("/updateProductPrice")
    public void updateProductPrice(@RequestBody ProductUpdateRequest request) {
        productService.updateProductPrice(request);
    }
    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestParam String productName) {
        productService.deleteProduct(productName);
    }



    /*controller finish*/
}
