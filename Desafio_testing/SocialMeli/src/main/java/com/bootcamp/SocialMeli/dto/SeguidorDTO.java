package com.bootcamp.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.PrimitiveIterator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeguidorDTO {
    private String nameSeguidor;
    private int idSeguidor;
    private String nameSeguido;
    private int idSeguido;
}
