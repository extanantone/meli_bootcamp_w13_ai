package com.bootcamp.SocialMeli.service.publicacion;

import com.bootcamp.SocialMeli.dto.publicacion.*;

public interface IPublicacionService {
    void realizarPublicacion(PublicacionDTO publicacionDTO);

    PublicacionFollowedDTO listaPublicacionesFollowed(Integer userId, String order);

    void realizarPublicacionPromo(PublicacionPromoDTO publicacionPromoDTO);

    PublicacionPromoCountDTO cantidadPublicacionPromo(Integer userId);

    PublicacionPromoListDTO listaPublicacionesPromo(Integer userId);

}
