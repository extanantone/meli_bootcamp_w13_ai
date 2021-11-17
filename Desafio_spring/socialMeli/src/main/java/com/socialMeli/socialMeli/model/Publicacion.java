package com.socialMeli.socialMeli.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class Publicacion {
    private int user_id;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Producto detail;
    private int category;
    private double price;
}
