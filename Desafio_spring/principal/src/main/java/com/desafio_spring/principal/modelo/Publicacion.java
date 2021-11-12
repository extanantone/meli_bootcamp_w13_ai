package com.desafio_spring.principal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion implements Comparable<LocalDate>{

    private int idPost;
    private LocalDate date;
    private Producto detail;
    private String category;
    private Double price;
    private Usuario userdueno;

    @Override
    public int compareTo(LocalDate o) {
        return o.compareTo(this.date);
    }
}
