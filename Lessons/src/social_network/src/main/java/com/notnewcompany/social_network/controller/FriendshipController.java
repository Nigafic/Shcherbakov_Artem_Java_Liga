package com.notnewcompany.social_network.controller;

import com.notnewcompany.social_network.model.Friendship;
import com.notnewcompany.social_network.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;


    @PostMapping ("friends/{senderId}/{recipientId}")
    public Friendship makeFriends(@PathVariable Long senderId, @PathVariable Long recipientId){
        return friendshipService.makeFriends (senderId, recipientId);

    }

    @GetMapping ("/friends")
    public List<Friendship> findAll () {
        return friendshipService.findAll();
    }

}