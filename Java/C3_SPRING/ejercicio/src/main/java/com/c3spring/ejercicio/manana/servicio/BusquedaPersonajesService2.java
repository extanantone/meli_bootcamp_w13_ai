package com.c3spring.ejercicio.manana.servicio;

import com.c3spring.ejercicio.manana.dto.PersonajeDTO;
import com.c3spring.ejercicio.manana.repository.IObtenerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component("BusquedaPersonajesService2")
public class BusquedaPersonajesService2 implements IBuscable{

    @Autowired
    IObtenerData repoPersonas;

    @Override
    public List<PersonajeDTO> encontrar(String nombre) {
        List<PersonajeDTO> salida = new ArrayList<>();
        System.out.println("estoy en la clase 2");
        repoPersonas.obtenerOrigenDatos(nombre).forEach(x->salida.add(new PersonajeDTO(x)));
        return salida;
    }
}
