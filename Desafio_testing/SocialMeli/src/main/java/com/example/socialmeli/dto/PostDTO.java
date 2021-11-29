package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.Date;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull (message = "La id no puede estar vacía")
    @Positive (message = "El id debe ser mayor a cero")
    private Integer userId;

    @NotNull (message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @Valid
    private ProductDTO detail;

    @NotNull (message = "El campo no puede estar vacío")
    private int category;

    @NotNull (message = "El campo no puede estar vacío")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private double price;

    private boolean hasPromo = false;
    private double discount = 0.0;
}
