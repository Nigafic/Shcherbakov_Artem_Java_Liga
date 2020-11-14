package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Friendship;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.FriendshipRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FriendshipRepository friendshipRepository;


    /**
     * Создает связь "Дружба"
     *
     * @param senderId Id отправителя дружбы
     * @param recipientId Id принимающего дружбу
     * @return дружба
     */
    public Friendship makeFriends(Long senderId, Long recipientId ){

        WebUser sender = userRepository.findById(senderId).get();
        WebUser recipient = userRepository.findById(recipientId).get();
        Friendship friendship = new Friendship();

        friendship.setSender(sender);
        friendship.setRecipient(recipient);

        return friendshipRepository.save(friendship);
    }

    /**
     * Находит список друзей пользователя
     *
     * @param userId Id пользователя
     * @return список друзей пользователя List<Friendship>
     */
    public List <Friendship> findMyFriendship(Long userId){
        List<Friendship> friendshipList = new ArrayList<>();

        for (Friendship friendship : friendshipRepository.findAll()) {
            if (friendship.getSender().getId().equals(userId)) {
                friendshipList.add(friendship);
            }
        }
        return friendshipList;
    }


    /**
     * Находит все дружеские связи
     *
     * @return лист дружб List<Friendship>
     */
    public List<Friendship> findAllFriendship() {
        return (List<Friendship>) friendshipRepository.findAll();
    }


}
