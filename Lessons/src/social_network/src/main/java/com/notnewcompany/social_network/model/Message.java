package com.notnewcompany.social_network.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table (name = "message")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String messageText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId")
    private WebUser sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipientId")
    private WebUser recipient;



}

