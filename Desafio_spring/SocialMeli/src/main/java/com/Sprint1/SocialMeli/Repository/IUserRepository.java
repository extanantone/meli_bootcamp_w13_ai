package com.Sprint1.SocialMeli.Repository;

import com.Sprint1.SocialMeli.Model.User;

import java.util.HashMap;

public interface IUserRepository {

    public Boolean existeUsuario(int userId);

    public Boolean existeFollowed(int userId, int userIdToFollow);

    public Boolean agregarFollowed (int userId, int user_id_to_follow);

    //TODO: BORRAR
    public HashMap<Integer, User> prueba();

    public User obtenerUsuario (int userId);
}
