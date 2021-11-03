package com.Meli.EdadPersona.Controller;

import com.Meli.EdadPersona.Service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonaController {

    @GetMapping("/api/v1/edad/{day}/{month}/{year}")
    public long obtenerEdad(@PathVariable int day,@PathVariable int month,@PathVariable int year) {
        return PersonaService.calcularEdad(day, month, year);
    }
}
