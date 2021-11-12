package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.Model.User;

import java.util.HashMap;

public interface IUserService {

    public Boolean existeUsuario(int userId);

    public Boolean existeFollowed(int userId, int userIdToFollow);

    //TODO: Borrar
    public HashMap<Integer, User> prueba();

    public Boolean agregarFollowed (int userId, int user_id_to_follow);

    public User obtenerUsuario (int userId);
}
