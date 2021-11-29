package com.socialmeli.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeguidosDTO {

    @NotNull(message = "Debe introducir un id de un seguidor")
    @Positive(message = "EL id del usuario debe ser un número mayor a 0")
    private Integer user_id;

    @NotNull(message = "El nombre no puede nulo")
    @Size(max=15, message = "El nombre no puede tener mas de 15 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre no puede contener caracteres especiales")
    private String user_name;
    private List<CompradoresDTO> followed;
}
