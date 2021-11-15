package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.request.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.request.PublicacionDTO;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Publicacion publicacionDTOToPublicacion(PublicacionDTO publicacionDTO){
        Publicacion publicacion = new Publicacion();

        publicacion.setIdPost(publicacionDTO.getIdPost());
        publicacion.setDate(publicacionDTO.getDate());
        publicacion.setPrice(publicacionDTO.getPrice());
        publicacion.setCategory(publicacionDTO.getCategory());
        publicacion.setProducto(detallePublicacionDTOToProducto(publicacionDTO.getDetail()));

        return publicacion;
    }

    public Producto detallePublicacionDTOToProducto(DetalleProductoDTO detalleDTO){
        Producto producto = new Producto();

        producto.setProductId(detalleDTO.getProductId());
        producto.setProductName(detalleDTO.getProductName());
        producto.setType(detalleDTO.getType());
        producto.setBrand(detalleDTO.getBrand());
        producto.setColor(detalleDTO.getColor());
        producto.setNotes(detalleDTO.getNotes());

        return producto;
    }
}
