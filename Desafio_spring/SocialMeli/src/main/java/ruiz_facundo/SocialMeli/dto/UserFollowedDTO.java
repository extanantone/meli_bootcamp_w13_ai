package ruiz_facundo.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserFollowedDTO extends UserDTO implements Serializable {
    private List<UserDTO> followed;

    public UserFollowedDTO(Long inId, String inName,
                            List<UserDTO> inFollowed) {
        super(inId, inName);
        this.followed = inFollowed;
    }
}
