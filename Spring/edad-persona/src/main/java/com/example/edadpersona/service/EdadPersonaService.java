package com.example.edadpersona.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class EdadPersonaService {

    public String getEdadPersona(int dia, int mes, int anio) {
        if (anio > LocalDate.now().getYear()) {
            return "El año es invalido";
        }

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        long diff = DAYS.between(fecha, LocalDate.now()) / 365;
        return Long.toString(diff);
    }
}
