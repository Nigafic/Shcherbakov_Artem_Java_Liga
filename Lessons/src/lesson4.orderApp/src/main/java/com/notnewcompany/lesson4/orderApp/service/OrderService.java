package com.notnewcompany.lesson4.orderApp.service;

import com.notnewcompany.lesson4.orderApp.model.Order;
import com.notnewcompany.lesson4.orderApp.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderRepository orderRepository;

    public String createOrder(Order order) {
        return orderRepository.createOrder(order);
    }
}
