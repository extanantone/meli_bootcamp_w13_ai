package com.c3spring.ejercicio.servicio;

import com.c3spring.ejercicio.dto.PersonajeDTO;
import com.c3spring.ejercicio.model.Personaje;
import com.c3spring.ejercicio.repository.IObtenerData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class BusquedaPersonajesService implements IBuscable{

    IObtenerData repoPersonas;

    BusquedaPersonajesService(IObtenerData repoPersonas){
        this.repoPersonas = repoPersonas;
    }

    @Override
    public List<PersonajeDTO> encontrar(String nombre) {
        List<Personaje> temp = repoPersonas.obtenerOrigenDatos(nombre)
                .stream().filter(x->x.getName().toLowerCase(Locale.ROOT).contains(nombre.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
        List<PersonajeDTO> salida = new ArrayList<>();
        temp.forEach(x->salida.add(new PersonajeDTO(x)));
        return salida;
    }
}
