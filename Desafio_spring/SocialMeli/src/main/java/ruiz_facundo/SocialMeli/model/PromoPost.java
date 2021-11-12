package ruiz_facundo.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ruiz_facundo.SocialMeli.dto.PostProductDTO;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PromoPost extends Post {
    private boolean hasPromo;
    private Double discount;

    public PromoPost () {}

    public PromoPost (Long inId, LocalDate inPublishDate,
                      PostProduct inProductOnSale, Integer inCategory,
                      Double inPrice, boolean inHasPromo, Double inDiscount) {
        super(inId, inPublishDate, inProductOnSale, inCategory, inPrice);
        this.hasPromo = inHasPromo;
        this.discount = inDiscount;
    }

    @Override
    public boolean hasPromo () {
        return this.hasPromo;
    }
}
