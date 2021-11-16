package SocialMeli.dto.response.list;

import SocialMeli.dto.response.PromoPostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PromoPostListDTO {
    int user_id;
    String user_name;
    List<PromoPostDTO> posts;
}
