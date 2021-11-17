package com.desafio_spring.principal.servicios;

import com.desafio_spring.principal.dto.ConteosDTO;
import com.desafio_spring.principal.dto.ListaUsuariosDTO;
import com.desafio_spring.principal.dto.UsuarioDTO;
import com.desafio_spring.principal.enumerados.EnumErrs;
import com.desafio_spring.principal.enumerados.EnumOrdenes;
import com.desafio_spring.principal.excepciones.NegocioException;
import com.desafio_spring.principal.modelo.Usuario;
import com.desafio_spring.principal.repositorios.IRepositorios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ServicioUsuarios {

    @Autowired
    private IRepositorios repos;

    @Autowired
    private ModelMapper mapper;


    /**
     * agregar un seguidos a las colecciones
     * @param seguidor : id del seguidor
     * @param seguido : id del seguido
     */
    public void registrarSeguir(Integer seguidor, Integer seguido){
        Usuario seguidorLocal = repos.findUserById(seguidor);
        Usuario seguidoLocal = repos.findUserById(seguido);
        repos.registrarSeguidor(seguidoLocal,seguidorLocal);
    }

    /**
     * eliminar un seguidor de las colecciones
     * @param seguidor : id del seguidor
     * @param seguido : id del seguido
     */
    public void dejarDeSeguir(Integer seguidor, Integer seguido){
        Usuario seguidorLocal = repos.findUserById(seguidor);
        Usuario seguidoLocal = repos.findUserById(seguido);
        repos.quitarSeguidor(seguidoLocal,seguidorLocal);
    }

    /**
     * Obtiene el tamano de los seguidores
     * @param seguido :id de usuario a quien siguen
     * @return :retorna DTO para entregar conteo de seguidores
     */
    public ConteosDTO conteoSeguidores(Integer seguido){
        Usuario seguidoLocal = repos.findUserById(seguido);
        return new ConteosDTO(seguidoLocal.getUserId(), seguidoLocal.getUserName(), repos.obtenerSeguidores(seguido).size(),null,null);
    }

    /**
     * Obtiene la lista de seguidores
     * @param seguido :id de usuario a quien siguen
     * @param orden : parametro para identificar el tipo de ordenamiento de la lista de salida
     * @return lista de seguidores del seguido
     */
    public ListaUsuariosDTO listaSeguidores(Integer seguido, String orden){
        Usuario seguidoLocal = repos.findUserById(seguido);
        ListaUsuariosDTO salida = new ListaUsuariosDTO(seguidoLocal.getUserId(), seguidoLocal.getUserName(), new ArrayList<>(),null);
        List<Usuario> seguidores = repos.obtenerSeguidores(seguidoLocal.getUserId());

        if(orden == null || orden.equals(EnumOrdenes.name_asc.name()))
            seguidores.sort(Comparator.comparing(Usuario::getUserName));
        else if(orden.equals(EnumOrdenes.name_desc.name()))
            seguidores.sort(Comparator.comparing(Usuario::getUserName).reversed());
        else
            throw new NegocioException(EnumErrs.PARAMETER_NOT_FOUND.repMensaje(orden),EnumErrs.PARAMETER_NOT_FOUND.getCodigo());

        seguidores.forEach(x->salida.getFollowers().add(new UsuarioDTO(x.getUserId(),x.getUserName())));
        return salida;
    }

    /**
     * Obtiene la lista de usuarios a los que sigue
     * @param seguidor :id de usuario de quien sigue a otros
     * @return lista de usuarios que sigue un usuario seguidor
     */
    public ListaUsuariosDTO listaSeguidos(Integer seguidor, String orden){
        Usuario seguidorLocal = repos.findUserById(seguidor);
        ListaUsuariosDTO salida = new ListaUsuariosDTO(seguidorLocal.getUserId(), seguidorLocal.getUserName(),null, new ArrayList<>());
        List<Usuario> seguidores = repos.obtenerSeguidos(seguidorLocal.getUserId());

        if(orden == null || orden.equals(EnumOrdenes.name_asc.name()))
            seguidores.sort(Comparator.comparing(Usuario::getUserName));
        else if(orden.equals(EnumOrdenes.name_desc.name()))
            seguidores.sort(Comparator.comparing(Usuario::getUserName).reversed());
        else
            throw new NegocioException(EnumErrs.PARAMETER_NOT_FOUND.repMensaje(orden),EnumErrs.PARAMETER_NOT_FOUND.getCodigo());

        seguidores.forEach(x->salida.getFollowed().add(mapper.map(x,UsuarioDTO.class)));
        return salida;
    }

}
