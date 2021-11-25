package com.bootcamp.SocialMeli.dto.request;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromocionDTO extends PublicacionDTO {
    @NotNull(message = "El campo has_promo no puede estar vacío.")
    private boolean hasPromo;

    @NotNull(message = "El porcentaje de descuento no puede estar vacío.")
    @DecimalMin(value = "0.0", inclusive = true, message = "El descuento mínimo es 0%.")
    @DecimalMax(value = "100.0", inclusive = true, message = "El descuento máximo es 100%.")
    private double discount;

    public PromocionDTO(int userId, int idPost, LocalDate date, DetalleProductoDTO detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
