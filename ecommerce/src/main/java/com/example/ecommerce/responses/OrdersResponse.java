package com.example.ecommerce.responses;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.model.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class OrdersResponse extends Response {
    private List<OrderDTO> orders;

    public OrdersResponse(String message, List<Order> orders) {
        super(message);
        this.orders = orders.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());;
    }
}