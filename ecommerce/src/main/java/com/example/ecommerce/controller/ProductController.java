package com.example.ecommerce.controller;

import com.example.ecommerce.responses.ProductsResponse;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Register a new user
    @GetMapping("")
    public ResponseEntity<ProductsResponse> getAll() {
        return ResponseEntity.ok(new ProductsResponse("Product Retrieval Successful!",
                productService.getAll()));
    }
}
