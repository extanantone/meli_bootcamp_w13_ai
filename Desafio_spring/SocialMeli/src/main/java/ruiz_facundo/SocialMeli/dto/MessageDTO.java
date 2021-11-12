package ruiz_facundo.SocialMeli.dto;

import lombok.Getter;

@Getter
public class MessageDTO {
    private String message;

    public MessageDTO(String exMessage) {
        this.message = exMessage;
    }
}
