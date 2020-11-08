package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public WebUser createUser (WebUser user) {
        return userRepository.save(user);
    }

    public List<WebUser> findAll() {
       return (List<WebUser>) userRepository.findAll();
    }

    public Optional<WebUser> userOne(Long id) {
       return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
