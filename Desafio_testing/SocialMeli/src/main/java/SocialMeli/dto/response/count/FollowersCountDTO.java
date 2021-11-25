package SocialMeli.dto.response.count;

import SocialMeli.dto.response.UserDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class FollowersCountDTO extends UserDTO {
    int followersCount;

    public FollowersCountDTO(int userId, String userName, int followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
