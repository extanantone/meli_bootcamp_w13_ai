package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Usuario;

import java.util.List;

public interface ISocialMeliRepository {
    public Usuario buscarUsuario(Integer idUsuario);

    //public void seguirUsuario(Integer idSeguidor, Integer idVendedor);

    public List<Usuario> buscarSeguidores(Usuario vendedor);

}
