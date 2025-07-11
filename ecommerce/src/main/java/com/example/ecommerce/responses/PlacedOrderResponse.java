package com.example.ecommerce.responses;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.model.Order;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlacedOrderResponse extends Response {
    private OrderDTO order;

    public PlacedOrderResponse(String message, Order order) {
        super(message);
        this.order = new OrderDTO(order);
    }
}
