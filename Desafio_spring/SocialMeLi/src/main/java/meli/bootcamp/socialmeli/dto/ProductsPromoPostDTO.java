package meli.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsPromoPostDTO extends PromoPostBaseDTO{
    private int userId;

    public ProductsPromoPostDTO(int id_post, String date, ProductsDTO detail, String category, double price, boolean has_promo, double discount, int userId) {
        super(id_post, date, detail, category, price, has_promo, discount);
        this.userId = userId;
    }

    public ProductsPromoPostDTO() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
