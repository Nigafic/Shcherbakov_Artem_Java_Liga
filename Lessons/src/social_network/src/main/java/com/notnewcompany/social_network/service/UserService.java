package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.dto.UserDTO;
import com.notnewcompany.social_network.dto.UserRegistrationDto;
import com.notnewcompany.social_network.model.Message;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.MessageRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public UserService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }


    public Message createMessage ( WebUser senderUser, WebUser recipientUser, String text) {
        Message message = new Message();
        message.setMessageText(text);
        message.setSenderId(senderUser.getId());
        message.setRecipientId(recipientUser.getId());

        return messageRepository.save(message);
    }


    public WebUser createUser(WebUser user) {
        return userRepository.save(user);
    }

    public WebUser registrationUser (UserRegistrationDto userRegistrationDto) {

        WebUser user = WebUser.builder().
                firstName(userRegistrationDto.getFirstName()).
                email(userRegistrationDto.getEmail()).build();

        return userRepository.save(user);

    }

    public List<WebUser> findAll() {
        return (List<WebUser>) userRepository.findAll();
    }

    public WebUser findUserById(Long id) {
        return  userRepository.findById(id).get();
    }

    public WebUser updateUser(Long id, UserDTO userDTO) {
        if (userRepository.findById(id).isPresent()) {
            WebUser user = userRepository.findById(id).get();

            user.setAge(userDTO.getAge());
            user.setCountry(userDTO.getCountry());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setGender(userDTO.getGender());

            WebUser updatedUser = userRepository.save(user);

            return WebUser.builder()
                    .firstName(updatedUser.getFirstName())
                    .lastName(updatedUser.getLastName())
                    .country(updatedUser.getCountry())
                    .age(updatedUser.getAge())
                    .gender(updatedUser.getGender())
                    .build();


        } else
            return null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
