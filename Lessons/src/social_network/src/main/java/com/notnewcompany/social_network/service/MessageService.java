package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Message;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.MessageRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

 private MessageRepository messageRepository;
 private UserRepository userRepository;

 @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
 }

 public Message findUserById(Long senderId){
     return messageRepository.findById(senderId).get();
 }

 public Message postMessage (Long senderId, Long recipientId, String text) {
     Message message = Message.builder().build();
     message.setMessageText(text);
     message.setId(senderId);

     return messageRepository.save(message);
 }

    public Message createMessage(WebUser senderUser, WebUser recipientUser, String text) {
        Message message = Message.builder().build();
        message.setMessageText(text);

        return messageRepository.save(message);
    }

}
