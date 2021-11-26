package com.bootcamp.socialmeli.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class DTOPostProduct {

    @NotNull(message = "El id del usuario no debe ser nulo")
    @Min(value = 1, message = "El id del usuario debe ser mayor a 0")
    private int userId;

    @NotNull(message = "El id del post no debe ser nulo")
    @Min(value = 1, message = "El id del post debe ser mayor a 0")
    private int idPost;

    @NotNull(message = "La fecha no puede ser nula")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate date;

    @Valid
    private DTOProduct detail;

    @NotNull(message = "La categoría no puede esta vacía")
    private int category;

    @NotNull(message = "El precio no puede esta vacía")
    @DecimalMin(value = "1.0", message = "El precio mínimo debe ser $1.-")
    @DecimalMax(value = "10000000.0", message = "El precio máximo debe ser $10.000.000.-")
    private double price;

    private Boolean hasPromo;

    @DecimalMin(value = "0.0", message = "El descuento debe ser un número entre 0 (en caso de no poseer descuento) y 1 ej desceunto 0,25 = 25%")
    @DecimalMax(value = "1.0", message = "El descuento debe ser un número entre 0 (en caso de no poseer descuento) y 1 ej desceunto 0,5 = 50%")
    private double discount;

}
