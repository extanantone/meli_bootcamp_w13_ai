package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Getter @Setter
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "La id debe mayor a cero")
    private Integer userId;

    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "La id debe mayor a cero")
    private Integer idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    //@Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "La fecha debe cumplir con el formato: dd-mm-yyyy")
    private Date date;

    @Valid
    private ProductDTO detail;

    @NotNull(message = "El campo no puede estar vacío")
    private int category;

    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private double price;

    private boolean hasPromo = false;
    private double discount = 0.0;
}
