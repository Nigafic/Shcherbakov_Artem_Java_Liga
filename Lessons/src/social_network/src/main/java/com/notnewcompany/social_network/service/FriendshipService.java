package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Friendship;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.FriendshipRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FriendshipRepository friendshipRepository;

    public Friendship makeFriends(Long senderId, Long recipientId ){

        WebUser sender = userRepository.findById(senderId).get();
        WebUser recipient = userRepository.findById(recipientId).get();
        Friendship friendship = new Friendship();

        friendship.setSender(sender);
        friendship.setRecipient(recipient);

        return friendshipRepository.save(friendship);
    }

    public List<Friendship> findAll () {
        return (List<Friendship>) friendshipRepository.findAll();
    }


}
