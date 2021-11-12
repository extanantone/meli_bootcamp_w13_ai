package com.example.socialMeli.service;

import com.example.socialMeli.dto.CantidadFollowsDTO;
import com.example.socialMeli.dto.RespuestaSimpleDTO;
import com.example.socialMeli.dto.SeguidoresDTO;
import com.example.socialMeli.dto.SeguidosDTO;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;

public interface ISocialMeliService {
    public void cargarDatos();
    public RespuestaSimpleDTO seguir (int id_comprado, int id_vendedor) throws UsuarioNoEncontradoError;
    public CantidadFollowsDTO contar (int id_vendedor) throws UsuarioNoEncontradoError;
    public SeguidoresDTO buscarSeguidores (int id) throws  UsuarioNoEncontradoError;
    public SeguidosDTO buscarSeguidos (int id) throws UsuarioNoEncontradoError;
}
