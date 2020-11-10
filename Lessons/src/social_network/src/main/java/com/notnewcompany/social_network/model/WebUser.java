package com.notnewcompany.social_network.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table (name = "web_user")
@AllArgsConstructor
@NoArgsConstructor
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


