package com.example.ecommerce.responses;

import com.example.ecommerce.dto.ProductUserDTO;
import com.example.ecommerce.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class ProductsResponse extends Response {
    private List<ProductUserDTO> products;

    public ProductsResponse(String message, List<Product> products) {
        super(message);
        this.products = products.stream()
                .map(ProductUserDTO::new)
                .collect(Collectors.toList());;
    }
}