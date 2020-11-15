package com.notnewcompany.social_network.controller;

import com.notnewcompany.social_network.model.Friendship;
import com.notnewcompany.social_network.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping ("/friends/{senderId}/{recipientId}")
    public Friendship makeFriends(@PathVariable Long senderId, @PathVariable Long recipientId){
        return friendshipService.makeFriends (senderId, recipientId);

    }

    /**
     * Находит одного друга по Id
     *
     * @param senderId Id пользователя
     * @param recipientId Id друга, которого нужно найти
     * @return Дружбу Friendship и null если друг не найден
     */
    @GetMapping ("/friends/{senderId}/{recipientId}")
    public Friendship findMyFriend(@PathVariable Long senderId, @PathVariable Long recipientId){
        return friendshipService.findMyFriend (senderId, recipientId);

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
     * Удаляет пользователя
     *
     * @param userId          Id пользователя
     * @param deleteFriendsId Id Удаляемого друга
     */
    @DeleteMapping ("/friends/{userId}/{deleteFriendsId}")
    public void deleteFriends(@PathVariable Long userId, @PathVariable Long deleteFriendsId) {
        friendshipService.deleteFriends (userId, deleteFriendsId);
    }
}
