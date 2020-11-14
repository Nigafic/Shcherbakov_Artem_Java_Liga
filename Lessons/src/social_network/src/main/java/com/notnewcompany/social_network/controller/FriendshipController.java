package com.notnewcompany.social_network.controller;

import com.notnewcompany.social_network.model.Friendship;
import com.notnewcompany.social_network.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;


    /**
     * Создает связь "Дружба"
     *
     * @param senderId Id отправителя дружбы
     * @param recipientId Id принимающего дружбу
     * @return дружба
     */
    @PostMapping ("friends/{senderId}/{recipientId}")
    public Friendship makeFriends(@PathVariable Long senderId, @PathVariable Long recipientId){
        return friendshipService.makeFriends (senderId, recipientId);

    }

    /**
     * Находит список друзей пользователя
     *
     * @param userId Id пользователя
     * @return список друзей пользователя List<Friendship>
     */
    @GetMapping("/friends/{userId}")
    public List<Friendship> findMyFriendship(@PathVariable Long userId){

        return  friendshipService.findMyFriendship(userId);
    }

    /**
     * Находит все дружеские связи
     *
     * @return лист дружб List<Friendship>
     */
    @GetMapping ("/friends")
    public List<Friendship> findAllFriendship () {
        return friendshipService.findAllFriendship();
    }

}
