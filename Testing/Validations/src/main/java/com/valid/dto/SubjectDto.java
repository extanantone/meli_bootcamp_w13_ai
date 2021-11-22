package com.valid.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class SubjectDto {
    @NotEmpty(message = "el nombre de la materia no puede ser vacio")
    @Pattern(regexp = "[A-Z]+[a-zA-Z]*",message = "El nombre de la materia debe iniciar en mayuscula")
    @Size(max = 30,message = "el nombre de la materia no debe tener mas de 30 caracteres")
    private String name;
    @Range(min = 0,max = 10)
    private double score;
}
