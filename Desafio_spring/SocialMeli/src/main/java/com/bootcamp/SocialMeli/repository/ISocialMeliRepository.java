package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Usuario;

public interface ISocialMeliRepository {
    public Usuario buscarUsuario(Integer idUsuario);

    public void seguirUsuario(Integer idSeguidor, Integer idVendedor);

}
