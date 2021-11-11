package com.miprimerproyecto.pruebaspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private long id;
    private String link;
    private String pass;
    // long contador;

}
