package com.notnewcompany.lesson4.orderApp.service;

import com.notnewcompany.lesson4.orderApp.model.Order;
import com.notnewcompany.lesson4.orderApp.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    OrderService orderService;

    @Test
    void createOrderTest() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(orderRepository);

        Order order = new Order("Order", 50);

        when(orderService.createOrder(order)).thenReturn(0);

        assertEquals(orderService.createOrder(order), 0);

        verify(orderRepository, atLeastOnce()).createOrder(order);



    }
}