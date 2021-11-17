package com.socialMeli.socialMeli.model;
import com.socialMeli.socialMeli.dto.PublicacionDTO;
import lombok.Getter;
import java.util.ArrayList;
@Getter
public class Usuario {
    private String user_name;
    private int user_id;
    private ArrayList<Usuario> followers;
    private ArrayList<Usuario> followed;
    private ArrayList<PublicacionDTO> publicaciones;

    public Usuario(int id,String user_name){
        this.user_id = id;
        this.user_name = user_name;
        followed = new ArrayList<>();
        followers = new ArrayList<>();
        publicaciones = new ArrayList<>();
    }

    public int obtenerNumeroDeSeguidores(){
        return followers.size();
    }

    public void seguirA(Usuario usuario){
            agregarSeguido(usuario);
            usuario.agregarSeguidor(this);
    }

    public void agregarSeguido(Usuario usuario){
        followed.add(usuario);
    }

    public void agregarSeguidor(Usuario seguidor){
        followers.add(seguidor);
    }

    public void agregarPublicacion(PublicacionDTO publicacion){
        this.getPublicaciones().add(publicacion);
    }

    public void dejarDeSeguirA(Usuario usuarioDejadoDeSeguir) {
        followed.remove(usuarioDejadoDeSeguir);
        usuarioDejadoDeSeguir.serDejadoDeSeguir(this);
    }

    public void serDejadoDeSeguir(Usuario usuarioQueDejaDeSeguirme){
        followers.remove(usuarioQueDejaDeSeguirme);
    }
}