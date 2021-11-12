package com.desafio_spring.principal.servicios;

import com.desafio_spring.principal.dto.ConteosDTO;
import com.desafio_spring.principal.dto.ListaPublicacionesDTO;
import com.desafio_spring.principal.dto.PublicacionesDTO;
import com.desafio_spring.principal.enumerados.EnumOrdenes;
import com.desafio_spring.principal.excepciones.NegocioException;
import com.desafio_spring.principal.modelo.Producto;
import com.desafio_spring.principal.modelo.Publicacion;
import com.desafio_spring.principal.modelo.Usuario;
import com.desafio_spring.principal.repositorios.IRepositorios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("ServicioPublicaciones")
public class ServicioPublicaciones implements IServicioPublicaciones<PublicacionesDTO>{

    @Autowired
    private IRepositorios repos;

    @Autowired
    private ModelMapper mapper;

    /**
     * Crear publicacion en base a los DTO
     * @param nuevo Nueva publicacion con todos sus datos apra ser creada
     */
    @Override
    public void crearPublicacion(PublicacionesDTO nuevo){
        Usuario user = repos.findUserById(nuevo.getUserId());
        Producto detalle = mapper.map(nuevo.getDetail(),Producto.class);
        Publicacion nueva = new Publicacion(nuevo.getIdPost(),nuevo.getDate(),detalle,nuevo.getCategory(),nuevo.getPrice(),user,false,0.0);
        repos.crearPublicacion(nueva);
    }

    /**
     * Crear publicacion en base a los DTO
     * @param nuevo Nueva publicacion con todos sus datos apra ser creada
     */
    @Override
    public void crearPublicacionPromo(PublicacionesDTO nuevo){
        Usuario user = repos.findUserById(nuevo.getUserId());
        Producto detalle = mapper.map(nuevo.getDetail(),Producto.class);
        Publicacion nueva = new Publicacion(nuevo.getIdPost(),nuevo.getDate(),detalle,nuevo.getCategory(),
                                            nuevo.getPrice(),user,nuevo.getHasPromo(),nuevo.getDiscount());
        repos.crearPublicacion(nueva);
    }

    /**
     * Listar publicaciones de los vendedores qe un usuario sigue en las ultimas 2 semanas, ordenado por fecha mas reciente primero
     * @param userId : id de usuario que quiere ver las publicaciones de las personas a las que sigue
     */
    @Override
    public List<PublicacionesDTO> consultarPublicaciones(Integer userId, String order){
        List<PublicacionesDTO> salida = new ArrayList<>();

        Usuario user = repos.findUserById(userId);
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);
        List<Publicacion> consulta = repos.publicacionesParaSeguidor(user,fechaLimite);

        if(order == null || order.equals(EnumOrdenes.date_asc.name()))
            consulta.sort(Comparator.comparing(Publicacion::getDate));
        else if(order.equals(EnumOrdenes.date_desc.name()))
            consulta.sort(Comparator.comparing(Publicacion::getDate).reversed());
        else
            throw new NegocioException("No se reconoce el valor del campo order",105);

        consulta.forEach(x->{
            PublicacionesDTO nueva = mapper.map(x, PublicacionesDTO.class);
            nueva.setUserId(x.getUserdueno().getUserId());
            salida.add(nueva);
        });
        return salida;
    }

    @Override
    public ConteosDTO contarPublicaciones(Integer userId) {
        Usuario user = repos.findUserById(userId);
        return new ConteosDTO(user.getUserId(),user.getUserName(),null,null,repos.obtenerPubsDeVendedor(userId).size());
    }

    @Override
    public ListaPublicacionesDTO obtenerPubsPromocion(Integer userId,String order) {
        Usuario user = repos.findUserById(userId);
        List<Publicacion> pubs = repos.obtenerPubsDeVendedor(userId);
        List<PublicacionesDTO> pubsPromocion = new ArrayList<>();

        for (Publicacion publicacion : pubs) {
            if(publicacion.isHasPromo())
            {
                PublicacionesDTO salida = mapper.map(publicacion,PublicacionesDTO.class);
                salida.setUserId(publicacion.getUserdueno().getUserId());
                pubsPromocion.add(salida);
            }
        }

        if(order == null || order.equals(EnumOrdenes.date_asc.name()))
            pubsPromocion.sort(Comparator.comparing(PublicacionesDTO::getDate));
        else if(order.equals(EnumOrdenes.date_desc.name()))
            pubsPromocion.sort(Comparator.comparing(PublicacionesDTO::getDate).reversed());
        else
            throw new NegocioException("No se reconoce el valor del campo order",105);

        return new ListaPublicacionesDTO(userId,user.getUserName(),pubsPromocion);
    }

    @Override
    public ConteosDTO contarPublicacionesPromo(Integer userId) {
        Usuario user = repos.findUserById(userId);
        int conteoPromos = repos.obtenerPubsDeVendedor(userId).stream().filter(x->x.isHasPromo()).collect(Collectors.toList()).size();
        return new ConteosDTO(user.getUserId(),user.getUserName(),null,conteoPromos,null);
    }

}
