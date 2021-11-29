package com.bootcamp.SocialMeli.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionDTO{
    @NotNull(message = "La ID user no puede estar vacía.")
    @Min(value=1,message = "El ID user debe ser mayor a 0")
    private Integer userId;
    @NotNull(message = "La ID post no puede estar vacía.")
    @Min(value=1,message = "El ID post debe ser mayor a 0")
    private Integer idPost;
    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate date;
    @Valid
    private DetallePublicacionDTO detail;
    @NotNull(message = "El campo category no puede estar vacío.")
    private Integer category;
    @NotNull(message = "El campo price no puede estar vacío.")
    @DecimalMax(value = "10000000",message = "El precio máximo por producto es de 10.000.000")
    @DecimalMin(value = "0",message = "El precio minimo por producto es de 10.000.000")
    private Double price;
}
