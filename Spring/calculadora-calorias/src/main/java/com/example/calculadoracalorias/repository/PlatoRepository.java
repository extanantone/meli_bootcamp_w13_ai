package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PlatoRepository implements IRespositorio<Plato> {

    private final Map<String, Plato> platos = new HashMap<>();

    @Override
    public Plato guardarElemento(Plato plato) {
        Plato platoReemplazado = platos.put(plato.getNombre(), plato);
        if (platoReemplazado == null) return plato;
        return platoReemplazado;
    }

    @Override
    public Plato obtenerElementoPorNombre(String nombre) {
        if (platos.containsKey(nombre)) return platos.get(nombre);
        return null;
    }
}
