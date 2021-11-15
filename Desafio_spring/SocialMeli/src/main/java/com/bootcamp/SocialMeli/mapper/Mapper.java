package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.request.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.request.PromocionDTO;
import com.bootcamp.SocialMeli.dto.request.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.InfoPostDTO;
import com.bootcamp.SocialMeli.dto.response.PublicacionesDTO;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Promocion;
import com.bootcamp.SocialMeli.model.Publicacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

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

        promocion.setHas_promo(promocionDTO.isHas_promo());
        promocion.setDiscount(promocionDTO.getDiscount());

        return promocion;
    }

    public Producto detalleProductoDTOToProducto(DetalleProductoDTO detalleDTO){
        Producto producto = new Producto();

        producto.setProductId(detalleDTO.getProductId());
        producto.setProductName(detalleDTO.getProductName());
        producto.setType(detalleDTO.getType());
        producto.setBrand(detalleDTO.getBrand());
        producto.setColor(detalleDTO.getColor());
        producto.setNotes(detalleDTO.getNotes());

        return producto;
    }

    public PublicacionesDTO listPublicacionToPublicacionesDTO(int userId, List<Publicacion> publicaciones){
        PublicacionesDTO publicacionesDTO = new PublicacionesDTO();

        publicacionesDTO.setUserId(userId);
        publicacionesDTO.setPosts(publicaciones.stream().map(x -> publicacionToInfoPostDTO(x)).collect(Collectors.toList()));
        return publicacionesDTO;
    }

    public InfoPostDTO publicacionToInfoPostDTO(Publicacion publicacion){
        InfoPostDTO infoPostDTO = new InfoPostDTO();

        infoPostDTO.setIdPost(publicacion.getIdPost());
        infoPostDTO.setDate(publicacion.getDate());
        infoPostDTO.setCategory(publicacion.getCategory());
        infoPostDTO.setPrice(publicacion.getPrice());
        infoPostDTO.setDetail(getModelMapper().map(publicacion.getProducto(), DetalleProductoDTO.class));

        return infoPostDTO;
    }
}
