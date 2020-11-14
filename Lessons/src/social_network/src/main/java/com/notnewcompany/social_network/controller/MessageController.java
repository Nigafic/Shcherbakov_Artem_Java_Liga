package com.notnewcompany.social_network.controller;

import com.notnewcompany.social_network.dto.MessageSendDto;
import com.notnewcompany.social_network.model.Message;
import com.notnewcompany.social_network.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    public MessageService messageService;

    @PostMapping("/users/{senderId}/messages/{recipientId}")
    public Message postMessage(@PathVariable Long senderId, @PathVariable Long recipientId, @RequestBody MessageSendDto messageSendDto) {
        return messageService.postMessage(senderId, recipientId, messageSendDto.getText() );
    }

    @GetMapping ("users/{senderId}/messages")
    public List<Message> findMessagesByUserId (@PathVariable Long senderId) {
        return messageService.findMessagesByUserId(senderId);
    }


    @GetMapping ("/users/{senderId}/messages/{recipientId}")
    public List<Message> findMessage(@PathVariable Long senderId, @PathVariable Long recipientId) {
        return messageService.findMessage(senderId, recipientId);
    }


    @GetMapping("/users/messages")
    public List<Message> allMessages(){
        return messageService.findAll();
    }

}
