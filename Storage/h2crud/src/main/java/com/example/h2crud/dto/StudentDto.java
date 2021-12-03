package com.example.h2crud.dto;

import lombok.Data;
import javax.validation.constraints.*;


@Data
public class StudentDto {

    @NotNull(message = "dni no puede ser nula")
    @Size(max = 8,min = 8, message = "dni debe tener 8 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "dni solo puede contener numeros")
    private String dni;

    @NotNull(message = "name no puede ser nula")
    @Size(max = 15, message = "name debe tener como maximo 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "name solo puede contener letras")
    private String name;

    @NotNull(message = "lastname no puede ser nula")
    @Size(max = 15, message = "lastname debe tener como maximo 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "lastname solo puede contener letras")
    private String lastname;

    @DecimalMin(value = "0.00", message = "parcial1 no puede ser menor que 0")
    @DecimalMax(value = "10.00", message = "parcial1 no puede ser mayor que 10")
    private Double parcial1;

    @DecimalMin(value = "0.00", message = "parcial2 no puede ser menor que 0")
    @DecimalMax(value = "10.00", message = "parcial2 no puede ser mayor que 10")
    private Double parcial2;

    @DecimalMin(value = "0.00", message = "tpIntegrador no puede ser menor que 0")
    @DecimalMax(value = "10.00", message = "tpIntegrador no puede ser mayor que 10")
    private Double tpIntegrador;
}
