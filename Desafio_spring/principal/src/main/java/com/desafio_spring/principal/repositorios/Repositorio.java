package com.desafio_spring.principal.repositorios;

import com.desafio_spring.principal.enumerados.EnumErrs;
import com.desafio_spring.principal.excepciones.NegocioException;
import com.desafio_spring.principal.modelo.Producto;
import com.desafio_spring.principal.modelo.Publicacion;
import com.desafio_spring.principal.modelo.Usuario;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

/**
 * para acceso rapido de usuarios manteniendo un alamcenaje de los id y las refernicas de memoria
 * las posts se guardan alamcenadas por usuario id
 */
@Repository
public class Repositorio implements IRepositorios{

    private final Map<Integer, Usuario> users;
    private final Map<Integer, Publicacion> posts;

    private final Map<Integer, List<Publicacion>> userPosts;

    private final Map<Integer, List<Usuario>> usuarioySeguidores;
    private final Map<Integer, List<Usuario>> usuarioySeguidos;


    public Repositorio(){
        users = new HashMap<>();
        posts = new HashMap<>();
        userPosts = new HashMap<>();
        usuarioySeguidores = new HashMap<>();
        usuarioySeguidos = new HashMap<>();

        /* Definiendo Datos de Pruebas
         * asegurar ids unicos
         */

        users.put(1,new Usuario(1,"Roman"));
        users.put(2,new Usuario(2,"Renan"));
        users.put(3,new Usuario(3,"Rolando"));
        users.put(4,new Usuario(4,"Rebeca"));

        posts.put(1, new Publicacion(1,LocalDate.now(), new Producto(1,"Silla Gamer","Gamer","Racer","Red & Black","Special Edition"),"100",1500.5,users.get(1),false,0.0));
        posts.put(2, new Publicacion(2,LocalDate.now(), new Producto(123,"Silla Gamer2","Gamer2","Racer2","Red & Black2","Special Edition2"),"100",1500.5,users.get(2),false,0.0));
        posts.put(3, new Publicacion(3,LocalDate.now(), new Producto(12,"Silla Gamer3","Gamer3","Racer3","Red & Black3","Special Edition3"),"100",1500.5,users.get(3),false,0.0));
        posts.put(4, new Publicacion(4,LocalDate.now(), new Producto(3,"Silla Gamer4","Gamer4","Racer4","Red & Black4","Special Edition4"),"100",1500.5,users.get(4),false,0.0));
        /*
         * relacionar posts con usuarios
         */
        userPosts.put(users.get(1).getUserId(),new ArrayList<>(List.of(posts.get(1))));
        userPosts.put(users.get(2).getUserId(),new ArrayList<>(List.of(posts.get(2))));
        userPosts.put(users.get(3).getUserId(),new ArrayList<>(List.of(posts.get(3))));
        userPosts.put(users.get(4).getUserId(),new ArrayList<>(List.of(posts.get(4))));

        /*
         * usuarioySeguidores
         *
        usuarioySeguidores.put(  users.get(1).getUserId(),new ArrayList<>(List.of(users.get(3),users.get(2))));
        usuarioySeguidores.put(  users.get(2).getUserId(),new ArrayList<>(List.of(users.get(3),users.get(1))));
        usuarioySeguidores.put(  users.get(3).getUserId(),new ArrayList<>(List.of(users.get(4),users.get(2))));
        usuarioySeguidores.put(  users.get(4).getUserId(),new ArrayList<>());
        * */

        /*
         * seguidos
         *

        usuarioySeguidos.put(users.get(1).getUserId(),new ArrayList<>(List.of(users.get(2))));
        usuarioySeguidos.put(users.get(2).getUserId(),new ArrayList<>(List.of(users.get(3),users.get(1))));
        usuarioySeguidos.put(users.get(3).getUserId(),new ArrayList<>(List.of(users.get(1),users.get(2))));
        usuarioySeguidos.put(users.get(4).getUserId(),new ArrayList<>(List.of(users.get(3))));
        */

    }

    /**
     * la publciacion neuva se asocia a un usuario y se crea en el repositorio de publciacion par acontrolar su id unico
     * @param nuevo : publicacion a crear
     */
    @Override
    public void crearPublicacion(Publicacion nuevo){
        if(!posts.containsKey(nuevo.getIdPost()))
            posts.put(nuevo.getIdPost(),nuevo);
        else
            throw new NegocioException(EnumErrs.DUPLICATED.repMensaje(nuevo.getIdPost()), EnumErrs.DUPLICATED.getCodigo());

        List<Publicacion> publicacionesUser = userPosts.get(nuevo.getUserdueno().getUserId());
        publicacionesUser.add(nuevo);
    }

