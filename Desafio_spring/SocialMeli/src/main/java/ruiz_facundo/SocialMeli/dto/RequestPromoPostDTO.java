package ruiz_facundo.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RequestPromoPostDTO extends RequestPostDTO {
    private boolean hasPromo;
    private double discount;

    public RequestPromoPostDTO () {}

    public RequestPromoPostDTO (Long inUserId, Long inId, LocalDate inDate,
                                PostProductDTO inDetail, Integer inCategory,
                                Double inPrice, boolean inHasPromo, Double inDiscount) {
        super(inUserId, inId, inDate, inDetail, inCategory, inPrice);
        this.hasPromo = inHasPromo;
        this.discount = inDiscount;
    }
}
