package com.desafio_spring.principal.repositorios;

import com.desafio_spring.principal.excepciones.NegocioException;
import com.desafio_spring.principal.modelo.Producto;
import com.desafio_spring.principal.modelo.Publicacion;
import com.desafio_spring.principal.modelo.Usuario;
import java.time.LocalDate;
import java.util.*;

/**
 * para acceso rapido de usuarios manteniendo un alamcenaje de los id y las refernicas de memoria
 * las posts se guardan alamcenadas por usuario id
 */
public class RepositorioUsuarios {


    private Map<Integer, Usuario> users = new HashMap<>();
    private Map<Integer, Publicacion> posts = new HashMap<>();
    private Map<Integer, List<Publicacion>> userPosts = new HashMap<>();
    private Map<Integer, List<Usuario>> usuarioySeguidores = new HashMap<>();
    private Map<Integer, List<Usuario>> usuarioySeguidos = new HashMap<>();


    public RepositorioUsuarios(){

        /* Definiendo Datos de Pruebas
         * asegurar ids unicos
         */
        users = Map.of(
                1,new Usuario(1,"Roman"),
                2,new Usuario(2,"Renan"),
                3,new Usuario(3,"Rolando"),
                4,new Usuario(4,"Rebeca")
        );

        posts = Map.of(
                1, new Publicacion(1,LocalDate.now(), new Producto(1,"Silla Gamer","Gamer","Racer","Red & Black","Special Edition"),"100",1500.5,users.get(1)),
                2,new Publicacion(2,LocalDate.now(), new Producto(1,"Silla Gamer","Gamer","Racer","Red & Black","Special Edition"),"100",1500.5,users.get(2)),
                3, new Publicacion(3,LocalDate.now(), new Producto(1,"Silla Gamer","Gamer","Racer","Red & Black","Special Edition"),"100",1500.5,users.get(3)),
                3,new Publicacion(4,LocalDate.now(), new Producto(1,"Silla Gamer","Gamer","Racer","Red & Black","Special Edition"),"100",1500.5,users.get(4))
        );

        /*
         * relacionar posts con usuarios
         */
        userPosts = Map.of(
                users.get(1).getUserId(),List.of(posts.get(1)),
                users.get(2).getUserId(),List.of(posts.get(2)),
                users.get(3).getUserId(),List.of(posts.get(3)),
                users.get(4).getUserId(),List.of(posts.get(4))
                );

        /*
         * usuarioySeguidores
         */
        usuarioySeguidores = Map.of(
                users.get(1).getUserId(),List.of(users.get(3),users.get(2)),
                users.get(2).getUserId(),List.of(users.get(3),users.get(1)),
                users.get(3).getUserId(),List.of(users.get(4),users.get(2))
        );

        /*
         * seguidos
         */
        usuarioySeguidos = Map.of(
                users.get(1).getUserId(),List.of(users.get(2)),
                users.get(2).getUserId(),List.of(users.get(3),users.get(1)),
                users.get(3).getUserId(),List.of(users.get(1),users.get(2)),
                users.get(4).getUserId(),List.of(users.get(3))
        );
    }

    /**
     * la publciacion neuva se asocia a un usuario y se crea en el repositorio de publciacion par acontrolar su id unico
     * @param nuevo
     */
    public void crearPublicacion(Publicacion nuevo){
        if(!posts.containsKey(nuevo.getIdPost()))
            posts.put(nuevo.getIdPost(),nuevo);
        else
            throw new NegocioException("El id de post ya existe elija otro",100);

        List<Publicacion> publicacionesUser = userPosts.get(nuevo.getUserdueno().getUserId());
        publicacionesUser.add(nuevo);
    }

    /**
     * registrar un seguidor a un vendedor respetando integridad de datos
     * @param aSeguir
     * @param seguidor
     */
    public void registrarSeguidor(Usuario aSeguir,Usuario seguidor){
        if(!users.containsKey(aSeguir.getUserId()))
            throw new NegocioException("El id del seguidor no existe en el repositorio, registrelo por favor",101);
        if(!users.containsKey(seguidor.getUserId()))
            throw new NegocioException("El id del usuario a seguir no existe en el repositorio, registrelo por favor",102);
        else
        {
            List<Usuario> losQueSigues = usuarioySeguidos.get(seguidor.getUserId());
            losQueSigues.add(aSeguir);

            List<Usuario> losQueTeSiguen = usuarioySeguidores.get(aSeguir.getUserId());
            losQueTeSiguen.add(seguidor);
        }
    }

    /**
     * elimina el seguidor de un vendedor manteniendo integridad de datos
     * @param aSeguir
     * @param seguidor
     */
    public void quitarSeguidor(Usuario aSeguir,Usuario seguidor){
        if(!users.containsKey(aSeguir.getUserId()))
            throw new NegocioException("El id del seguidor no existe en el repositorio, registrelo por favor",101);
        if(!users.containsKey(seguidor.getUserId()))
            throw new NegocioException("El id del usuario a seguir no existe en el repositorio, registrelo por favor",102);
        else
        {
            List<Usuario> losQueSigues = usuarioySeguidos.get(seguidor.getUserId());
            losQueSigues.remove(aSeguir);

            List<Usuario> losQueTeSiguen = usuarioySeguidores.get(aSeguir.getUserId());
            losQueTeSiguen.remove(seguidor);
        }
    }

    /**
     * MEtodo par aenocntrar objetos Usuario en base a su id Unico
     * @param idUser
     * @return
     */
    public Usuario findUserById(Integer idUser){
        Usuario salida = users.get(idUser);
        if(salida == null)
            throw new NegocioException("El id ingresado no existe en la API por favor creelo",103);
        else
            return salida;
    }

    /**
     * trae la lsita de seguidores de un vendedor
     * @param idUser
     * @return
     */
    public List<Usuario> obtenerSeguidores(Integer idUser){
        List<Usuario> salida = usuarioySeguidores.get(idUser);
        if(salida == null)
            throw new NegocioException("El id ingresado no existe en la API por favor creelo",103);
        else
            return salida;
    }

    /**
     * obteine lista de usuarios a los que alguien sigue
     * @param idUser
     * @return
     */
    public List<Usuario> obtenerSeguidos(Integer idUser){
        List<Usuario> salida = usuarioySeguidos.get(idUser);
        if(salida == null)
            throw new NegocioException("El id ingresado no existe en la API por favor creelo",103);
        else
            return salida;
    }


    /**
     * obtiene la lista de publicaciones que ve una persona seguidora, poniendo un limite de fecha mas antigua
     * @param user
     * @param limite
     * @return
     */
    public List<Publicacion> publicaciones(Usuario user, LocalDate limite){
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

}
