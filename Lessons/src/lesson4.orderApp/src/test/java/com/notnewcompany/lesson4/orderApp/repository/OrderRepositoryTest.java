package com.notnewcompany.lesson4.orderApp.repository;

import com.notnewcompany.lesson4.orderApp.model.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class OrderRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;


    OrderRepository orderRepository;

    @Test
    void createOrderTest() {

        MockitoAnnotations.initMocks(this);
        orderRepository = new OrderRepository(jdbcTemplate);

        Order order = new Order("Order", 59);

        when(orderRepository.createOrder(order)).thenReturn(1);
        assertEquals(orderRepository.createOrder(order), 1);

    }
}
