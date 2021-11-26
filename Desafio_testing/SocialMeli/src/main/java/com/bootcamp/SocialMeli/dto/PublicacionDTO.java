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
    @NotNull(message = "El user_id no puede estar vacío.")
    @Positive(message = "El user_id debe ser mayor a cero.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userId;

    @NotNull(message = "El id_post no puede estar vacío.")
    @Positive(message = "El id_post debe ser mayor a cero.")
    private Integer idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
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
