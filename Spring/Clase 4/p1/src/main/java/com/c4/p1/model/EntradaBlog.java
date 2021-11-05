package com.c4.p1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EntradaBlog {
    Integer id;
    String titulo;
    String autor;
    LocalDate fechaPublicacion;
}
