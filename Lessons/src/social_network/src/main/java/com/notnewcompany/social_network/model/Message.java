package com.notnewcompany.social_network.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table (name = "message")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String messageText;





}

