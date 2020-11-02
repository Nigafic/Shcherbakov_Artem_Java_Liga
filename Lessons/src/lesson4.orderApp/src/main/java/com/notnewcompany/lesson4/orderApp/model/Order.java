package com.notnewcompany.lesson4.orderApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Объект заказа клиента
 */
@Getter
@Setter
public class Order {

    /**
     * Id заказа
     */
    @Id
private Long id;

    /**
     * Наименование продукта
     */
private String name;

    /**
     * Цена продукта
     */
private Integer price;

    public Order(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Order() {
    }

}
