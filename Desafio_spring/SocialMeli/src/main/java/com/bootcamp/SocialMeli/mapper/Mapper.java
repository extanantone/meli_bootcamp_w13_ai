package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.request.PromocionDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.InfoPromoDTO;
import com.bootcamp.SocialMeli.dto.response.PublicacionesDTO;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Promocion;
import com.bootcamp.SocialMeli.model.Publicacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilidad que permite mapear ciertos DTO a objetos de dominio y viceversa.
 */
@Component
public class Mapper {

    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    public Publicacion publicacionDTOToPublicacion(PublicacionDTO publicacionDTO){
        Publicacion publicacion = new Publicacion();

        publicacion.setIdPost(publicacionDTO.getIdPost());
        publicacion.setDate(publicacionDTO.getDate());
        publicacion.setPrice(publicacionDTO.getPrice());
        publicacion.setCategory(publicacionDTO.getCategory());
        publicacion.setProducto(getModelMapper().map(publicacionDTO.getDetail(), Producto.class));

        return publicacion;
    }

    public Promocion promocionDTOToPromocion(PromocionDTO promocionDTO){
        Promocion promocion = new Promocion();

        promocion.setIdPost(promocionDTO.getIdPost());
        promocion.setDate(promocionDTO.getDate());
        promocion.setPrice(promocionDTO.getPrice());
        promocion.setCategory(promocionDTO.getCategory());
        promocion.setProducto(getModelMapper().map(promocionDTO.getDetail(), Producto.class));

        promocion.setHasPromo(promocionDTO.isHasPromo());
        promocion.setDiscount(promocionDTO.getDiscount());

        return promocion;
    }

    public PublicacionesDTO listPublicacionToPublicacionesDTO(int userId, List<Publicacion> publicaciones){
        PublicacionesDTO publicacionesDTO = new PublicacionesDTO();

        publicacionesDTO.setUserId(userId);
        publicacionesDTO.setPosts(publicaciones.stream().map(x -> publicacionToPublicacionDTO(x)).collect(Collectors.toList()));
        return publicacionesDTO;
    }

    public PublicacionDTO publicacionToPublicacionDTO(Publicacion publicacion){
        PublicacionDTO publicacionDTO = new PublicacionDTO();

        publicacionDTO.setIdPost(publicacion.getIdPost());
        publicacionDTO.setDate(publicacion.getDate());
        publicacionDTO.setCategory(publicacion.getCategory());
        publicacionDTO.setPrice(publicacion.getPrice());
        publicacionDTO.setDetail(getModelMapper().map(publicacion.getProducto(), DetalleProductoDTO.class));

        return publicacionDTO;
    }

    public InfoPromoDTO publicacionToInfoPromoDTO(Promocion promocion){
        InfoPromoDTO infoPromoDTO = new InfoPromoDTO();

        infoPromoDTO.setIdPost(promocion.getIdPost());
        infoPromoDTO.setDate(promocion.getDate());
        infoPromoDTO.setCategory(promocion.getCategory());
        infoPromoDTO.setPrice(promocion.getPrice());
        infoPromoDTO.setDetail(getModelMapper().map(promocion.getProducto(), DetalleProductoDTO.class));
        infoPromoDTO.setHasPromo(promocion.isHasPromo());
        infoPromoDTO.setDiscount(promocion.getDiscount());

        return infoPromoDTO;
    }
}
