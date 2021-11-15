package com.bootcamp.SocialMeli.service.publicacion;

import com.bootcamp.SocialMeli.dto.publicacion.*;

public interface IPublicacionService {
    void realizarPublicacion(PublicacionDTO publicacionDTO);

    PublicacionFollowedDTO listaPublicacionesFollowed(Integer userId);

    PublicacionFollowedDTO listaPublicacionesFollowedAsc(Integer userId);

    PublicacionFollowedDTO listaPublicacionesFollowedDesc(Integer userId);

    void realizarPublicacionPromo(PublicacionPromoDTO publicacionPromoDTO);

    PublicacionPromoCountDTO cantidadPublicacionPromo(Integer userId);

    PublicacionPromoListDTO listaPublicacionesPromo(Integer userId);

}
