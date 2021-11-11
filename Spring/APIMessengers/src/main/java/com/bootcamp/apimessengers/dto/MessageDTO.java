package com.bootcamp.apimessengers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class MessageDTO extends MessengerTypeDTO {
    private String message;

    public MessageDTO(String type, String message) {
        super(type);
        this.message = message;
    }
}
