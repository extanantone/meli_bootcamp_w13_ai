package ruiz_facundo.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowersCountDTO extends UserDTO implements Serializable {
    private Integer followersCount;

    public UserFollowersCountDTO() {}

    public UserFollowersCountDTO(Long inId, String inName, Integer inFollowersCount) {
        super(inId, inName);
        this.followersCount = inFollowersCount;
    }
}
