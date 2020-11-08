package com.notnewcompany.social_network.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table (name = "web_user")
public class WebUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    private int age;

    private String gender;

}


