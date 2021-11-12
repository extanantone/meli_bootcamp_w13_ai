package com.bootcamp.SocialMeli.Repository;

import com.bootcamp.SocialMeli.Model.Publicacion;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements  IUsuarioRepository{

    List<Seguidor> seguidores= new ArrayList<>();
    List<Usuario> usuario= new ArrayList<>();
    List<Publicacion> publicacion= new ArrayList<>();

    public UserRepository(){
        usuario.add(new Usuario("Usuario1"));
        usuario.add(new Usuario("Usuario2"));
        usuario.add(new Usuario("Usuario3"));
        usuario.add(new Usuario("Usuario4"));
    }


    @Override
    public Seguidor setSeguidor(Seguidor seguidor) {
        seguidores.add(seguidor);
        return seguidor;
    }


    @Override
    public Usuario getUsuario(int userId) {
        if(usuario.stream().filter(user -> user.getUserId() == userId).count() >0){
            return usuario.stream().filter(user -> user.getUserId() == userId).findFirst().get();
        }
        return null;
    }


    @Override
    public List<Seguidor> getSeguidor() {
        return seguidores;
    }


    @Override
    public Boolean getSeguidorById(int use, int useFollow) {
        if((seguidores.stream().filter(seguidor -> seguidor.getIdUser() == use ).count() >0) &&
                (seguidores.stream().filter(seguidor -> seguidor.getIdUserFollow() == useFollow ).count() >0)){
            return true;
        }
        return false;
    }


}
