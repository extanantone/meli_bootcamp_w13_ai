package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Publicacion;
import com.MeLi.SocialMeli.model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public List<Publicacion> publicacionesVendedor(int id){

        List<Publicacion> publicaciones = new ArrayList<>();

        for (Map.Entry<Integer, Publicacion> entry: pubList.entrySet()) {
            if(entry.getValue().getUser_id() == id){
                publicaciones.add(entry.getValue());
            }
        }
        return  publicaciones;
    }

    @Override
    public Optional<Publicacion> find(Integer id){
        if( pubList.containsKey( id ) ) {
            return Optional.of(pubList.get(id));
        }
        return Optional.empty();
    }
}
