package com.example.ecommerce.service;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.UserProfile;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserProfileRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.ecommerce.exceptions.BadRequestException;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserProfileRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getUserOrders(String username) {
        return orderRepository.findByCustomer_Username(username);
    }

    @Transactional
    public Order placeOrder(String username, List<OrderItem> orderItems) {
        UserProfile customer = userRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));

        Order order = new Order();
        order.setCustomer(customer);

        for (OrderItem item : orderItems) {
            String productCode = item.getProduct().getCode();

            Product product = productRepository.findById(productCode)
                    .orElseThrow(() -> new RuntimeException("Product not found: " + productCode));

            if (item.getQuantity() > product.getQuantity()) {
                throw new BadRequestException("Not enough stock for product: " + product.getName());
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());

            item.setProduct(product);
            item.setOrder(order);
        }

        order.setItems(orderItems);
        Order savedOrder = orderRepository.save(order);
        entityManager.refresh(savedOrder);
        return savedOrder;
    }
}
