package SocialMeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListDTO {
    int user_id;
    List<PostDTO> postlist;
}
