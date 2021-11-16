package com.Meli.Deportista.Service;

import com.Meli.Deportista.DTO.SportDTO;
import com.Meli.Deportista.Model.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;

public class SportService {

    public ResponseEntity<List<SportDTO>> getAllSports(List<Sport> sport){
        List<SportDTO> listSport = new LinkedList<>();
        for(Sport s: sport){
            listSport.add(new SportDTO(s.getName(),s.getLevel()));

        }
        return new ResponseEntity<List<SportDTO>>(listSport, HttpStatus.OK);
    }
}