    /**
     * registrar un seguidor a un vendedor respetando integridad de datos
     * @param aSeguir :Usuario a quien se le registra el seguidor nuevo
     * @param seguidor : Usuario a registrar como seguidor
     */
    @Override
    public void registrarSeguidor(Usuario aSeguir,Usuario seguidor){
        if(!users.containsKey(aSeguir.getUserId()))
            throw new NegocioException(EnumErrs.NOT_FOUND.repMensaje(aSeguir.getUserId()), EnumErrs.NOT_FOUND.getCodigo());
        if(!users.containsKey(seguidor.getUserId()))
            throw new NegocioException(EnumErrs.NOT_FOUND.repMensaje(seguidor.getUserId()), EnumErrs.NOT_FOUND.getCodigo());
        else
        {
            List<Usuario> losQueSigues = usuarioySeguidos.get(seguidor.getUserId());

            if(!losQueSigues.contains(aSeguir))
                losQueSigues.add(aSeguir);
            else
                throw new NegocioException(EnumErrs.ALREADY_FOLLOWED.repMensaje(aSeguir.getUserId()), EnumErrs.ALREADY_FOLLOWED.getCodigo());

            List<Usuario> losQueTeSiguen = usuarioySeguidores.get(aSeguir.getUserId());
            if(!losQueSigues.contains(seguidor))
                losQueTeSiguen.add(seguidor);
        }
    }

    /**
     * elimina el seguidor de un vendedor manteniendo integridad de datos
     * @param aSeguir : Usuario del cual se quita el seguidor
     * @param seguidor : usuario que se quita de los seguidores del seguido
     */
    @Override
    public void quitarSeguidor(Usuario aSeguir,Usuario seguidor){
        if(!users.containsKey(aSeguir.getUserId()))
            throw new NegocioException(EnumErrs.NOT_FOUND.repMensaje(aSeguir.getUserId()), EnumErrs.NOT_FOUND.getCodigo());
        if(!users.containsKey(seguidor.getUserId()))
            throw new NegocioException(EnumErrs.NOT_FOUND.repMensaje(seguidor.getUserId()), EnumErrs.NOT_FOUND.getCodigo());
        else
        {
            List<Usuario> losQueSigues = usuarioySeguidos.get(seguidor.getUserId());
            losQueSigues.remove(aSeguir);

            List<Usuario> losQueTeSiguen = usuarioySeguidores.get(aSeguir.getUserId());
            losQueTeSiguen.remove(seguidor);
        }
    }

    /**
     * Metodo para encontrar objetos Usuario en base a su id Unico
     * @param idUser: id de usuario a encontrar en el repositorio
     * @return :retorna el usuario registrado con el id ingresado
     */
    @Override
    public Usuario findUserById(Integer idUser){
        Usuario salida = users.get(idUser);
        if(salida == null)
            throw new NegocioException(EnumErrs.NOT_FOUND.repMensaje(idUser), EnumErrs.NOT_FOUND.getCodigo());
        else
            return salida;
    }

    /**
     * trae la lista de seguidores de un vendedor
     * @param idUser: id de usuario al cual se quiere consultar sus seguidores
     * @return :retorna lsita de seguidores
     */
    @Override
    public List<Usuario> obtenerSeguidores(Integer idUser){
        List<Usuario> salida = usuarioySeguidores.get(idUser);
        if(salida == null)
            throw new NegocioException(EnumErrs.NOT_FOUND.repMensaje(idUser), EnumErrs.NOT_FOUND.getCodigo());
        else
            return salida;
    }

    /**
     * obteine lista de usuarios a los que alguien sigue
     * @param idUser :id Usuario para obtener gente que sigue
     * @return : retorna lista de usuarios a los que sigue
     */
    @Override
    public List<Usuario> obtenerSeguidos(Integer idUser){
        List<Usuario> salida = usuarioySeguidos.get(idUser);
        if(salida == null)
            throw new NegocioException(EnumErrs.NOT_FOUND.repMensaje(idUser), EnumErrs.NOT_FOUND.getCodigo());
        else
            return salida;
    }


    /**
     * obtiene la lista de publicaciones que ve una persona seguidora, poniendo un limite de fecha mas antigua
     * @param user :Usuario seguidor
     * @param limite :limite de fecha de las publicaciones mas antiguas
     * @return : publicaciones de los usuarios que publican y el seguidor sigue
     */
    @Override
    public List<Publicacion> publicacionesParaSeguidor(Usuario user, LocalDate limite){
        List<Usuario> losQueSigue = usuarioySeguidos.get(user.getUserId());

        List<Publicacion> publicaciones = new ArrayList<>();

        losQueSigue.forEach(x->{
            List<Publicacion> pubs = userPosts.get(x.getUserId());
            for(Publicacion pub:pubs)
            {
                if(pub.getDate().isAfter(limite))
                    publicaciones.add(pub);
            }
        });
        return publicaciones;
    }

    /**
     * directamente obtiene la lista de publicaciones de un usuario
     * @param userId : id del usuario
     * @return lista de publicaciones
     */
    @Override
    public List<Publicacion> obtenerPubsDeVendedor(Integer userId){
        return userPosts.get(userId);
    }

}
