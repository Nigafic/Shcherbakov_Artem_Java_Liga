package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.model.Friendship;
import com.notnewcompany.social_network.repository.FriendshipRepository;
import com.notnewcompany.social_network.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class FriendshipServiceTest {

    @Autowired
    private FriendshipService friendshipService;

    @Mock
    private FriendshipRepository friendshipRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    void makeFriends() {

        Friendship friendship = friendshipService.makeFriends(4L, 6L);

        assertNotNull(friendship);

    }
}