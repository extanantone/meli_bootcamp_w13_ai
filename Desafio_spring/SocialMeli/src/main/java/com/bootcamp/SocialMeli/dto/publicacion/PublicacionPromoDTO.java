package com.bootcamp.SocialMeli.dto.publicacion;

import com.bootcamp.SocialMeli.dto.producto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionPromoDTO {
    private Integer userId;
    private String userName;
    private Integer idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductoDTO detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
