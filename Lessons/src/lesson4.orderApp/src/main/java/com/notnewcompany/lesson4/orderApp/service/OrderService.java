package com.notnewcompany.lesson4.orderApp.service;

import com.notnewcompany.lesson4.orderApp.model.Order;
import com.notnewcompany.lesson4.orderApp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {
    OrderRepository orderRepository;

    /**
     * Создание заказа
     * @param order
     * @return
     */
    public int createOrder(Order order) {
        return orderRepository.createOrder(order);
    }
}
