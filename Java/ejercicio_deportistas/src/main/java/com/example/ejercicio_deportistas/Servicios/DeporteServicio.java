package com.example.ejercicio_deportistas.Servicios;

import com.example.ejercicio_deportistas.Modelos.Deporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeporteServicio {
    HashMap<String ,Integer> listaDeportes = new HashMap();

    public HashMap<String,Integer> getListaDeportes() {
        return listaDeportes;
    }

    public void setDeporte(Deporte deporte) {
        this.listaDeportes.put(deporte.getNombre(),deporte.getNivel());
    }

    public Integer buscarNivelDeDeporte(String nombreDeporte){
        System.out.println(listaDeportes.get(nombreDeporte));
        return listaDeportes.get(nombreDeporte);
    }
}
