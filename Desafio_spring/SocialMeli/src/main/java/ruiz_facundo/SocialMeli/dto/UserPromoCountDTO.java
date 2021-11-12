package ruiz_facundo.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserPromoCountDTO extends UserDTO {
    private Integer promoProductsCount;

    public UserPromoCountDTO () {}

    public UserPromoCountDTO (Long inUserId, String inUserName,
                              Integer inPromoProductsCount) {
        super(inUserId, inUserName);
        this.promoProductsCount = inPromoProductsCount;
    }
}
