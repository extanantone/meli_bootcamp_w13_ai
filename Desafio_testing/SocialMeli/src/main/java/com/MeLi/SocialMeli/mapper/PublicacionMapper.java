package com.MeLi.SocialMeli.mapper;

import com.MeLi.SocialMeli.DTO.PublicacionDTO;
import com.MeLi.SocialMeli.model.Publicacion;
import org.springframework.stereotype.Component;

@Component
public class PublicacionMapper {

    public PublicacionDTO PublicacionToPublicacionDTO(Publicacion pub){
        PublicacionDTO pubDTO = new PublicacionDTO();
        pubDTO.setUser_id(pub.getUser_id());
        pubDTO.setId_post(pub.getId_post());
        pubDTO.setDate(pub.getDate());
        pubDTO.setCategory(pub.getCategory());
        pubDTO.setPrice(pub.getPrice());
        return pubDTO;
    }


    public static Publicacion PublicacionDTOToPublicacion(PublicacionDTO pubDTO){
        Publicacion pub = new Publicacion();
        pub.setUser_id(pubDTO.getUser_id());
        pub.setId_post(pubDTO.getId_post());
        pub.setDate(pubDTO.getDate());
        pub.setDetails(ProductoMapper.ProductoDTOToProducto(pubDTO.getDetail()));
        pub.setCategory(pubDTO.getCategory());
        pub.setPrice(pubDTO.getPrice());
        return pub;
    }
}
