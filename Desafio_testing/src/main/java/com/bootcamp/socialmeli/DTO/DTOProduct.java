package com.bootcamp.socialmeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class DTOProduct {

    @NotNull(message = "El id de producto no debe ser nulo")
    @Min( value = 1, message = "El id de producto debe ser mayor a 0")
    private int productId;

    @NotNull(message = "El nombre del producto no debe ser nulo")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+", message = "El nombre no puede tener caracteres especiales")
    @Size(max = 40, message = "El nombre del producto no debe superar los 40 caracteres")
    private String productName;

    @NotNull(message = "El tipo del producto no debe ser nulo")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+", message = "El tipo no puede tener caracteres especiales")
    @Size(max = 15, message = "El tipo no debe superar los 15 caracteres")
    private String Type;

    @NotNull(message = "La marca del producto no debe ser nulo")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+", message = "La marca no puede tener caracteres especiales")
    @Size(max = 25, message = "La marca no debe superar los 25 caracteres")
    private String brand;

    @NotNull(message = "El color del producto no debe ser nulo")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+", message = "El color no puede tener caracteres especiales")
    @Size(max = 15, message = "El color no debe superar los 15 caracteres")
    private String color;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+", message = "Las notas no puede tener caracteres especiales")
    @Size(max = 80, message = "Las notas no debe superar los 80 caracteres")
    private String notes;

}
