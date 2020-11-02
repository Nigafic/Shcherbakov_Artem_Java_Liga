package com.notnewcompany.lesson4.orderApp.repository;

import com.notnewcompany.lesson4.orderApp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * Создание заказа
     * @param order
     * @return
     */
public int createOrder (Order order) {

    ;
    return jdbcTemplate.update("INSERT INTO ORDERS  (NAME ,PRICE )" +
            " VALUES (?, ?)", new Object[]{
            order.getName(), order.getPrice()
    });
}

}
