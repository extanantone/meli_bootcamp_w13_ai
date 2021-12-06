package com.jpaexample.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotasDto {

    private Long id;
    private String nombreNota;
    private String contenido;
    private String usuario_id;

}
