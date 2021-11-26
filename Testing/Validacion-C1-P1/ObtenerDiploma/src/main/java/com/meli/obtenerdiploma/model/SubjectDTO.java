package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
@Valid
public class SubjectDTO {
    @NotEmpty(message = "El nombre no puede ser vacio.")
    @Size(max = 30, message = "El nombre no puede exceder los 30 caracteres.")
    @Pattern(regexp = "^[A-Z|Á|É|Í|Ó|Ú|Ñ](\\w|\\d|\\W)*", message = "El nombre debe comenzar con mayúsculas")
    String name;
    @NotNull(message = "El score no puede ser null o vacío.")
    Double score;
}
