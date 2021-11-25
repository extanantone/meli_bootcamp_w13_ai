package com.MeLi.SocialMeli.mapper;

import com.MeLi.SocialMeli.DTO.ProductoDTO;
import com.MeLi.SocialMeli.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public static Producto ProductoDTOToProducto(ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setProduct_id(productoDTO.getProduct_id());
        producto.setProduct_name(productoDTO.getProduct_name());
        producto.setType(productoDTO.getType());
        producto.setBrand(productoDTO.getBrand());
        producto.setColor(productoDTO.getColor());
        producto.setNotes(productoDTO.getNotes());
        return producto;
    }
}
