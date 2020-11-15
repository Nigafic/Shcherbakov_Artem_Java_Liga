package com.notnewcompany.social_network.service;

import com.notnewcompany.social_network.dto.UserFastRegistrationDto;
import com.notnewcompany.social_network.dto.UserRegistrationDto;
import com.notnewcompany.social_network.model.WebUser;
import com.notnewcompany.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    /**
     * Создает пользователя
     *
     * @param user Стандартная регистация
     * @return WebUser
     */
    public WebUser createUser(UserRegistrationDto user) {

        return userRepository.save(
                WebUser.builder().
                        firstName(user.getFirstName()).
                        lastName(user.getLastName()).
                        country(user.getCountry()).
                        age(user.getAge()).
                        gender(user.getGender()).
                        email(user.getEmail()).
                        email(user.getEmail()).
                        build()
        );
    }

    /**
     * Быстрая регистация
     *
     * @param userFastRegistrationDto DTO для регистации
     * @return незаполненный WebUser
     */
    public WebUser registrationUser(UserFastRegistrationDto userFastRegistrationDto) {
        WebUser user = WebUser.builder().
                firstName(userFastRegistrationDto.getFirstName()).
                email(userFastRegistrationDto.getEmail())
                .build();

        return userRepository.save(user);

    }

    /**
     * находит всех пользователей
     *
     * @return Список Пользователей
     */
    public List<WebUser> findAll() {
        return (List<WebUser>) userRepository.findAll();
    }

    /**
     * Находит пользователя по Id
     *
     * @param id Id Пользователя
     * @return Пользователя WebUser или null если нет пользователя
     */
    public WebUser findUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Обновление по основным параметрам
     *
     * @param id                  Пользователя
     * @param userRegistrationDto DTO подходит и для простого обновления
     * @return Обновленного пользователя либо null елси пользователя нет
     */
    public WebUser updateUser(Long id, UserRegistrationDto userRegistrationDto) {
        if (userRepository.findById(id).isPresent()) {
            WebUser user = userRepository.findById(id).get();

            user.setAge(userRegistrationDto.getAge());
            user.setCountry(userRegistrationDto.getCountry());
            user.setFirstName(userRegistrationDto.getFirstName());
            user.setLastName(userRegistrationDto.getLastName());
            user.setGender(userRegistrationDto.getGender());
            user.setEmail(userRegistrationDto.getEmail());

            return userRepository.save(user);

        } else
            return null;
    }

    /**
     * Максимальное обновление пользователя (кроме ID)
     *
     * @param id      ID пользователя
     * @param webUser для обновления
     * @return обновленного пользователя
     */
    public WebUser maxUpdateUser(Long id, WebUser webUser) {

        if (userRepository.findById(id).isPresent()) {
            WebUser user = userRepository.findById(id).get();

            user.setAge(webUser.getAge());
            user.setCountry(webUser.getCountry());
            user.setFirstName(webUser.getFirstName());
            user.setLastName(webUser.getLastName());
            user.setGender(webUser.getGender());
            user.setEmail(webUser.getEmail());
            user.setInterests(webUser.getInterests());
            user.setPassword(webUser.getPassword());

            return userRepository.save(user);

        } else
            return null;

    }

    /**
     * Удаляет пользователя
     *
     * @param id пользователя для удаления
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
