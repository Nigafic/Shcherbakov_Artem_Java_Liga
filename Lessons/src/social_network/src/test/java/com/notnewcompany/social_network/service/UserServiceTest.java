package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.dto.UserFastRegistrationDto;
import com.notnewcompany.social_network.dto.UserRegistrationDto;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void createUser() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        WebUser webUser = userService.createUser(userRegistrationDto);

        Assert.assertNotNull(webUser);

        //Mockito.verify(userRepository, Mockito.times(1)).save(webUser);


    }

    @Test
    void registrationUser() {
        UserFastRegistrationDto userFastRegistrationDto = new UserFastRegistrationDto();
        userFastRegistrationDto.setEmail("email");
        userFastRegistrationDto.setFirstName("Cat");

    WebUser webUser = userService.registrationUser(userFastRegistrationDto);

    Assert.assertNotNull(webUser);
    Assert.assertEquals("email",webUser.getEmail());
    Assert.assertEquals("Cat",webUser.getFirstName());

    }

    @Test
    void findUserById() {
        WebUser webUser = userService.findUserById(4L);
        Assert.assertNotNull(webUser);

    }

    @Test
    void updateUser() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        WebUser webUser = userService.updateUser(4L, userRegistrationDto);

        Assert.assertNotNull(webUser);
    }

    @Test
    void maxUpdateUser() {

        WebUser webUserUpdater = new WebUser();

        WebUser webUser = userService.maxUpdateUser(4L, webUserUpdater);

        Assert.assertNotNull(webUser);

    }

    @Test
    void deleteById() {

        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        WebUser webUser = userService.createUser(userRegistrationDto);

        userService.deleteById(2L);


    }
}