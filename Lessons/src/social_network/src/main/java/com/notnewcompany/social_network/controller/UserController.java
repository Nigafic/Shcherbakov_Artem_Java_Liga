package com.notnewcompany.social_network.controller;


import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping (path = "/users")
    public WebUser newUser (@RequestBody WebUser newUser){

        return userService.createUser(newUser);

    }

    @GetMapping (path = "/users")
    public List<WebUser> allUsers ( ){

        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<WebUser> userOne (@PathVariable Long id) {
        return userService.userOne(id);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
