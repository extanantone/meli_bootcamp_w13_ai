package com.bootcamp.SocialMeli.Service;

import com.bootcamp.SocialMeli.DTO.SeguidorDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresCountDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresDTO;

public interface IUsuarioService {
    SeguidorDTO setSeguidor(int idUser, int idUserFollow);
    SeguidoresCountDTO getSequidores(int idUser);
    SeguidoresDTO getFollowers(int idUser);
    SeguidoresDTO getFollowed(int idUser);
}
