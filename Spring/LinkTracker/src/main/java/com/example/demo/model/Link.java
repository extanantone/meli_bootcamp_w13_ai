package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Link {

    private static int teamIdCounter = 1;

    private int id;
    private String url;
    private boolean isActive;
    private int accesos;


    public Link(String url) {
        this.url = url;
        this.id = teamIdCounter++;
        this.isActive = true;
        accesos = 0;
    }

    public void incrementarCantidadAccesos(){
        this.accesos ++;
    }

}
