package com.desafio_testing.principal.repositorios;

import com.desafio_testing.principal.modelo.Publicacion;
import com.desafio_testing.principal.modelo.Usuario;

import java.time.LocalDate;
import java.util.List;

/**
 *
 */
public interface IRepositorios {

    public void crearPublicacion(Publicacion nuevo);
    public void registrarSeguidor(Usuario aSeguir, Usuario seguidor);
    public void quitarSeguidor(Usuario aSeguir,Usuario seguidor);
    public Usuario findUserById(Integer idUser);
    public List<Usuario> obtenerSeguidos(Integer idUser);
    public List<Usuario> obtenerSeguidores(Integer idUser);
    public List<Publicacion> publicacionesParaSeguidor(Usuario user, LocalDate limite);
    public List<Publicacion> obtenerPubsDeVendedor(Integer userId);

}
