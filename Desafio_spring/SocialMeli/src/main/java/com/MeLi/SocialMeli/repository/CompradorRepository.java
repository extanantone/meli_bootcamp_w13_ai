package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Usuario;
import com.MeLi.SocialMeli.model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class CompradorRepository implements CompradorRepositoryImplement{

    HashMap<Integer, Comprador> compradores = new HashMap();

    public CompradorRepository(){
        Comprador comprador1 = new Comprador(1,"Pedro");
        compradores.put(comprador1.getId(),comprador1);

        Comprador comprador2 = new Comprador(2,"Ivan");
        compradores.put(comprador2.getId(),comprador2);

        Comprador comprado3 = new Comprador(3,"Daniel");
        compradores.put(comprado3.getId(),comprado3);
    }

    @Override
    public Set<Map.Entry<Integer, Comprador>> findAll() {
        return compradores.entrySet();
    }

    @Override
    public Optional<Comprador> find(Integer id) {
        if( compradores.containsKey( id ) ) {
            return Optional.of(compradores.get(id));
        }
        return Optional.empty();
    }
}
