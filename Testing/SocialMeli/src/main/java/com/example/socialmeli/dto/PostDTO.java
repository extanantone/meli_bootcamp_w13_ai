package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Valid
    @NotNull(message = "La ID no puede estar vacio")

    private Integer userId;
    @NotNull(message = "El ID no puede estar vacio")
    @Positive(message = "El ID debe ser mayor a 0")
    private Integer idPost;
    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    @Valid
    private ProductDTO detail;
    @NotNull(message = "El campo no puede estar vacio")
    private int category;
    @NotNull(message = "El campo no puede estar vacio")

    private double price;
    private boolean hasPromo = false;
    private double discount = 0.0;
}
