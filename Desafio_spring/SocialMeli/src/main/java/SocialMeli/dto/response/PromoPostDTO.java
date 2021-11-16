package SocialMeli.dto.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PromoPostDTO extends PostDTO{
    boolean has_promo;
    double discount;
    public PromoPostDTO(int id_post, LocalDate date, ProductDTO detail, int category, double price, boolean has_promo, double discount) {
        super(id_post, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
