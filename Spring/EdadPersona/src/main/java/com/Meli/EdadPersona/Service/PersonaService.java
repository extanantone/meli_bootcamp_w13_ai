package com.Meli.EdadPersona.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonaService {
    public static long calcularEdad(int day, int month, int year){
        LocalDate fHoy= LocalDate.now();
        LocalDate cumple= LocalDate.of(year, month, day);
        long edad= ChronoUnit.YEARS.between(cumple, fHoy);
        return edad;
    }
}
