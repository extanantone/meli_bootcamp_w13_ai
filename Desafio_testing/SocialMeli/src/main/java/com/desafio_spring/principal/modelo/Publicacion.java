package com.desafio_spring.principal.modelo;

import com.desafio_spring.principal.servicios.Utils;
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
public class Publicacion{

    private int idPost;
    private LocalDate date;
    private Producto detail;
    private Integer category;
    private Double price;
    private Usuario userDueno;
    private boolean hasPromo;
    private Double discount;

    public Publicacion(int idPost, LocalDate date, Producto detail, Integer category, String price, Usuario userDueno, boolean hasPromo, Double discount) {
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = Utils.valValorString(price,"10000000.00", "0.00");
        this.userDueno = userDueno;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
