package com.valid.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StudentNotesDto {
    @NotEmpty(message = "el nombre del estudiante no puede ser vacio")
    @Pattern(regexp = "[A-Z]+[a-zA-Z]*",message = "El nombre del alumno debe iniciar en mayuscula")
    @Size(max = 50,message = "el nombre del alumno no debe tener mas de 50 caracteres")
    private String studentName;
    @NotEmpty(message = "La lista no puede estar vacia")
    @Valid
    private List<SubjectDto> subjects;
}
