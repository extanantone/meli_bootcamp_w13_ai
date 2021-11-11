package com.bootcamp.apimessengers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class MessengerInfoDTO extends MessengerTypeDTO {
    private long id;
    public MessengerInfoDTO(long id, String type) {
        super(type);
        this.id = id;
    }
}
