package com.example.socialmeli.demo.dto.serviceToController;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOUserFollowerCount {

    private int userId;

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 15, message = "La longitud del nombre de la materia no puede superar los 15 caracteres.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9]|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú)*", message = "El nombre posee caracteres invalidos")
    private String userName;

    private int followersCount;

}
