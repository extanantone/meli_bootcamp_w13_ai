package apiEdad.apiEdad;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class ControladorApiEdad {

    @GetMapping("/{dd}/{mm}/{yyyy}")

    public String apiEdad(@PathVariable("dd") String dia,
                          @PathVariable("mm") String mes,
                         @PathVariable("yyyy") String anio){

        StringBuilder fecha = new StringBuilder();
        fecha.append(dia);
        fecha.append(mes);
        fecha.append(anio);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return String.format("Tu edad es: %d años %d meses %d dias", periodo.getYears(), periodo.getMonths(), periodo.getDays());

    }


    }
