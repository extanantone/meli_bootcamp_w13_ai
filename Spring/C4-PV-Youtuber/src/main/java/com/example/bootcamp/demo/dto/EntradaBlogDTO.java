package com.example.bootcamp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {

    private Long Id;
    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaPublicacion;

}
