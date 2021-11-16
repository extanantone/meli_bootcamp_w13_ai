package SocialMeli.dto.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PromoPostDTO extends PostDTO {
    boolean hasPromo;
    double discount;

    public PromoPostDTO(int idPost, LocalDate date, ProductDTO detail, int category, double price, boolean hasPromo, double discount) {
        super(idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
