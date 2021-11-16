package ruiz_facundo.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserNamePostsDTO extends UserDTO implements Serializable {
    private List<PostDTO> posts;

    public UserNamePostsDTO () {}

    public UserNamePostsDTO(Long inUserId, String inUserName, List<PostDTO> inPosts) {
        super(inUserId, inUserName);
        this.posts = inPosts;
    }
}
