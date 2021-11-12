package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
}
