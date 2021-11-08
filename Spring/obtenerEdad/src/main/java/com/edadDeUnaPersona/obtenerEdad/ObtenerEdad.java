package com.edadDeUnaPersona.obtenerEdad;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

@RestController
public class ObtenerEdad {
    @GetMapping("/{dia}/{mes}/{ano}")
    public int devolverEdad(@PathVariable int dia,
                            @PathVariable int mes,
                            @PathVariable int ano){
        return Period.between(LocalDate.of(ano,mes,dia),LocalDate.now()).getYears();
    }

}
