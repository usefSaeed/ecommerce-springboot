package com.example.ecommerce.dto;

import com.example.ecommerce.model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUserDTO {
    private String code;
    private String name;
    private String description;
    private String imgLink;
    private double price;

    public ProductUserDTO(Product p) {
        this.code = p.getCode();
        this.name = p.getName();
        this.description = p.getDescription();
        this.imgLink = p.getImgLink();
        this.price = p.getPrice();
    }
}