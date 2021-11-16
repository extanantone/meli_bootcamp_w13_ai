package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.*;

public interface ISocialMeliService {
    SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor);
    CantSeguidoresDTO getCantSeguidores(Integer userId);
    SeguidoresDTO getSeguidores(Integer userId);
    SeguidoresDTO getSeguidores(Integer userId, String order);
    SeguidosDTO getVendedoresSeguidos(Integer userId);
    SeguidosDTO getVendedoresSeguidos(Integer userId, String order);
    SuccessDTO crearPublicacion(PublicacionDTO post);
    PublicacionesDTO getPublicacionesSeguidos(Integer userId);
    PublicacionesDTO getPublicacionesSeguidos(Integer userId, String order);
    SuccessDTO unfollowVendedor(Integer idSeguidor, Integer idVendedor);

    CantPromocionesDTO getCantPromociones(Integer userId);
    PromocionesDTO getProductosEnPromocion(Integer userId);
    PromocionesDTO getProductosEnPromocion(Integer userId, String order);
}
