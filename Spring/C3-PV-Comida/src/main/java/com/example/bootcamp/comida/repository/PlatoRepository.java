package com.example.bootcamp.comida.repository;


import com.example.bootcamp.comida.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PlatoRepository implements IPlatoRepository {

    public List<Plato> platoList = new ArrayList<>();


    @Override
    public void guardarPlato(Plato p) {
        platoList.add(p);
    }

    @Override
    public List<Plato> obtenerPlatos() {
        return platoList;
    }

    @Override
    public Plato obtenerPlatoPorNombre(String platoName) {
        return platoList.stream().filter(p -> p.getName().toLowerCase().equals(platoName.toLowerCase())).findFirst().orElse(null);
    }


}
