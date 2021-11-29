package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @NotNull(message = "La id no puede estar vacia")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Integer userId;
    @NotNull(message = "La id no puede estar vacia")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Integer idPost;
    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private @Valid ProductDTO detail;
    @NotNull(message = "El campo no puede estar vacio")
    private int category;
    @NotNull(message = "El campo no puede estar vacio")
    @Max(value = 10000000,message = "El precio máximo por producto es de 10.000.000")
    private double price;
    private boolean hasPromo = false;
    private double discount = 0.0;
}
