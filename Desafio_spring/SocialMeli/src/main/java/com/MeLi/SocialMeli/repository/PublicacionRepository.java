package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Publicacion;
import com.MeLi.SocialMeli.model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class PublicacionRepository implements PublicacionRepositoryImplement{

    private HashMap<Integer, Publicacion> pubList = new HashMap<>();

    @Override
    public Publicacion nuevaPublicacion(Publicacion pub) {
        pubList.put(pub.getId_post(),pub);
        return pub;
    }

    public HashMap<Integer, Publicacion> findAll() {
        return pubList;
    }

    @Override
    public Optional<Publicacion> find(Integer id){
        if( pubList.containsKey( id ) ) {
            return Optional.of(pubList.get(id));
        }
        return Optional.empty();
    }
}
