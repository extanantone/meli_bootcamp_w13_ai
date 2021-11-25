package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.producto.ProductoDTO;
import com.bootcamp.SocialMeli.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public Producto productoDTOAProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setProductId(productoDTO.getProductId());
        producto.setProductName(productoDTO.getProductName());
        producto.setBrand(productoDTO.getBrand());
        producto.setColor(productoDTO.getColor());
        producto.setType(productoDTO.getType());
        producto.setNotes(productoDTO.getNotes());
        return producto;
    }

    public ProductoDTO productoAProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setProductId(producto.getProductId());
        productoDTO.setProductName(producto.getProductName());
        productoDTO.setBrand(producto.getBrand());
        productoDTO.setColor(producto.getColor());
        productoDTO.setType(producto.getType());
        productoDTO.setNotes(producto.getNotes());
        return productoDTO;
    }
}
