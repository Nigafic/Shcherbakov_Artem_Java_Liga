package com.notnewcompany.social_network.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table (name = "friendship")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Friendship implements Serializable {


    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId")
    private WebUser sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipientId")
    private WebUser recipient;

}





