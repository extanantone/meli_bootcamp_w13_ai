package ruiz_facundo.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RequestPostDTO extends PostDTO {
    private Long userId;

    public RequestPostDTO () {}

    public RequestPostDTO (Long inUserId, Long inIdPost, LocalDate inDate,
                           PostProductDTO inDetail, Integer inCategory, Double inPrice) {
        super(inIdPost, inDate, inDetail, inCategory, inPrice);
        this.userId = inUserId;
    }
}
