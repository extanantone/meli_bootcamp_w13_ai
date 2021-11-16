package SocialMeli.dto.response.count;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public abstract class CountListDTO {
    int user_id;
    String user_name;
}
