package ruiz_facundo.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowersDTO extends UserDTO implements Serializable {
    private List<UserDTO> followers;

    public UserFollowersDTO(Long inId, String inName, List<UserDTO> inFollowers) {
        super(inId, inName);
        this.followers = inFollowers;
    }
}
