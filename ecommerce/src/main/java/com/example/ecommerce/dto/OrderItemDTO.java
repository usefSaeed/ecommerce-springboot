package com.example.ecommerce.dto;

import com.example.ecommerce.model.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private int id;
    private int quantity;
    private ProductUserDTO product;

    public OrderItemDTO(OrderItem item) {
        this.id = item.getId();
        this.quantity = item.getQuantity();
        this.product = new ProductUserDTO(item.getProduct());
    }

}