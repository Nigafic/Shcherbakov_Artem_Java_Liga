package com.notnewcompany.social_network.controller;


import com.notnewcompany.social_network.dto.UserDTO;
import com.notnewcompany.social_network.dto.UserRegistrationDto;
import com.notnewcompany.social_network.model.Message;
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
    public WebUser registrationUser (@RequestBody UserRegistrationDto newUser){
        return userService.registrationUser(newUser);
    }

    @PostMapping ("/users")
    public WebUser newUser (@RequestBody WebUser newUser){
        return userService.createUser(newUser);
    }

    @PostMapping ("/users/{id}/messages")
    public Message newMessage (@PathVariable (value = "id") Long senderId, @RequestBody WebUser recipientUser) {
        return userService.createMessage(userService.findUserById(senderId),recipientUser,"Something text");
    }

    @PutMapping("/users/{id}")
    public WebUser updateUser (@PathVariable (value = "id") Long id, @RequestBody UserDTO userDTO){
            return userService.updateUser(id, userDTO);
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
