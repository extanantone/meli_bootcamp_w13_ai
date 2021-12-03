package com.bootcamp.studentapi.dto.response;

import com.bootcamp.studentapi.dto.request.StudentDTO;

import javax.validation.constraints.*;

public class StudentRESDTO extends StudentDTO {

    private Long idStudent;

    public StudentRESDTO(@NotNull(message = "No puede estar vacío.") String name,
                         @NotNull(message = "No puede estar vacío.") String lastName,
                         @Positive(message = "Debe ser mayor a 0") @Max(value = 100, message = "Debe ser menor a 100") Integer age,
                         @Email(message = "No posee el formato requerido para un email") String email,
                         @DecimalMax(value = "10.00", message = "La nota máxima es de 10.00")
                            @DecimalMin(value = "0.0", message = "La nota mínima es de 0.0") Double note1,
                         @DecimalMax(value = "10.00", message = "La nota máxima es de 10.00")
                            @DecimalMin(value = "0.0", message = "La nota mínima es de 0.0") Double note2,
                         @DecimalMax(value = "10.00", message = "La nota máxima es de 10.00")
                            @DecimalMin(value = "0.0", message = "La nota mínima es de 0.0") Double note3, Long idStudent) {
        super(name, lastName, age, email, note1, note2, note3);
        this.idStudent = idStudent;
    }
}
