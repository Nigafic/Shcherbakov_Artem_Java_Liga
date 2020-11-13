package com.notnewcompany.social_network.controller;

import com.notnewcompany.social_network.model.Message;
import com.notnewcompany.social_network.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/users/{senderId}/messages/{recipientId}")
    public Message postMessage(@PathVariable Long senderId, @PathVariable Long recipientId) {
        return messageService.postMessage(senderId, recipientId, "Something text" );
    }

    @GetMapping("/users/messages")
    public List<Message> getMessage(){
        return messageService.findAll() ;
    }

}
