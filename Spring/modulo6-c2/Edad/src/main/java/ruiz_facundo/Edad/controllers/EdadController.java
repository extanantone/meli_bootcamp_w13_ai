package ruiz_facundo.Edad.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EdadController {
    @GetMapping("{dia}/{mes}/{year}")
    public Integer obtenerEdadDeFecha(@PathVariable("dia") Integer inDia,
                                      @PathVariable("mes") Integer inMes,
                                      @PathVariable("year") Integer inYear) {
        Integer outEdad = 0;
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime diaDeNacimiento = LocalDateTime.of(inYear, inMes, inDia, 0, 0);
        if (hoy.getYear() - diaDeNacimiento.getYear() > 0) {
            outEdad = hoy.getYear() - diaDeNacimiento.getYear() - 1;
            if (hoy.getMonthValue() > diaDeNacimiento.getMonthValue()) outEdad++;
            else if (hoy.getMonthValue() == diaDeNacimiento.getMonthValue() &&
                    !(hoy.getDayOfMonth() < diaDeNacimiento.getDayOfMonth())) outEdad++;
        }
        return outEdad;
    }
}
