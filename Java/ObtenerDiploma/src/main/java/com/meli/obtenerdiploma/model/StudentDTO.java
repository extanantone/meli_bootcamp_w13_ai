package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @Valid
    @NotNull(message = "El nombre del alumno no puede estar vacío.") @Pattern(regexp="/^[A-Z].*$/", message = "El nombre del alumno debe comenzar con mayúscula.") @Size(max=50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;
    @Valid
    @NotNull(message = "La lista no puede ser vacía.")
    List<SubjectDTO> subjects;
}
