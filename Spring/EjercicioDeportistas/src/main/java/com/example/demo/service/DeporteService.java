package com.example.demo.service;

import com.example.demo.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class DeporteService {
    public List<Deporte> listaDeportes = new ArrayList<>();

    public void inicializarDeportes(){
        Deporte d = new Deporte("Tenis",3);
        listaDeportes.add(d);
        d = new Deporte("Basket",2);
        listaDeportes.add(d);
        d = new Deporte("Natacion",5);
        listaDeportes.add(d);
        d = new Deporte("Rugby",3);
        listaDeportes.add(d);
        d = new Deporte("Hockey",4);
        listaDeportes.add(d);
        d = new Deporte("WaterPolo",10);
        listaDeportes.add(d);
        d = new Deporte("Bochas",1);
        listaDeportes.add(d);
    }

    public ResponseEntity<?> buscarDeporte(String nombreDeporte){
        Deporte d = listaDeportes.stream().filter(x -> x.getNombre().equals(nombreDeporte)).findFirst().orElse(null);//.orElseGet(null);
        if (d != null )
            return new ResponseEntity(d.getNivel(), HttpStatus.OK);
        else
            return new ResponseEntity("No existe el deporte.", HttpStatus.NOT_FOUND);


    }

}
