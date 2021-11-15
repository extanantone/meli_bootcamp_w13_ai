package com.bootcamp.SocialMeli.service.publicacion;

import com.bootcamp.SocialMeli.dto.publicacion.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionFollowedDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionPromoCountDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionPromoDTO;

import java.util.List;


public interface IPublicacionService {
    public void realizarPublicacion(PublicacionDTO publicacionDTO);

    public PublicacionFollowedDTO listaPublicacionesFollowed(Integer userId);

    public PublicacionFollowedDTO listaPublicacionesFollowedAsc(Integer userId);

    public PublicacionFollowedDTO listaPublicacionesFollowedDesc(Integer userId);

    public void realizarPublicacionPromo(PublicacionPromoDTO publicacionPromoDTO);

    public PublicacionPromoCountDTO cantidadPublicacionPromo(Integer userId);

    public List<PublicacionPromoDTO> listaPublicacionesPromo(Integer userId);

}
