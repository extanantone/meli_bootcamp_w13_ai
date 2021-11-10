package com.example.C4SP2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Link {

    private int id;
    private String url;
    private String password;
    private boolean valido;
    private int metrica;

    public void aumentarMetrica(){
        this.metrica++;
    }

}
