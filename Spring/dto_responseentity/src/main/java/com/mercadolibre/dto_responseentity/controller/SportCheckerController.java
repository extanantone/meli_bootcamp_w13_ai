package com.mercadolibre.dto_responseentity.controller;

import com.mercadolibre.dto_responseentity.dto.DeporteDTO;
import com.mercadolibre.dto_responseentity.dto.InfoPersonaDTO;
import com.mercadolibre.dto_responseentity.dto.PersonaDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.SwitchPoint;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SportCheckerController {
    ArrayList<PersonaDTO> mArrayPersonas= new ArrayList<>();
    ArrayList<DeporteDTO> mArrayDeportes= new ArrayList<>();

    @PostMapping("/createPerson")
    public ResponseEntity<DeporteDTO> createPerson(@RequestBody Map<String, String> tempPersonaDTO){
        String uri= "http://localhost:8080/findSport/" + tempPersonaDTO.get("nombre_deporte");
        RestTemplate restTemplate= new RestTemplate();
        try{
            mArrayDeportes.add(new DeporteDTO("Rugby", "Alto rendimiento"));
            ResponseEntity<DeporteDTO[]> response= restTemplate.getForEntity(uri, DeporteDTO[].class);
            mArrayPersonas.add(new PersonaDTO(tempPersonaDTO.get("nombre"), tempPersonaDTO.get("apellido"),
                    Integer.parseInt(tempPersonaDTO.get("edad")), response.getBody()[0]));
        } catch (Exception e) {
            return new ResponseEntity("El deporte " + tempPersonaDTO.get("nombre_deporte") + " no existe " +
                    "dentro del sistema", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("La persona " + tempPersonaDTO.toString() + " ha sido creada", HttpStatus.OK);
    }

    @PostMapping("/createSport/")
    public ResponseEntity<DeporteDTO> createSport(@RequestBody DeporteDTO tempDeporteDTO){
        mArrayDeportes.add(tempDeporteDTO);
        return new ResponseEntity("El deporte " + tempDeporteDTO.toString() + " ha sido creada", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/findSports")
    public ResponseEntity<DeporteDTO> findSports(){
        return new ResponseEntity(mArrayDeportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSpecificSport(@PathVariable String name){
        List<DeporteDTO> tempList = mArrayDeportes.stream()
                .filter(mDeporte -> mDeporte.getNombre().equals(String.valueOf(name)))
                .collect(Collectors.toList());
        if (tempList.size() == 0)
            return new ResponseEntity("No existen deportes con ese nombre", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(tempList, HttpStatus.OK);

    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<InfoPersonaDTO> findSportByPersons(){
        List<InfoPersonaDTO> tempPersonas = mArrayPersonas.stream()
                                                        .map(p -> new InfoPersonaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()))
                                                        .collect(Collectors.toList());
        return new ResponseEntity(tempPersonas, HttpStatus.OK);
    }
}