package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.dto.UserDTO;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public WebUser createUser(WebUser user) {
        return userRepository.save(user);
    }

    public List<WebUser> findAll() {
        return (List<WebUser>) userRepository.findAll();
    }

    public Optional<WebUser> userOne(Long id) {
        return userRepository.findById(id);
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

            return new WebUser(user.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getCountry(), userDTO.getAge(), userDTO.getGender());

        } else
            return null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
