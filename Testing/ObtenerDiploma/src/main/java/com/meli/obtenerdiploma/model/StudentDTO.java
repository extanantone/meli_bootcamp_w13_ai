package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü].*$", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;

    @Valid
    @NotEmpty(message = "La lista no puede ser vacía")
    List<SubjectDTO> subjects;
}
