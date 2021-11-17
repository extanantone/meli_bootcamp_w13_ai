package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.UserFollowedsListDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersCountDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersListDTO;
import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        return userRepository.agregarFollowed(userId, user_id_to_follow);
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
    public UserFollowersListDTO obtenerUserFollowersList(int userId, String order) {
        User usuario = obtenerUsuario(userId);
        List<UserShortDTO> listaSeguidores = userRepository.obtenerListaSeguidores(userId);

        if (order != null && !order.isEmpty()){
            if (order.equals("name_asc")) {
                listaSeguidores = listaSeguidores.stream()
                        .sorted(Comparator.comparing(UserShortDTO::getUserName))
                        .collect(Collectors.toList());
            }
            else if (order.equals("name_desc")) {
                listaSeguidores = listaSeguidores.stream()
                        .sorted(Comparator.comparing(UserShortDTO::getUserName).reversed())
                        .collect(Collectors.toList());
            }
        }

        UserFollowersListDTO userFolList = new UserFollowersListDTO(usuario);

        userFolList.setFollowers(listaSeguidores);

        return userFolList;
    }

    @Override
    public UserFollowedsListDTO obtenerUserFollowedsList(int userId, String order) {
        User usuario = obtenerUsuario(userId);
        List<UserShortDTO> listaSeguidos = userRepository.obtenerListaSeguidos(userId);

        if (order != null && !order.isEmpty()){
            if (order.equals("name_asc")) {
                listaSeguidos = listaSeguidos.stream()
                        .sorted(Comparator.comparing(UserShortDTO::getUserName))
                        .collect(Collectors.toList());
            }
            else if (order.equals("name_desc")) {
                listaSeguidos = listaSeguidos.stream()
                        .sorted(Comparator.comparing(UserShortDTO::getUserName).reversed())
                        .collect(Collectors.toList());
            }
        }

        UserFollowedsListDTO userFollowedList = new UserFollowedsListDTO(usuario);

        userFollowedList.setFolloweds(listaSeguidos);

        return userFollowedList;
    }

    @Override
    public Boolean quitarFollowed(int userId, int user_id_to_unfollow) {
        return userRepository.quitarFollowed(userId, user_id_to_unfollow);
    }
}
