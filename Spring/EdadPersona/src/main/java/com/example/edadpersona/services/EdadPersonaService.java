package com.example.edadpersona.services;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component("edadPersona")
public class EdadPersonaService {

    private EdadPersonaService(){

    }

    public static Integer getEdad(Integer day, Integer month, Integer year){

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime birthDate = LocalDateTime.of(year, month, day,0,0);

        return (int) ChronoUnit.YEARS.between(birthDate, now);
    }
}
