package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.request.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.*;

import java.util.List;

public interface ISocialMeliService {
    SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor);
    CantSeguidoresDTO getCantSeguidores(Integer userId);
    SeguidoresDTO getSeguidores(Integer userId);
    SeguidoresDTO getSeguidores(Integer userId, String order);
    SeguidosDTO getVendedoresSeguidos(Integer userId);
    SeguidosDTO getVendedoresSeguidos(Integer userId, String order);
    SuccessDTO crearPublicacion(PublicacionDTO post);
    PublicacionesDTO getPublicacionesSeguidos(Integer userId);
    SuccessDTO unfollowVendedor(Integer idSeguidor, Integer idVendedor);
}
