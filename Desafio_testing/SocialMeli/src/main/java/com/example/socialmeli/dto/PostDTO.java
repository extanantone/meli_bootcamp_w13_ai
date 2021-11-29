package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "La id debe ser mayor a cero.")
    private Integer userId;

    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "La id debe ser mayor a cero.")
    private Integer idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
    @PastOrPresent(message = "La fecha debe haber ocurrido.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @Valid
    private ProductDTO detail;

    /*@NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A[A-Z][\\w|\\u00f1|\\u00d1]*$",
            message = "El campo no puede poseer caracteres especiales.")*/
    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El campo debe ser mayor a cero.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El campo debe ser mayor a cero.")
    @DecimalMax(value = "10000000.00", message = "El precio máximo por producto es de 10.000.000.")
    private Double price;

    private boolean hasPromo = false;
    private Double discount = 0.0;
}
