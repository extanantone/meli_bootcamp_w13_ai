package com.ejDeportistas.calculandodeportistas.dtos;

import lombok.Getter;
import com.ejDeportistas.calculandodeportistas.models.Deporte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class sportsNameDto implements Serializable {
    private ArrayList<String> listaNombresDeportes = new ArrayList<>();
    public sportsNameDto(List<Deporte> listaDeportes){
        listaDeportes.forEach((d)->{listaNombresDeportes.add(d.getNombre());});
    }
}
