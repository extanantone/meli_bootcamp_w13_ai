package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern( regexp = "^[A-Z][A-Za-z]*$", message = "El nombre debe de empezar con mayúsculas.")
    @Size(max = 50, message = "La longitud debe de ser 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía.")
    List<SubjectDTO> subjects;
}
