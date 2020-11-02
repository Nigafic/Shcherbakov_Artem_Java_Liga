package com.notnewcompany.lesson4.orderApp.repository;

import com.notnewcompany.lesson4.orderApp.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class OrderRepository {


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
