package SocialMeli.dto.response.list;

import SocialMeli.dto.response.UserDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class FollowersListDTO extends UserDTO {
    List<UserDTO> followers;

    public FollowersListDTO(int userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
