package com.example.c4_manejo_excep_vivo_p1.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntradaBlog
{
    private Long id;
    private String title;
    private String authorName;
    private LocalDate pubDate;
}
