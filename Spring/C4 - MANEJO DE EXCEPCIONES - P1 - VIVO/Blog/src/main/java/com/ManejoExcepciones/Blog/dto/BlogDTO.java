package com.ManejoExcepciones.Blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BlogDTO {
    private String titulo;
    private String autor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
}
