package com.example.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Link {
    private Integer linkId;
    private String url;
    private String password;
    private int vecesRedireccionado;
    private boolean esValido;
}
