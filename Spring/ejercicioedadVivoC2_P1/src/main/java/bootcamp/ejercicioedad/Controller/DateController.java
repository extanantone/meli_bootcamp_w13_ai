package bootcamp.ejercicioedad.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class DateController {

    @GetMapping("/{dia}/{mes}/{year}")
        public String calcularEdad(@PathVariable int dia,
                                   @PathVariable int mes,
                                   @PathVariable int year) {

        Period edad = Period.between(LocalDate.of(year,mes,dia), LocalDate.now());

        return String.format("%d años",
                edad.getYears());
    }
}
