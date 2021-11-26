package com.example.socialmeli.dto;

import com.example.socialmeli.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostCreateDto {

    @NotNull(message = "La id del usuario no puede estar vacia")
    @Positive(message = "El id del usuario debe ser mayor a cero")
    private Integer userId;

    @NotNull(message = "La id del post no puede estar vacia")
    @Positive(message = "El id del post debe ser mayor a cero")
    private Integer idPost;

    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductDto detail;

    @NotNull(message = "El campo categoria no puede estar vacio")
    private Integer category;

    @NotNull(message = "El campo precio no puede estar vacio")
    @DecimalMax(value="10000000",message = "El precio maximo por producto es de 10.0000.000")
    private Double price;

    private Boolean hasPromo = false;
    private Double discount = null;

}
