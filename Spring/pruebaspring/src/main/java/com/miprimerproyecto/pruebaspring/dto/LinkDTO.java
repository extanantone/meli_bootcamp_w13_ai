package com.miprimerproyecto.pruebaspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {

    private long id;
    private String link;
    private String pass;
    // long contador;
}
