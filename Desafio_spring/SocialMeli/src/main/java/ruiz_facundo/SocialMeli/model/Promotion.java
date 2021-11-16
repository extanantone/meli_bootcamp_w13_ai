package ruiz_facundo.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Promotion extends Post {
    private boolean hasPromo;
    private Double discount;

    public Promotion () {}

    public Promotion (Long inId, LocalDate inPublishDate,
                     RetailProduct inProductOnSale, Integer inCategory,
                     Double inPrice, boolean inHasPromo, Double inDiscount) {
        super(inId, inPublishDate, inProductOnSale, inCategory, inPrice);
        this.hasPromo = inHasPromo;
        this.discount = inDiscount;
    }

    @Override
    public boolean isHasPromo () {
        return this.hasPromo;
    }
}
