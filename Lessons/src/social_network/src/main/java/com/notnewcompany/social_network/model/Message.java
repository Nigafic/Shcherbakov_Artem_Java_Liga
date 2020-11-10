package com.notnewcompany.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table (name = "message")
@Entity

public class Message  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String messageText;

    private Long senderId;

    private Long recipientId;

//    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "message")
//
//    private Set<WebUser> webUsers;

}

