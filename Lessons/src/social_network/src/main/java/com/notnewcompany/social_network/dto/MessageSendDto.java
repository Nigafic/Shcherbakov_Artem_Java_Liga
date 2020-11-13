package com.notnewcompany.social_network.dto;

import lombok.Data;

/**
 * DTO для загрузки текста сообщения через RequestBody в метод postMessage()
 */
@Data
public class MessageSendDto {

    private String text;

}
