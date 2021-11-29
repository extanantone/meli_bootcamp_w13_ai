package com.SocialMeli.Sprint1SocialMeli.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionDTO {

    @NotNull(message = "El ID no puede puede ser vacio")
    @Positive(message = "Solo valores positivos")
    private Integer userId;

    @NotNull(message = "El ID no puede puede ser vacio")
    @Positive(message = "Solo valores positivos")
    private Integer idPost;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000.0", message = "El valor no puede superar los 10000000")
    private double price;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "La fecha ingresada pertenece a una fecha futura")
    private LocalDate date;

    @NotNull(message = "El ID no puede puede ser vacio")
    @Valid
    private ProductoDTO detail;
    private Boolean hasPromo;
    private double discount;

}
