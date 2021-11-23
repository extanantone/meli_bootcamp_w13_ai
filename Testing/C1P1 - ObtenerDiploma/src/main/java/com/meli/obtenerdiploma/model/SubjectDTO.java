package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.\n")
    @Pattern(regexp="([A-Z]|[a-z])[ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*",message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @DecimalMax(value = "10.00", message = "La nota máxima de la materia es de 10 pts.")
    @DecimalMin(value = "0.00", message = "La nota mínima de la materia es de 0 pts.")
    Double score;
}
