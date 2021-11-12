package SocialMeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FollowersListDTO {
    int user_id;
    String user_name;
    List<UserDTO> followers;
}
