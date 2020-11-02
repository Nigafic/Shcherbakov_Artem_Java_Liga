package com.notnewcompany.lesson4.orderApp.repository;

import com.notnewcompany.lesson4.orderApp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     *  @param order
     * @return
     */
public String createOrder (Order order) {

    jdbcTemplate.update("INSERT INTO ORDERS  (NAME ,PRICE )" +
            " VALUES (?, ?)", new Object[]{
            order.getName(), order.getPrice()
    });

    return String.format("Added %s %d", order.getName(), order.getPrice()) ;
}

}
