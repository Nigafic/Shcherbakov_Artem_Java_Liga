package com.notnewcompany.social_network.controller;

import com.notnewcompany.social_network.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/users/{senderId}/messages/{recipientId}")
    public String getMessage(@PathVariable Long senderId, @PathVariable Long recipientId){


        return "messageService.findUserById(senderId)";
    }

}
