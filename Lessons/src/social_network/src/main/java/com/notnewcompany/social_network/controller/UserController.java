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

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/registration")
    public WebUser  registrationUser (@RequestBody UserFastRegistrationDto newUser){
        return userService.registrationUser(newUser);
    }

    @PostMapping ("/users")
    public WebUser newUser (@RequestBody UserRegistrationDto newUser){
        return userService.createUser(newUser);
    }

    @PutMapping("/users/{id}")
    public WebUser updateUser (@PathVariable (value = "id") Long id, @RequestBody UserRegistrationDto userRegistrationDto){
            return userService.updateUser(id, userRegistrationDto);
    }


    @GetMapping ("/users")
    public List<WebUser> allUsers ( ){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public WebUser findByUserId(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
