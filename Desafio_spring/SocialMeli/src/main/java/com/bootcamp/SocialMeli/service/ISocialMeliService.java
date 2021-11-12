package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.response.CantSeguidoresDTO;
import com.bootcamp.SocialMeli.dto.response.SuccessDTO;

public interface ISocialMeliService {

    SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor);
    CantSeguidoresDTO getCantSeguidores(Integer userId);
    SuccessDTO unfollowVendedor(Integer idSeguidor, Integer idVendedor);
}
