package SocialMeli.dto.response.count;

import lombok.Getter;

@Getter
public class PromoCountDTO extends CountListDTO{
    int promo_products_count;
    public PromoCountDTO(int user_id, String user_name, int promo_products_count) {
        super(user_id, user_name);
        this.promo_products_count = promo_products_count;
    }
}
