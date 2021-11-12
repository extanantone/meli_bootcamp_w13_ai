package com.desafio_spring.principal.repositorios;

import com.desafio_spring.principal.modelo.Publicacion;
import com.desafio_spring.principal.modelo.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
