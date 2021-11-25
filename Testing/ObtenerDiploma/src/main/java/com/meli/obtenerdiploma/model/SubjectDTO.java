package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    /*
    Que el campo no esté vacío.
    Longitud máxima de 30 caracteres.
    Que empiece con mayúscula.
     */
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(min=1, max=30, message = "La longitud del nombre no puede superar los {max} caracteres.")
    @Pattern(regexp = "(^[A-Z]|[0-9]|[ÑÁÉÍÓÚ]).*",message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;

    /*
    Que el campo no esté vacío.
    Mínimo 0.0
    Máximo 10-0
     */
    @NotNull(message = "La nota no puede estar vacía.")
    @DecimalMin(value = "0.0", message = "La mínima nota es {value}")
    @DecimalMax(value = "10.0", message = "La máxima nota es {value}")
    Double score;
}
