package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Comprador;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class CompradorRepository implements CompradorRepositoryImplement{

    HashMap<Integer, Comprador> compradores = new HashMap();

    public CompradorRepository(){
        Comprador comprador1 = new Comprador(1,"Pedro");
        compradores.put(comprador1.getId(),comprador1);

        Comprador comprador2 = new Comprador(2,"Ivan");
        compradores.put(comprador2.getId(),comprador2);
    }

    @Override
    public HashMap<Integer, Comprador> findAll() {
        return compradores;
    }

    @Override
    public Optional<Comprador> find(Integer id) {
        if( compradores.containsKey( id ) ) {
            return Optional.of(compradores.get(id));
        }
        return Optional.empty();
    }
}
