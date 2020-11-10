package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.repository.MessageRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

 private final MessageRepository messageRepository;
 private final UserRepository userRepository;

 @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
     this.userRepository = userRepository;
 }




}
