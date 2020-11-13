package com.notnewcompany.social_network.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "web_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    private int age;

    private String gender;

    private String email;

    private String password;

    private String interests;




}


