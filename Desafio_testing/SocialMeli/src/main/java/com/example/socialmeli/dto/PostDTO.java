package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    @Valid
    @NotNull(message = "El id no puede estar vacia.")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Integer userId;

    @Valid
    @NotNull(message = "El id no puede estar vacia.")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Integer idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private Date date;

    @Valid
    private ProductDTO detail;

    @NotNull(message = "El campo no puede estar vacío.")
    private int category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Valid
    @Max(message = "El precio máximo por producto es de 10.000.000", value = 10000000L)
    @PositiveOrZero(message = "El precio tiene que ser mayor o igual a 0")
    //@Decimal min y Decimal max
    private double price;

    @NotNull
    private boolean hasPromo = false;
    private double discount = 0.0;
}
