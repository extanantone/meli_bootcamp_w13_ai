package ruiz_facundo.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RequestPromotionDTO extends RequestPostDTO implements Serializable {
    private boolean hasPromo;
    private double discount;

    public RequestPromotionDTO() {}

    public RequestPromotionDTO(Long inUserId, Long inId, LocalDate inDate,
                               RetailProductDTO inDetail, Integer inCategory,
                               Double inPrice, boolean inHasPromo, Double inDiscount) {
        super(inUserId, inId, inDate, inDetail, inCategory, inPrice);
        this.hasPromo = inHasPromo;
        this.discount = inDiscount;
    }
}
