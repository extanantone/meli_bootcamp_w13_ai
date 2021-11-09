package com.ManejoExcepciones.Blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BlogCreateDTO {
    private int id;
    private String titulo;
    private String autor;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate fecha;
}
