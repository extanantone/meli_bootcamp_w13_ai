package ruiz_facundo.SocialMeli.dto;

import lombok.Getter;

@Getter
public class MessageDTO {
    private String message;

    public MessageDTO(String inMessage) {
        this.message = inMessage;
    }
}
