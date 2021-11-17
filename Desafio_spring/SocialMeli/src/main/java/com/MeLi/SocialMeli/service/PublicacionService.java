package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.PublicacionDTO;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.exception.NotPubException;
import com.MeLi.SocialMeli.mapper.CompradorMapper;
import com.MeLi.SocialMeli.mapper.PublicacionMapper;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Producto;
import com.MeLi.SocialMeli.model.Publicacion;
import com.MeLi.SocialMeli.repository.PublicacionRepositoryImplement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PublicacionService implements PublicacionServiceImplement{

    private PublicacionRepositoryImplement publicacionRepositoryImplement;

    public PublicacionService(PublicacionRepositoryImplement publicacionRepositoryImplement){
        this.publicacionRepositoryImplement = publicacionRepositoryImplement;
    }

    @Override
    public Publicacion addNewPub(PublicacionDTO pubDTO) throws NotPubException {
        try{
            Publicacion pub = new PublicacionMapper().PublicacionDTOToPublicacion(pubDTO);
            return publicacionRepositoryImplement.nuevaPublicacion(pub);
        }catch (Exception e){
            throw(new NotPubException());
        }
    }

    @Override
    public List<Publicacion> obtenerPublicaciones(int idUser) throws NotFoundVendedorException{

        HashMap<Integer, Publicacion> publicaciones = publicacionRepositoryImplement.findAll();
        ArrayList publicacionesUsuario = new ArrayList();

        for (Map.Entry<Integer, Publicacion> entry : publicaciones.entrySet()) {
            if(entry.getValue().getUser_id() == idUser){
                Publicacion publicacion = entry.getValue();
                publicacionesUsuario.add(publicacion);
            }else{
                throw (new NotFoundVendedorException(idUser));
            }
        }

        return publicacionesUsuario;
    }

}
