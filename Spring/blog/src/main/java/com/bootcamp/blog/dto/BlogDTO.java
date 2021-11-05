package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class BlogDTO {
    int id;
    String titulo;
    String autor;
    String fechaPublicacion;
}
