package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.dto.UserFastRegistrationDto;
import com.notnewcompany.social_network.dto.UserRegistrationDto;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.MessageRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private MessageRepository messageRepository;

    @Autowired
    public UserService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }


    public WebUser createUser(UserRegistrationDto user) {

        WebUser webUser = userRepository.save(
                WebUser.builder().
                        firstName(user.getFirstName()).
                        lastName(user.getLastName()).
                        country(user.getCountry()).
                        age(user.getAge()).
                        gender(user.getGender()).
                        email(user.getEmail()).
                        email(user.getEmail()).
                        build()
        );
        return webUser;
    }

    public WebUser registrationUser(UserFastRegistrationDto userFastRegistrationDto) {
        WebUser user = WebUser.builder().
                firstName(userFastRegistrationDto.getFirstName()).
                email(userFastRegistrationDto.getEmail())
                .build();

        return userRepository.save(user);

    }

    public List<WebUser> findAll() {
        return (List<WebUser>) userRepository.findAll();
    }

    public WebUser findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public WebUser updateUser(Long id, UserRegistrationDto userRegistrationDto) {
        if (userRepository.findById(id).isPresent()) {
            WebUser user = userRepository.findById(id).get();

            user.setAge(userRegistrationDto.getAge());
            user.setCountry(userRegistrationDto.getCountry());
            user.setFirstName(userRegistrationDto.getFirstName());
            user.setLastName(userRegistrationDto.getLastName());
            user.setGender(userRegistrationDto.getGender());
            user.setEmail(userRegistrationDto.getEmail());

            return userRepository.save(user);

        } else
            return null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
