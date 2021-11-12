package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.response.CantSeguidoresDTO;
import com.bootcamp.SocialMeli.dto.response.SeguidoresDTO;
import com.bootcamp.SocialMeli.dto.response.SeguidosDTO;
import com.bootcamp.SocialMeli.dto.response.SuccessDTO;

public interface ISocialMeliService {
    SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor);
    CantSeguidoresDTO getCantSeguidores(Integer userId);
    SeguidoresDTO getSeguidores(Integer userId);
    SeguidoresDTO getSeguidores(Integer userId, String order);
    SeguidosDTO getVendedoresSeguidos(Integer userId);
    SeguidosDTO getVendedoresSeguidos(Integer userId, String order);
    SuccessDTO unfollowVendedor(Integer idSeguidor, Integer idVendedor);
}
