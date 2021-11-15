package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.dto.controllerToService.RequestPostsFromFollowedsDTO;
import com.example.socialmeli.demo.model.Publicacion;
import com.example.socialmeli.demo.model.PublicacionPromocion;

import java.util.List;

public interface IPublicacionRepository {

    public Publicacion crearPublicacion(Publicacion p);

   public List<Publicacion>  obtenerPublicacionesPorVendedorIdPosteriores2Semanas(int userId, String order);

    public List<Publicacion> getPromoPostListOfUserId(int userId);

   public int countPromoPostOfUser(int userId);

}
