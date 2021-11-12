package com.example.socialmeli.demo.repository;



import com.example.socialmeli.demo.model.Comprador;

import java.util.HashMap;
import java.util.Map;

public class CompradorRepository implements ICompradorRepository{

    private Map<Long, Comprador> listaCompradores = new HashMap<>();

    @Override
    public Comprador crearComprador(Comprador c) {
        return null;
    }

    @Override
    public Comprador obtenerCompradorPorID(int id) {
        return listaCompradores.get(id);
    }


}
