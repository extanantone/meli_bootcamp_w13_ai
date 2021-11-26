package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@Valid
public class StudentDTO {
    @NotEmpty(message = "El nombre del estudiante no puede ser vacio.")
    @Size(max = 50)
    @Pattern(regexp = "^[A-Z|Á|É|Í|Ó|Ú|Ñ](\\w|\\d|\\W)*")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La Lista Subjects no puede ser vacio")
    List<SubjectDTO> subjects;
}
