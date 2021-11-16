package SocialMeli.dto.response.count;

import SocialMeli.dto.response.UserDTO;
import lombok.Getter;

@Getter
public class PromoCountDTO extends UserDTO {
    int promoProductsCount;

    public PromoCountDTO(int userId, String userName, int promoProductsCount) {
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }
}
