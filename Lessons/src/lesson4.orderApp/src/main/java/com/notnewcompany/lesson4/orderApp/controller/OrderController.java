package com.notnewcompany.lesson4.orderApp.controller;

import com.notnewcompany.lesson4.orderApp.model.Order;
import com.notnewcompany.lesson4.orderApp.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {
    @Autowired
    public OrderService orderService;

    /**
     * Создание Заказа
     * @param order
     * @return Строка с Заказом
     */
    @PostMapping("/order")
    public String createOrderPost(@RequestBody Order order) {
        orderService.createOrder(order);
        return order.toString();

    }
}
