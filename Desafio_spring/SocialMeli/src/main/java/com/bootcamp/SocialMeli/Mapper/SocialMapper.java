package com.bootcamp.SocialMeli.Mapper;


import com.bootcamp.SocialMeli.DTO.DetallePublicacionDTO;
import com.bootcamp.SocialMeli.DTO.PublicacionDTO;
import com.bootcamp.SocialMeli.DTO.UsuarioDTO;
import com.bootcamp.SocialMeli.Model.DetallePublicacion;
import com.bootcamp.SocialMeli.Model.Publicacion;
import com.bootcamp.SocialMeli.Model.Usuario;

public class SocialMapper {

    public static UsuarioDTO UsuarioToUsuarioDTO(Usuario usuario){
        return new UsuarioDTO(usuario.getUserId(), usuario.getUserName());
    }

    public static Publicacion PublicDTOaPublic(PublicacionDTO publicacionDTO){

        return new Publicacion(publicacionDTO.getUserId(),publicacionDTO.getIdPost(),publicacionDTO.getDate(), DetallePDTOaDetalle(publicacionDTO.getDetail()),publicacionDTO.getCategory(), publicacionDTO.getPrice());
    }


    public static DetallePublicacion DetallePDTOaDetalle(DetallePublicacionDTO detallePDTO){
        return new DetallePublicacion(detallePDTO.getProductId(),detallePDTO.getProductName(),detallePDTO.getType(),detallePDTO.getBrand(),detallePDTO.getColor(),detallePDTO.getNotes());
    }

    public static PublicacionDTO PublicacionTOPublicacionDTO(Publicacion publicacion){

        return new PublicacionDTO(publicacion.getUserId(), publicacion.getIdPost(),publicacion.getDate(), DetalleTODetalleDTO(publicacion.getDetail()),publicacion.getCategory(),publicacion.getPrice());
    }


    public static DetallePublicacionDTO DetalleTODetalleDTO(DetallePublicacion detalle){

        return new DetallePublicacionDTO(detalle.getProductId(),detalle.getProductName(),detalle.getType(),detalle.getBrand(),detalle.getColor(),detalle.getNotes());

    }

}
