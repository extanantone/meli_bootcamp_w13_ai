package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.MesiguenCabtidadDTO;
import com.bootcamp.SocialMeli.dto.MesiguenDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.SeguidorDTO;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.model.Seguidor;

public interface IUserService {

    SeguidorDTO setSeguidor(int idSeguidor, int idSeguido);
    MesiguenCabtidadDTO getSequidores(int id);
    MesiguenDTO getMeSiguen(int id);
    MesiguenDTO getAquienSiguo(int id);
    SeguidorDTO dejarDeSeguir(int idSeguidor, int idSeguido);
    MesiguenDTO getOrdenadaMesiguen(int id, String order);
    MesiguenDTO getOrdenadaAquienSigo(int id ,String order);


}
