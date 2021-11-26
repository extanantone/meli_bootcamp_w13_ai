package com.bootcamp.SocialMeli.dto.publicacion;

import com.bootcamp.SocialMeli.dto.producto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionDTO {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer userId;

    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    @Valid
    private ProductoDTO detail;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
}
