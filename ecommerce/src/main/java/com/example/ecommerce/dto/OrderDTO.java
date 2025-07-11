package com.example.ecommerce.dto;

import com.example.ecommerce.model.Order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderDTO {
    private int id;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> items;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.createdAt = order.getCreatedAt();
        this.items = order.getItems().stream()
                .map(OrderItemDTO::new)
                .collect(Collectors.toList());
    }

}
