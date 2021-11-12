package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.SeguidorDTO;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.model.Seguidor;

public interface IUserService {

    SeguidorDTO setSeguidor(int idSeguidor, int idSeguido);
}
