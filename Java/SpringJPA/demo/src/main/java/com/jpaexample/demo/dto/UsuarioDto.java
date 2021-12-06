package com.jpaexample.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private List<NotasDto> notas;

}
