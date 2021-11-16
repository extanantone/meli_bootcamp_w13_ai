package SocialMeli.dto.response.list;

import SocialMeli.dto.response.PromoPostDTO;
import SocialMeli.dto.response.UserDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class PromoPostListDTO extends UserDTO {
    List<PromoPostDTO> posts;

    public PromoPostListDTO(int userId, String userName, List<PromoPostDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
