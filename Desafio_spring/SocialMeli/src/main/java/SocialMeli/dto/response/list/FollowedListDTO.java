package SocialMeli.dto.response.list;

import SocialMeli.dto.response.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FollowedListDTO {
    int user_id;
    String user_name;
    List<UserDTO> followed;
}
