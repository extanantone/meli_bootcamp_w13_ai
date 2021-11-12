package com.bootcamp.SocialMeli.repository.usuario;

import com.bootcamp.SocialMeli.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

    List<Usuario> listaUsuarios;

    public UsuarioRepository() {
        this.listaUsuarios = abrirUsuariosJSON();
    }

    public List<Usuario> abrirUsuariosJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:usuarios.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Usuario>> typeRef = new TypeReference<>() {
        };
        List<Usuario> listaUsuarios = null;
        try {
            listaUsuarios = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    @Override
    public void insertarFollower(Integer userId, Integer userIdToFollow) { //inserta seguidor a un seguido
        Usuario usuarioFollower = this.listaUsuarios
                .stream()
                .filter(usuario -> usuario.getUserId() == userId)
                .findFirst()
                .orElse(null);
        this.listaUsuarios
                .stream()
                .filter(usuario -> usuario.getUserId() == userIdToFollow)
                .findFirst()
                .orElse(null)
                .getFollowers()
                .add(usuarioFollower);
        this.listaUsuarios
                .stream()
                .filter(usuario -> usuario.getUserId() == userIdToFollow)
                .findFirst()
                .orElse(null)
                .setFollowersCount(+1);
    }

    @Override
    public void insertarFollowed(Integer userId, Integer userIdToFollow) { //inserta un seguido a un seguidor
        Usuario usuarioFollowed = this.listaUsuarios
                .stream()
                .filter(usuario -> usuario.getUserId() == userIdToFollow)
                .findFirst()
                .orElse(null);
        this.listaUsuarios
                .stream()
                .filter(usuario -> usuario.getUserId() == userId)
                .findFirst()
                .orElse(null)
                .getFollowed()
                .add(usuarioFollowed);
    }

    @Override
    public Usuario devolverUsuario(Integer userId) {
        return this.listaUsuarios
                .stream()
                .filter(usuario -> usuario.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }
}
