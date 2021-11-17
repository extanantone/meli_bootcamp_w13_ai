package SocialMeli.dto.response.list;

import SocialMeli.dto.response.PostDTO;
import SocialMeli.dto.response.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostListDTO extends UserDTO {

    List<PostDTO> posts;

    public PostListDTO(int userId, String userName, List<PostDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
