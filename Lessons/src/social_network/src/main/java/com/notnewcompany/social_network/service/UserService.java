package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public WebUser createUser (WebUser user) {
        return userRepository.save(user);
    }



}
