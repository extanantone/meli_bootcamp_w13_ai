package com.Sprint1.SocialMeli.Repository;

import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    HashMap<Integer, User> baseUsers = new HashMap<>();

    public UserRepositoryImpl() {
        cargarUsuariosDesdeJson();
    }

    private void cargarUsuariosDesdeJson(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:Users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> usuarios = null;
        try {
            usuarios = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (User usuario : usuarios) {
            baseUsers.put(usuario.getUserId(), usuario);
        }

    }

    //TODO: BOrrar
    public HashMap<Integer, User> prueba(){
        return baseUsers;
    }

    @Override
    public User obtenerUsuario(int userId) {
        return baseUsers.get(userId);
    }

    @Override
    public Boolean existeUsuario(int userId) {
        return baseUsers.containsKey(userId);
    }

    @Override
    public Boolean existeFollowed(int userId, int userIdToFollow) {
        User usuarioActual = baseUsers.get(userId);
        List<UserShortDTO> followeds= usuarioActual.getFolloweds();
        for (UserShortDTO followed : followeds) {
            if (followed.getUserId() == userIdToFollow){
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean agregarFollowed(int userId, int user_id_to_follow) {
        User usuarioActual = baseUsers.get(userId);
        List<UserShortDTO> followedsActual= usuarioActual.getFolloweds();
        User usuarioASeguir = baseUsers.get(user_id_to_follow);

        followedsActual.add(new UserShortDTO(usuarioASeguir));

        baseUsers.replace(userId, usuarioActual);

        return true;
    }

}
