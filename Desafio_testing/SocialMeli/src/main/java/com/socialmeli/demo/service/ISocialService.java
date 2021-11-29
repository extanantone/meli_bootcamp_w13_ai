package com.socialmeli.demo.service;



import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.exceptions.Error;
import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Producto;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;

import java.time.LocalDate;
import java.util.List;

public interface ISocialService {
    //Seguir
    public RespuestaDTO follow(Integer id_comprado, Integer id_vendedor) throws Error;
    //Dejar de seguir
    public RespuestaDTO unfollow(Integer id_comprado, Integer id_vendedor) throws Error;

    //Errores
    public Comprador errorComprador(Integer id) throws Error;
    public Vendedor errorVendedor(Integer id) throws Error;

    //Operaciones

    public ProductoDTO productoDTO(Publicacion p);
    public Producto producto(PublicacionDTO pub);
    public PublicacionDTO PublicacionDTO(Publicacion p, ProductoDTO producto);
    public Publicacion PublicacionNormal(PublicacionDTO pub, Producto producto);

    public FollowsDTO contar (Integer id_vendedor) throws Error;
    public SeguidoresDTO buscarSeguidores (Integer id, String order) throws  Error;
    public SeguidoresDTO buscarSeguidos (Integer id, String order) throws Error;
    public RespuestaDTO addPost(PublicacionDTO pub) throws Error;
    List<VendedoresDTO> addPublicaciones(Integer id, String order) throws Error;
    public boolean validarFecha(LocalDate fecha);

    public RespuestaDTO addPromocion(PublicacionDTO pub) throws Error;
    public PromocionDTO contarPromocion (Integer id_vendedor) throws Error;
    public VendedoresDTO publicacionesEnPromocion (Integer id) throws Error;

}
