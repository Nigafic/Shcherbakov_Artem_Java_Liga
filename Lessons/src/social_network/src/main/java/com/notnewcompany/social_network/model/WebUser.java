package com.notnewcompany.social_network.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table (name = "web_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    private int age;

    private String gender;

    private String email;

//    @ManyToMany
//    @JoinTable (name = "user_message", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "message_id", referencedColumnName = "id"))
//    private Set<Message> message;

}


