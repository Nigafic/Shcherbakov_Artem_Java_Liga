package com.notnewcompany.social_network.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table (name = "web_user")
@NoArgsConstructor
@AllArgsConstructor
public class WebUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
//    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    private int age;

    private String gender;

}


