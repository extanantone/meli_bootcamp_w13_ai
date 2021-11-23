package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;
import java.util.List;

@Getter @Setter
@Validated
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp="[A-Z]\\w*.*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(min = 0, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;
    String message;
    Double averageScore;

    @Valid
    @NotEmpty(message = "La lista no puede ser vacía.")
    List<SubjectDTO> subjects;
}
