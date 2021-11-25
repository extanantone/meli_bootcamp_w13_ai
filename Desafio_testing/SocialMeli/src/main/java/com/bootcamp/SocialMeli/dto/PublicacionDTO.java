package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionDTO {
    @NotNull(message = "El ID no puede estar vacío.")
    @Positive(message = "El ID debe ser mayor a cero.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userId;

    @NotNull(message = "El ID no puede estar vacío.")
    @Positive(message = "El ID debe ser mayor a cero.")
    private Integer idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
    //@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])-(0[1-9]|1[0-2])-([0-9]{4})", message = "La fecha debe cumplir el formato 'dd-MM-yyyy'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private DetalleProductoDTO detail;

    @NotNull(message = "El campo category no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo price no puede estar vacío.")
    @DecimalMax(value = "10000000", inclusive = true, message = "El precio máximo por producto es de 10.000.000.")
    private Double price;

    public PublicacionDTO(Integer idPost, LocalDate date, DetalleProductoDTO detail, Integer category, Double price) {
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
