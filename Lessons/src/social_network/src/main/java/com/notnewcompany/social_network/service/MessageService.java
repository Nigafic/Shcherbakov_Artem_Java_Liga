package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Message;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.MessageRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

 private MessageRepository messageRepository;
 private UserRepository userRepository;

 @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
     this.userRepository = userRepository;
 }

 public Message findUserById(Long senderId){
     return messageRepository.findById(senderId).get();
 }

 public Message postMessage (Long senderId, Long recipientId, String text) {

     WebUser sender = userRepository.findById(senderId).get();
     WebUser recipient = userRepository.findById(recipientId).get();
     Message message = new Message();

     message.setSender(sender);
     message.setRecipient(recipient);

     message.setMessageText(text);

     return messageRepository.save(message);
 }

    public List<Message> findAll() {
        return (List<Message>) messageRepository.findAll();
    }

}
