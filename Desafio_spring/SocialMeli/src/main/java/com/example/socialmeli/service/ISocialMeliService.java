package com.example.socialmeli.service;





import com.example.socialmeli.DTO.*;
import com.example.socialmeli.model.Comprador;
import com.example.socialmeli.model.Producto;
import com.example.socialmeli.model.Publicacion;
import com.example.socialmeli.model.Vendedor;

import java.time.LocalDate;
import java.util.List;

public interface ISocialMeliService {
    //Seguir
    public RespuestaDTO follow(int id_comprado, int id_vendedor) throws Error;
    //Dejar de seguir
    public RespuestaDTO unfollow(int id_comprado, int id_vendedor) throws Error;

    //Errores
    public Comprador errorComprador(int id) throws Error;
    public Vendedor errorVendedor(int id) throws Error;

    //Operaciones

    public ProductoDTO productoDTO(Publicacion p);
    public Producto producto(PublicacionDTO pub);
    public PublicacionDTO PublicacionDTO(Publicacion p, ProductoDTO producto);
    public Publicacion PublicacionNormal(PublicacionDTO pub, Producto producto);

    public FollowsDTO contar (int id_vendedor) throws Error;
    public SeguidoresDTO buscarSeguidores (int id, String order) throws  Error;
    public SeguidosDTO buscarSeguidos (int id, String order) throws Error;
    public RespuestaDTO addPost(PublicacionDTO pub) throws Error;
    List<VendedoresDTO> addPublicaciones(int id, String order) throws Error;
    public boolean validarFecha(LocalDate fecha);

    public RespuestaDTO addPromocion(PublicacionDTO pub) throws Error;
    public PromocionDTO contarPromocion (int id_vendedor) throws Error;
    public VendedoresDTO publicacionesEnPromocion (int id) throws Error;

}
