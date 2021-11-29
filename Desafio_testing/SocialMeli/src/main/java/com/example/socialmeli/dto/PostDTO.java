package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {


    @NotNull(message = "el user_id no puede ser nulo,negativo o 0")
    @Positive( message = "el user_id no puede ser nulo,negativo o 0")
    private Integer userId;

    @NotNull(message = "el post_id no puede ser nulo,negativo o 0")
    @Positive(message = "el post_id no puede ser nulo,negativo o 0")
    private Integer idPost;

    // date can not be null
    @NotNull(message = "date no puede ser nulo")
    @Past(message = "date no puede ser una fecha futura")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;

    @NotNull(message = "detail no puede ser nulo")
    private @Valid ProductDTO detail;

    @NotNull(message = "product_name no puede ser nulo o vacio")
    private int category;

    @NotNull(message = "el precio no puede ser nulo o vacio")
    @DecimalMax(value = "10000000.00", message = "el precio no puede ser mayor a 10000000.00")
    @Positive(message = "el precio no puede ser 0 o negativo")
    private double price;

    private boolean hasPromo = false;

    private double discount = 0.0;
}
