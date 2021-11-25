package com.desafio_spring.principal.servicios;

import com.desafio_spring.principal.dto.ConteosDTO;
import com.desafio_spring.principal.dto.ListaPublicacionesDTO;
import com.desafio_spring.principal.dto.PublicacionesDTO;

import java.util.List;

public interface IServicioPublicaciones<T> {
    public void crearPublicacion(T nuevo);
    public void crearPublicacionPromo(PublicacionesDTO nuevo);
    public List<T> consultarPublicaciones(Integer userId, String order);
    public ConteosDTO contarPublicacionesPromo(Integer userId);
    public ConteosDTO contarPublicaciones(Integer userId);
    public ListaPublicacionesDTO obtenerPubsPromocion(Integer userId,String order);


}
