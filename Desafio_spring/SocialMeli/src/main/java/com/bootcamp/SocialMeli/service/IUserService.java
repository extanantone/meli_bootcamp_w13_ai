package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;

import java.util.List;

public interface IUserService {

    SeguidorDTO setSeguidor(int idSeguidor, int idSeguido);
    List<UserDTO> setUser(List<UserDTO> userDTOS);
    MesiguenCabtidadDTO getSequidores(int id);
    MesiguenDTO getMeSiguen(int id);
    MesiguenDTO getAquienSiguo(int id);
    SeguidorDTO dejarDeSeguir(int idSeguidor, int idSeguido);
    MesiguenDTO getOrdenadaMesiguen(int id, String order);
    MesiguenDTO getOrdenadaAquienSigo(int id ,String order);


}
