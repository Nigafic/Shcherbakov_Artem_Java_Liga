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
    public Iterable<Message> findMessagesByUserId (@PathVariable Long senderId) {
        return messageService.findMessagesByUserId(senderId);
    }


    @GetMapping("/users/messages")
    public List<Message> allMessages(){
        return messageService.findAll();
    }

}
