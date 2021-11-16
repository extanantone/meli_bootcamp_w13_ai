package SocialMeli.dto.response.count;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class FollowersCountDTO extends CountListDTO {
    int followers_count;
    public FollowersCountDTO(int user_id, String user_name, int followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }
}
