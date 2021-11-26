package com.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DetailDto {

    @Positive
    @NotNull
    private Integer productId;

    @NotNull(message = "el nombre no puede ser vacio")
    @Size(max = 40,message = "Tamaño maximo de 40 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+([a-zA-Z ]||[ñ]|[Ñ])*$",message = "hay caracteres especiales")
    private String productName;

    @NotNull(message = "el tipo no puede ser vacio")
    @Size(max = 15,message = "No puede contener mas de 15 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+$",message = "no puede contener caracteres especiales")
    private String type;


    @NotEmpty
    @Size(max = 25)
    @Pattern(regexp = "^([a-z]|[A-Z ]|[ñ]|[Ñ])+$",message = "no puede contener caracteres especiales")
    private String brand;

    @NotEmpty
    @Size(max = 15)
    @Pattern(regexp = "^([a-z]|[A-Z ]|[ñ]|[Ñ])+$",message = "no puede contener caracteres especiales")
    private String color;

    @Size(max = 80, message = "maximo 80 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z ]|[ñ]|[Ñ])+$",message = "no puede contener caracteres especiales")
    private String notes;
}
