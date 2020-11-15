package com.notnewcompany.social_network.controller;


import com.notnewcompany.social_network.dto.UserFastRegistrationDto;
import com.notnewcompany.social_network.dto.UserRegistrationDto;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    /**
     * Быстрая регистация
     *
     * @param newUser DTO для регистации
     * @return незаполненный WebUser
     */
    @PostMapping("/registration")
    public WebUser registrationUser(@RequestBody UserFastRegistrationDto newUser) {
        return userService.registrationUser(newUser);
    }

    /**
     * Создает пользователя
     *
     * @param newUser Стандартная регистация
     * @return WebUser
     */
    @PostMapping("/users")
    public WebUser newUser(@RequestBody UserRegistrationDto newUser) {
        return userService.createUser(newUser);
    }


    /**
     * Обновление по основным параметрам
     *
     * @param id                  Пользователя
     * @param userRegistrationDto DTO подходит и для простого обновления
     * @return Обновленного пользователя либо null елси пользователя нет
     */
    @PutMapping("/users/{id}")
    public WebUser updateUser(@PathVariable(value = "id") Long id, @RequestBody UserRegistrationDto userRegistrationDto) {
        return userService.updateUser(id, userRegistrationDto);
    }


    /**
     * Максимальное обновление пользователя (кроме ID)
     *
     * @param id      ID пользователя
     * @param webUser для обновления
     * @return обновленного пользователя
     */
    @PutMapping("/users/maxUpdate/{id}")
    public WebUser maxUpdateUser(@PathVariable(value = "id") Long id, @RequestBody WebUser webUser) {
        return userService.maxUpdateUser(id, webUser);
    }

    /**
     * находит всех пользователей
     *
     * @return Список Пользователей
     */
    @GetMapping("/users")
    public List<WebUser> allUsers() {
        return userService.findAll();
    }

    /**
     * Находит пользователя по Id
     *
     * @param id Id Пользователя
     * @return Пользователя WebUser
     */
    @GetMapping("/users/{id}")
    public WebUser findByUserId(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    /**
     * Удаляет пользователя
     *
     * @param id пользователя для удаления
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
