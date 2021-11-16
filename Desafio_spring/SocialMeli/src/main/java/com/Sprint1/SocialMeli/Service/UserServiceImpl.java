package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.UserFollowedsListDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersCountDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersListDTO;
import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean existeUsuario(int userId) {
        return userRepository.existeUsuario(userId);
    }

    @Override
    public Boolean existeFollowed(int userId, int userIdToFollow) {
        return userRepository.existeFollowed(userId, userIdToFollow);
    }

    //TODO: BORRAR
    public HashMap<Integer, User> prueba(){
        return userRepository.prueba();
    }

    @Override
    public Boolean agregarFollowed(int userId, int user_id_to_follow) {
        userRepository.agregarFollowed(userId, user_id_to_follow);
        return true;
    }

    @Override
    public User obtenerUsuario(int userId) {
        return userRepository.obtenerUsuario(userId);
    }

    @Override
    public UserFollowersCountDTO obtenerUserFollowersCount (int userId) {
        User usuario = obtenerUsuario(userId);
        int cantSeguidores = userRepository.obtenerCantSeguidores(userId);

        UserFollowersCountDTO userFolCount = new UserFollowersCountDTO(usuario);

        userFolCount.setFollowersCount(cantSeguidores);

        return userFolCount;
    }

    @Override
    public UserFollowersListDTO obtenerUserFollowersList(int userId) {
        User usuario = obtenerUsuario(userId);
        List<UserShortDTO> listaSeguidores = userRepository.obtenerListaSeguidores(userId);

        UserFollowersListDTO userFolList = new UserFollowersListDTO(usuario);

        userFolList.setFollowers(listaSeguidores);

        return userFolList;
    }

    @Override
    public UserFollowedsListDTO obtenerUserFollowedsList(int userId) {
        User usuario = obtenerUsuario(userId);
        List<UserShortDTO> listaSeguidos = userRepository.obtenerListaSeguidos(userId);

        UserFollowedsListDTO userFollowedList = new UserFollowedsListDTO(usuario);

        userFollowedList.setFolloweds(listaSeguidos);

        return userFollowedList;
    }
}
