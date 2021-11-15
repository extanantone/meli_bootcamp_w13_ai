package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.publicacion.*;
import com.bootcamp.SocialMeli.model.Publicacion;
import org.springframework.stereotype.Component;

@Component
public class PublicacionMapper {
    ProductoMapper productoMapper;

    public PublicacionMapper(ProductoMapper productoMapper) {
        this.productoMapper = productoMapper;
    }

    public Publicacion publicacionDTOAPublicacion(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(publicacionDTO.getUserId());
        publicacion.setIdPost(publicacionDTO.getIdPost());
        publicacion.setDate(publicacionDTO.getDate());
        publicacion.setCategory(publicacionDTO.getCategory());
        publicacion.setPrice(publicacionDTO.getPrice());
        publicacion.setDetail(productoMapper.productoDTOAProducto(publicacionDTO.getDetail()));
        return publicacion;
    }

    public SoloPublicacionDTO publicacionASoloPublicacionDTO(Publicacion publicacion) {
        SoloPublicacionDTO soloPublicacionDTO = new SoloPublicacionDTO();
        soloPublicacionDTO.setIdPost(publicacion.getIdPost());
        soloPublicacionDTO.setDate(publicacion.getDate());
        soloPublicacionDTO.setCategory(publicacion.getCategory());
        soloPublicacionDTO.setPrice(publicacion.getPrice());
        soloPublicacionDTO.setDetail(productoMapper.productoAProductoDTO(publicacion.getDetail()));
        return soloPublicacionDTO;
    }

    public Publicacion publicacionPromoDTOAPublicacion(PublicacionPromoDTO publicacionPromoDTO) {
        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(publicacionPromoDTO.getUserId());
        publicacion.setIdPost(publicacionPromoDTO.getIdPost());
        publicacion.setDate(publicacionPromoDTO.getDate());
        publicacion.setCategory(publicacionPromoDTO.getCategory());
        publicacion.setPrice(publicacionPromoDTO.getPrice());
        publicacion.setHasPromo(publicacionPromoDTO.getHasPromo());
        publicacion.setDiscount(publicacionPromoDTO.getDiscount());
        publicacion.setDetail(productoMapper.productoDTOAProducto(publicacionPromoDTO.getDetail()));
        return publicacion;
    }

    public SoloPublicacionPromoDTO publicacionASoloPublicacionPromoDTO(Publicacion publicacion) {
        SoloPublicacionPromoDTO soloPublicacionPromoDTO = new SoloPublicacionPromoDTO();
        soloPublicacionPromoDTO.setIdPost(publicacion.getIdPost());
        soloPublicacionPromoDTO.setDate(publicacion.getDate());
        soloPublicacionPromoDTO.setCategory(publicacion.getCategory());
        soloPublicacionPromoDTO.setPrice(publicacion.getPrice());
        soloPublicacionPromoDTO.setHasPromo(publicacion.getHasPromo());
        soloPublicacionPromoDTO.setDiscount(publicacion.getDiscount());
        soloPublicacionPromoDTO.setDetail(productoMapper.productoAProductoDTO(publicacion.getDetail()));
        return soloPublicacionPromoDTO;
    }

}
