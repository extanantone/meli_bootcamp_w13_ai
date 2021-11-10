package com.Bootcamp.C4P1EJ1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private int idBlog;
    private String tituloBlog;
    private String nombreAutor;
    //@JsonFormat(pattern = "dd/mm/yyyy");
    private LocalDate fechaPublicacion;
}
