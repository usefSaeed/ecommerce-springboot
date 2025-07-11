package com.example.ecommerce.controller;

import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.responses.OrdersResponse;
import com.example.ecommerce.responses.PlacedOrderResponse;
import com.example.ecommerce.responses.Response;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.UserAuthService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<Response> getUserOrders(@AuthenticationPrincipal String username) {
        return ResponseEntity.ok(new OrdersResponse("Orders Retrieval Successful!",
                orderService.getUserOrders(username)));
    }

    @PostMapping("")
    public ResponseEntity<Response> placeOrder(
                @AuthenticationPrincipal String username,
                @RequestBody List<OrderItem> orderItems
            ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new PlacedOrderResponse("Orders Submitted Successfully!",
                orderService.placeOrder(username,orderItems)));
    }
}
