package com.c4Spring.clase5nov.service;

import com.c4Spring.clase5nov.excepciones.NoEncontradoExcepcion;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    public String encontrar(String entrada){
        if(entrada ==  null || entrada.equals(""))
            throw new NoEncontradoExcepcion("no se ha encontrado lo que buscabas");
        return "encontrado";
    }
}
