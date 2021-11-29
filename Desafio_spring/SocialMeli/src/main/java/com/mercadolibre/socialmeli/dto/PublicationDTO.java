package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicationDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Integer userId;

    @JsonProperty("id_post")
    @NotNull(message = "El id de la publicacion no debe estar vacio")
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @JsonProperty("detail")
    @Valid
    private ProductDTO product;

    @NotNull(message = "El campo no puede estar vacio")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    private Double price;

}
