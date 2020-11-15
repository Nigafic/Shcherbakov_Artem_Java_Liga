package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Friendship;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.FriendshipRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService {

    private UserRepository userRepository;
    private FriendshipRepository friendshipRepository;

    @Autowired
    public FriendshipService(UserRepository userRepository, FriendshipRepository friendshipRepository) {
        this.userRepository = userRepository;
        this.friendshipRepository = friendshipRepository;
    }


    /**
     * Создает связь "Дружба"
     *
     * @param senderId    Id отправителя дружбы
     * @param recipientId Id принимающего дружбу
     * @return дружба
     */
    public Friendship makeFriends(@NotNull Long senderId, Long recipientId) {

        Friendship friendship = new Friendship();
        if (!senderId.equals(recipientId) &&
                (findMyFriend(senderId, recipientId) == null)) {
            WebUser sender;
            WebUser recipient;
            if (userRepository.findById(senderId).isPresent() &&
                    userRepository.findById(recipientId).isPresent()) {

                sender = userRepository.findById(senderId).get();
                recipient = userRepository.findById(recipientId).get();

                friendship.setSender(sender);
                friendship.setRecipient(recipient);

                System.out.println(friendship);
                return friendshipRepository.save(friendship);
            }
        }
        return null;
    }

    /**
     * Находит список друзей пользователя
     *
     * @param userId Id пользователя
     * @return список друзей пользователя List<Friendship>
     */
    public List<Friendship> findMyFriendship(Long userId) {
        List<Friendship> friendshipList = new ArrayList<>();

        for (Friendship friendship : friendshipRepository.findAll()) {
            if (friendship.getSender().getId().equals(userId)) {
                friendshipList.add(friendship);
            }
        }
        return friendshipList;
    }

    /**
     * Находит одного друга по Id
     *
     * @param senderId    Id пользователя
     * @param recipientId Id друга, которого нужно найти
     * @return Дружбу Friendship и null если друг не найден
     */
    public Friendship findMyFriend(Long senderId, Long recipientId) {

        for (Friendship friendship : findMyFriendship(senderId)) {
            if (friendship.getRecipient().getId().equals(recipientId)) {
                return friendship;
            }
        }
        return null;
    }


    /**
     * Находит все дружеские связи
     *
     * @return лист дружб List<Friendship>
     */
    public List<Friendship> findAllFriendship() {
        return (List<Friendship>) friendshipRepository.findAll();
    }


    /**
     * Удаляет пользователя
     *
     * @param userId          Id пользователя
     * @param deleteFriendsId Id Удаляемого друга
     */
    public void deleteFriends(Long userId, Long deleteFriendsId) {

        for (Friendship friendship : friendshipRepository.findAll()) {
            if (friendship.getSender().getId().equals(userId) && friendship.getRecipient().getId().equals(deleteFriendsId))
                friendshipRepository.delete(friendship);
        }
    }

}
