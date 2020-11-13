package com.notnewcompany.social_network.model;

import lombok.*;

import javax.persistence.*;

@Table (name = "message")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message  {

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


//    @Override
//    public String toString() {
//        return "Message{" +
//                "id=" + id +
//                ", messageText='" + messageText + '\'' +
//                '}';
//    }
}

