package SocialMeli.dto.request;

import SocialMeli.dto.response.UserDTO;

import lombok.Getter;

@Getter
public class NewUserDTO extends UserDTO {
    boolean seller;

    public NewUserDTO(int userId, String userName) {
        super(userId, userName);
    }
}
