package com.example.socialMeli.service;

import com.example.socialMeli.dto.*;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Producto;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface ISocialMeliService {
    public void cargarDatos();
    public Comprador errorComprador(int id) throws UsuarioNoEncontradoError;
    public Vendedor errorVendedor(int id) throws UsuarioNoEncontradoError;
    public ProductoDTO deProductoAProductoDTO(Publicacion p);
    public Producto deProductoDTOAProducto(PublicacionDTO pub);
    public PublicacionDTO crearPublicacionDTO(Publicacion p, ProductoDTO producto);
    public Publicacion crearPublicacionNormal(PublicacionDTO pub, Producto producto);
    public RespuestaSimpleDTO seguir (int id_comprado, int id_vendedor) throws UsuarioNoEncontradoError;
    public CantidadFollowsDTO contar (int id_vendedor) throws UsuarioNoEncontradoError;
    public SeguidoresDTO buscarSeguidores (int id, String order) throws  UsuarioNoEncontradoError;
    public SeguidosDTO buscarSeguidos (int id, String order) throws UsuarioNoEncontradoError;
    public RespuestaSimpleDTO añadirPost (PublicacionDTO pub) throws UsuarioNoEncontradoError;
    public List<Publicacion>ordenar(List<Publicacion> guardadas, String order);
    public boolean verificaTamaño(List<?> lista);
    List<PublicacionesVendedoresDTO> obtenerPublicaciones (int id, String order) throws UsuarioNoEncontradoError;
    public boolean verificarVendedorYFecha(LocalDate fecha);
    public RespuestaSimpleDTO dejarDeSeguir (int id_comprado, int id_vendedor) throws UsuarioNoEncontradoError;
    public RespuestaSimpleDTO añadirPostPromocion (PublicacionDTO pub) throws UsuarioNoEncontradoError;
    public CantidadPromosDTO contarPromocion (int id_vendedor) throws UsuarioNoEncontradoError;
    public PublicacionesVendedoresDTO publicacionesEnPromocion (int id) throws UsuarioNoEncontradoError;
    public List<PublicacionDTO> publicacionesPorTipo(String tipo) throws UsuarioNoEncontradoError;
}
