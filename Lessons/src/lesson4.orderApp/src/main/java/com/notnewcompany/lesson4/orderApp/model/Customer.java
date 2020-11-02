package com.notnewcompany.lesson4.orderApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Заказчик
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    /**
     * Имя заказчика
     */

    private String name;

    /**
     * Email заказчика
     */

    private String email;

}
