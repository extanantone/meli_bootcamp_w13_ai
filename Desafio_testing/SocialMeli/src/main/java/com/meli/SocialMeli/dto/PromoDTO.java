package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoDTO extends PostDTOResponse implements Serializable {
    @NotNull(message = "has_promo es obligatorio y no puede ser vacío.")
    @AssertTrue(message = "has_promo debe ser true para conciderarse promo")
    private Boolean hasPromo;

    @NotNull(message = "discount es obligatorio y no puede ser vacío.")
    @Positive(message = "discount no puede ser menor a cero.")
    @DecimalMax(value = "100.0", inclusive=true, message = "El valor máximo de discount es 100.0")
    private Double discount;

    public PromoDTO(int userId, int idPost, LocalDate date, int category, double price, ProductDTO detail, Boolean hasPromo, Double discount) {
        super(userId, idPost, date, category, price, detail);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Boolean isHasPromo() {
        return hasPromo;
    }
}
