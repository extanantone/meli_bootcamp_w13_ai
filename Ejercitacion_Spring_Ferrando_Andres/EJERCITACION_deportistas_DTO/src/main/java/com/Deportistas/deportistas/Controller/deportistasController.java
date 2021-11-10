package com.Deportistas.deportistas.Controller;

import com.Deportistas.deportistas.DTO.DeportistaDTO;
import com.Deportistas.deportistas.Model.Deporte;
import com.Deportistas.deportistas.Model.Persona;
import com.Deportistas.deportistas.Service.serviceDeportes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class deportistasController {

serviceDeportes serviceDep = new serviceDeportes();


    @GetMapping("/findSports")
    @ResponseBody
    public List<Deporte> obtenerDeportes() {

        return serviceDep.getListaDeportes();

    }

    @GetMapping("/findSports/{deporte}")
        ResponseEntity<String> buscarDeporte(@PathVariable String deporte) {

        int nivel = serviceDep.buscarDeporte(deporte);
        if(nivel==-1)
        {
            return new ResponseEntity<>("No se encontro deporte", HttpStatus.BAD_REQUEST) ;
        }

        return new ResponseEntity<>("El nivel de "+deporte+" es "+ nivel, HttpStatus.OK)  ;

    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<DeportistaDTO> personasDeportes() {

        return serviceDep.getListaDeportistasDTO();

    }

}
