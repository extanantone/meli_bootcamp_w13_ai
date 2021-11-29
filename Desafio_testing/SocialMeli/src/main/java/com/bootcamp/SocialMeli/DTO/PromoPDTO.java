package com.bootcamp.SocialMeli.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

//Esta anotacion remplaza los getter y setter
@Data
//Se añade estas anotación ya que la clase heredaFalse para comparar los datos de la clase padre y true las de la clase hijo
@EqualsAndHashCode(callSuper = false)
//Esta anotacion se usa para convertir el nombre Json a java ejemplo promo_publi a promoPubli
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPDTO extends PublicacionDTO{
    private boolean promo;
    private Double descuento;

    public PromoPDTO(Integer userId, Integer idPost, @JsonFormat(pattern = "dd-MM-yyyy") LocalDate date, DetallePublicacionDTO detalleP, Integer category, Double price, boolean promo, Double descuento) {
        super(userId,idPost, date, detalleP, category, price);
        this.promo = promo;
        this.descuento = descuento;
    }
}
