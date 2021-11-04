package com.example.bootcamp.comida.repository;


import com.example.bootcamp.comida.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PlatoRepository implements IPlatoRepository {

    public List<Plato> platoList;


    @Override
    public void guardarPlato(Plato p) {
        platoList.add(p);
    }
}
