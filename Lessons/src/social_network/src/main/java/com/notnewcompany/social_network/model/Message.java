package com.notnewcompany.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table (name = "message")
@Entity

public class Message  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)

    private Long id;

    private String message;

    private Long senderId;

    private Long recipientId;

}

