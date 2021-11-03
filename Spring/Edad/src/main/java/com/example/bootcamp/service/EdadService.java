package com.example.bootcamp.service;

import java.time.LocalDate;
import java.time.Period;

public class EdadService {
    public static Integer calcularPorFecha (Integer dia, Integer mes, Integer año) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDeNacimiento = LocalDate.of(año, mes, dia);
        Period edad = Period.between(fechaDeNacimiento, fechaActual);
        return edad.getYears();
    }
}
