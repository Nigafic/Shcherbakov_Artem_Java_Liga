package com.notnewcompany.lesson4.orderApp.controller;

import com.notnewcompany.lesson4.orderApp.model.Order;
import com.notnewcompany.lesson4.orderApp.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    OrderService orderService;

    OrderController orderController;

    @Test
    void createOrder() {
        MockitoAnnotations.initMocks(this);

        orderController = new OrderController(orderService);

        Order order = new Order("Order", 50);

        orderController.createOrderPost(order);

        verify(orderService, atLeastOnce()).createOrder(order);
    }
}