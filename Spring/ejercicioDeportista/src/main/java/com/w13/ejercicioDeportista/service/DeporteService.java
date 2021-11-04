package com.w13.ejercicioDeportista.service;

import com.w13.ejercicioDeportista.entity.Deporte;
import com.w13.ejercicioDeportista.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService {
    List<Deporte> deportes = new ArrayList<Deporte>();


    public List<Deporte> cargaListaDeporte() {
        deportes.add(new Deporte("Tenis", "Principiante"));
        deportes.add(new Deporte("Futbol", "Intermedio"));
        deportes.add(new Deporte("Natacion", "Avanzado"));
        deportes.add(new Deporte("ciclismo", "Super Avanzado"));

        return deportes;

    }



}
