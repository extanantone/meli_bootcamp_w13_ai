package com.bootcamp.studentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotNull(message = "No puede estar vacío.")
    private String name;

    @NotNull(message = "No puede estar vacío.")
    private String lastName;

    @Positive(message = "Debe ser mayor a 0")
    @Max(value = 100, message = "Debe ser menor a 100")
    private Integer age;

    @Email(message = "No posee el formato requerido para un email")
    @NotNull(message = "No puede estar vacío.")
    private String email;

    @DecimalMax(value = "10.00", message = "La nota máxima es de 10.00")
    @DecimalMin(value = "0.0", message = "La nota mínima es de 0.0")
    private Double note1;

    @DecimalMax(value = "10.00", message = "La nota máxima es de 10.00")
    @DecimalMin(value = "0.0", message = "La nota mínima es de 0.0")
    private Double note2;

    @DecimalMax(value = "10.00", message = "La nota máxima es de 10.00")
    @DecimalMin(value = "0.0", message = "La nota mínima es de 0.0")
    private Double note3;

}
