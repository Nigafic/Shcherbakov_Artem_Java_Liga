package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Message;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.MessageRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Создаает сообщение и заносит его в БД
     *
     * @param senderId    Id отправителя сообщения
     * @param recipientId Id принимающего сообшение
     * @param text        текст сообщения
     * @return Обьект Сообщения
     */
    public Message postMessage(Long senderId, Long recipientId, String text) {

        WebUser sender;
        WebUser recipient;
        if (userRepository.findById(senderId).isPresent() &&
                userRepository.findById(recipientId).isPresent()) {

            sender = userRepository.findById(senderId).get();
            recipient = userRepository.findById(recipientId).get();
            Message message = new Message();

            message.setSender(sender);
            message.setRecipient(recipient);
            message.setMessageText(text);

            return messageRepository.save(message);
        }
        return null;
    }

    /**
     * Находит сообщения пользователя по ID пользователя
     *
     * @param senderId ID пользователя
     * @return List сообщений
     */

    public List<Message> findMessagesByUserId(Long senderId) {

        List<Message> messageList = new ArrayList<>();

        for (Message message : findAll()) {
            if (message.getSender().getId().equals(senderId)) {
                messageList.add(message);
            }
        }
        return messageList;
    }

    /**
     * @return возвращает список всех сообщений
     */
    public List<Message> findAll() {
        return (List<Message>) messageRepository.findAll();
    }

    /**
     * Выдает определенное сообщение
     *
     * @param senderId    Id пользователя, отправляющего сообщение
     * @param recipientId Id пользователя, принимающего сообщение
     * @return Лист сообщений
     */
    public List<Message> findMessage(Long senderId, Long recipientId) {

        List<Message> messageList = findMessagesByUserId(senderId);

        messageList.removeIf(message -> !message.getRecipient().getId().equals(recipientId));

        return messageList;
    }

    /**
     * Сообщения
     *
     * @param senderId    Id отправителя
     * @param recipientId Id получателя
     */
    public void deleteMessage(Long senderId, Long recipientId) {

        for (Message message : findAll()) {
            if (message.getSender().getId().equals(senderId) && message.getRecipient().getId().equals(recipientId)) {
                messageRepository.delete(message);
            }
        }
    }


}
