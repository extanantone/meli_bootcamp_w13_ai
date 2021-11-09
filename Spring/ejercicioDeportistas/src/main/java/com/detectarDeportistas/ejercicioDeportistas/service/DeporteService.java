package com.detectarDeportistas.ejercicioDeportistas.service;

import com.detectarDeportistas.ejercicioDeportistas.model.Deporte;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Getter
public class DeporteService {
    ArrayList<Deporte> deportes = new ArrayList<>();
    public DeporteService(){
        this.deportes.add(new Deporte("Tenis","Intermedio"));
        this.deportes.add(new Deporte("Futbol","Facil"));
        this.deportes.add(new Deporte("Handball","Facil"));
        this.deportes.add(new Deporte("Basketball","Intermedio"));
    }

    public String buscarDeporte(String nombre){
        return deportes.stream().filter(d -> d.getNombre().equals(nombre)).findFirst().orElse(null).getNivel();
    }
}
