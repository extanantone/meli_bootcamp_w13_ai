package com.SocialMeli.Sprint1SocialMeli.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO {

    @NotNull(message = "La id no puede estar vacia")
    //@Min(value = 0, message = "El id debe ser mayor a 0")
    @Positive(message = "El id debe ser mayor a 0")
    private Integer user_id;
    @NotNull(message = "La id no puede estar vacia")
    //@Min(value = 0, message = "El id debe ser mayor a 0")
    @Positive (message = "El id debe ser mayor a 0")
    private Integer id_post;
    @NotNull(message = "La categoria no puede estar vacia")
    private Integer category;
    @NotNull(message = "El precio no puede estar vacio")
    @Min(value = 0, message = "El precio debe ser mayor a 0")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    @NotEmpty (message = "La fecha no puede estar vacia")
    private String date;
    @Valid
    private ProductoDTO detail;

}
