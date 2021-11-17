package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.UserFollowedsListDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersCountDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersListDTO;
import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Exceptions.BadRequestExcepcion;
import com.Sprint1.SocialMeli.Exceptions.UserNotFoundException;
import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Boolean agregarFollowed(int userId, int userIdToFollow) {

        this.validaExisteUsuario(userId);
        this.validaExisteUsuario(userIdToFollow);
        this.validaEsVendedor(userIdToFollow);
        this.validaEsMismoUsuario(userId, userIdToFollow);
        this.validaEsSeguidor(userId, userIdToFollow);

        return userRepository.agregarFollowed(userId, userIdToFollow);
    }

    @Override
    public User obtenerUsuario(int userId) {
        return userRepository.obtenerUsuario(userId);
    }

    @Override
    public UserFollowersCountDTO obtenerUserFollowersCount (int userId) {
        this.validaExisteUsuario(userId);
        this.validaEsVendedor(userId);

        User usuario = obtenerUsuario(userId);
        int cantSeguidores = userRepository.obtenerCantSeguidores(userId);

        UserFollowersCountDTO userFolCount = new UserFollowersCountDTO(usuario);

        userFolCount.setFollowersCount(cantSeguidores);

        return userFolCount;
    }

    @Override
    public UserFollowersListDTO obtenerUserFollowersList(int userId, String order) {
        this.validaExisteUsuario(userId);
        this.validaEsVendedor(userId);

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
        this.validaExisteUsuario(userId);

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
    public Boolean quitarFollowed(int userId, int userIdToUnfollow) {

        this.validaExisteUsuario(userId);
        this.validaExisteUsuario(userIdToUnfollow);
        this.validaEsMismoUsuario(userId, userIdToUnfollow);
        this.validaNoEsSeguidor(userId, userIdToUnfollow);

        return userRepository.quitarFollowed(userId, userIdToUnfollow);
    }


    //VALIDACIONES:

    private void validaExisteUsuario(int userId){
        if (!userRepository.existeUsuario(userId)){
            throw new UserNotFoundException("No se encontró el usuario con ID: " + userId);
        }
    }

    private void validaEsSeguidor(int userId, int userIdToFollow){
        if (userRepository.existeFollowed(userId, userIdToFollow)){
            throw new BadRequestExcepcion("El usuario " + userId + " ya sigue al usuario " + userIdToFollow);
        }
    }

    private void validaEsMismoUsuario(int userId, int userIdToFollow){
        if (userId == userIdToFollow){
            throw new BadRequestExcepcion("Un usuario no puede seguirse a si mismo");
        }
    }

    private void validaEsVendedor(int userIdToFollow){
        if (!userRepository.obtenerUsuario(userIdToFollow).getIsSeller()){
            throw new BadRequestExcepcion("El usuario " + userIdToFollow + " no es un usuario vendedor");
        }
    }

    private void validaNoEsSeguidor(int userId, int userIdToUnfollow){
        if (!userRepository.existeFollowed(userId, userIdToUnfollow)){
            throw new BadRequestExcepcion("El usuario " + userId + " no sigue actualmente al usuario " + userIdToUnfollow);
        }
    }

}
