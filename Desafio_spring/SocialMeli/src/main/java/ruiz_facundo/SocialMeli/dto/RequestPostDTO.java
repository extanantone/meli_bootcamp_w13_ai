package ruiz_facundo.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RequestPostDTO extends PostDTO {
    private Long userId;

    public RequestPostDTO () {}

    public RequestPostDTO (Long inUserId, Long inIdPost, LocalDate inDate,
                           RetailProductDTO inDetail, Integer inCategory, Double inPrice) {
        super(inIdPost, inDate, inDetail, inCategory, inPrice);
        this.userId = inUserId;
    }
}
