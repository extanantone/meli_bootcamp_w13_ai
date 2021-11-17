package com.Sprint1.SocialMeli.Repository;

import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Model.User;

import java.util.HashMap;
import java.util.List;

public interface IUserRepository {

    public Boolean existeUsuario(int userId);

    public Boolean existeFollowed(int userId, int userIdToFollow);

    public Boolean agregarFollowed (int userId, int user_id_to_follow);

    public Boolean quitarFollowed (int userId, int user_id_to_unfollow);

    public User obtenerUsuario (int userId);

    public int obtenerCantSeguidores (int userId);

    public List<UserShortDTO> obtenerListaSeguidores (int userId);

    public List<UserShortDTO> obtenerListaSeguidos (int userId);
}
