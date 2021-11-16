package SocialMeli.dto.response.list;

import SocialMeli.dto.response.UserDTO;
import lombok.Getter;

import java.util.List;

@Getter

public class FollowedListDTO extends UserDTO {
    List<UserDTO> followed;

    public FollowedListDTO(int userId, String userName, List<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
