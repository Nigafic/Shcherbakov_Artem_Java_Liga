package com.notnewcompany.social_network.controller;


import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping (path = "/add")
    public String createUser (@RequestBody WebUser user){
        userService.createUser(user);
        return "user";
    }

}
