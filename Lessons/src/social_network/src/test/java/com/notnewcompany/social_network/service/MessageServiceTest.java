package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Message;
import com.notnewcompany.social_network.repository.MessageRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MessageRepository messageRepository;

    @Test
    void postMessage() {
        Long senderId = 4L;
        Long recipientId = 1L;

        Message message = messageService.postMessage(1L, 4L, "Text");
        Assert.assertNotNull(message);


    }
}