package com.notnewcompany.social_network.controller;


import com.notnewcompany.social_network.dto.UserDTO;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public WebUser newUser (@RequestBody WebUser newUser){
        return userService.createUser(newUser);
    }

    @PutMapping("/users/{id}")
    public WebUser updateUser (@PathVariable (value = "id") Long id, @RequestBody UserDTO userDTO){
            return userService.updateUser(id, userDTO);
    }

    @GetMapping
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
