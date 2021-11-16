package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.ProductoDTO;
import com.bootcamp.SocialMeli.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public static Producto productoDTOToProducto(ProductoDTO productoDTO) {
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
