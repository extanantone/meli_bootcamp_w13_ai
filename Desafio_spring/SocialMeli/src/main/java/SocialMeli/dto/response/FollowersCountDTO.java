package SocialMeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FollowersCountDTO {
    int user_id;
    String user_name;
    int followers_count;
}
