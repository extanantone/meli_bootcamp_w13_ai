package com.Meli.Deportista.Controller;

import com.Meli.Deportista.Model.Sport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class SportController {
    List<Sport> listSport = new LinkedList<>();


    @GetMapping("/findSports")
    public void findSports() {
        return PersonaService.calcularEdad(day, month, year);
    }
}
