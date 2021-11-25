package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    /*
    Longitud máxima de 50 caracteres.
    Que empiece con mayúscula.
    Que el campo no esté vacío.
     */

    @Size(min=1, max=50, message = "La longitud del nombre no puede superar los {max} caracteres.")
    @Pattern(regexp = "(^[A-Z]|[0-9]|[ÑÁÉÍÓÚ]).*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    String studentName;
    String message;
    Double averageScore;

    /*
    Que la lista no esté vacía.
     */
    @NotEmpty(message = "La lista no puede ser vacía.")
    List<@Valid SubjectDTO> subjects;
}

