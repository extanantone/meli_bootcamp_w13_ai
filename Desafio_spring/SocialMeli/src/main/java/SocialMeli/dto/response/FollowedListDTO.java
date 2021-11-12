package SocialMeli.dto.response;

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
