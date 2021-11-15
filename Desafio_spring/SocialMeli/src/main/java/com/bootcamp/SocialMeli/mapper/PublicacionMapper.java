package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.publicacion.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionPromoCountDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionPromoDTO;
import com.bootcamp.SocialMeli.dto.publicacion.SoloPublicacionDTO;
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

    public PublicacionDTO publicacionAPublicacionDTO(Publicacion publicacion) {
        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setUserId(publicacion.getUserId());
        publicacionDTO.setIdPost(publicacion.getIdPost());
        publicacionDTO.setDate(publicacion.getDate());
        publicacionDTO.setCategory(publicacion.getCategory());
        publicacionDTO.setPrice(publicacion.getPrice());
        publicacionDTO.setDetail(productoMapper.productoAProductoDTO(publicacion.getDetail()));
        return publicacionDTO;
    }

    public Publicacion soloPublicacionDTOAPublicacion(SoloPublicacionDTO soloPublicacionDTO) {
        Publicacion publicacion = new Publicacion();
        publicacion.setIdPost(soloPublicacionDTO.getIdPost());
        publicacion.setDate(soloPublicacionDTO.getDate());
        publicacion.setCategory(soloPublicacionDTO.getCategory());
        publicacion.setPrice(soloPublicacionDTO.getPrice());
        publicacion.setDetail(productoMapper.productoDTOAProducto(soloPublicacionDTO.getDetail()));
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

    public PublicacionPromoDTO publicacionAPublicacionPromoDTO(Publicacion publicacion, String userName) {
        PublicacionPromoDTO publicacionPromoDTO = new PublicacionPromoDTO();
        publicacionPromoDTO.setUserId(publicacion.getUserId());
        publicacionPromoDTO.setUserName(userName);
        publicacionPromoDTO.setIdPost(publicacion.getIdPost());
        publicacionPromoDTO.setDate(publicacion.getDate());
        publicacionPromoDTO.setCategory(publicacion.getCategory());
        publicacionPromoDTO.setPrice(publicacion.getPrice());
        publicacionPromoDTO.setHasPromo(publicacion.getHasPromo());
        publicacionPromoDTO.setDiscount(publicacion.getDiscount());
        publicacionPromoDTO.setDetail(productoMapper.productoAProductoDTO(publicacion.getDetail()));
        return publicacionPromoDTO;
    }

}
