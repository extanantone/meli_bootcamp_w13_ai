package com.fecNac.demo.Service;

import java.time.LocalDate;

public class Calculador {

    public int calcularEdad(int inDia, int inMes, int inYear) {
        Integer outEdad = 0;
        LocalDate hoy = LocalDate.now();
        LocalDate diaDeNacimiento = LocalDate.of(inYear, inMes, inDia);

        if (hoy.getYear() - diaDeNacimiento.getYear() > 0) {
            outEdad = hoy.getYear() - diaDeNacimiento.getYear() - 1;
            if (hoy.getMonthValue() > diaDeNacimiento.getMonthValue()) {
                outEdad++;
            } else if (hoy.getMonthValue() == diaDeNacimiento.getMonthValue() && !(hoy.getDayOfMonth() < diaDeNacimiento.getDayOfMonth()))
                outEdad++;
        }

        return outEdad;
    }
}
