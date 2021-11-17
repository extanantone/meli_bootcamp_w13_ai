package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.exception.BadParamsRequestException;
import com.example.socialmeli.exception.FollowException;
import com.example.socialmeli.exception.UserNotExistException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService() {

    }

    public PostRequestResponseDto followUser(Integer user_id, Integer user_id_to_follow){
        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(Objects.isNull(user_id_to_follow)){
            throw new BadParamsRequestException("El id del usuario a seguir no es valido");
        }
        if(user_id == user_id_to_follow){
            throw new BadParamsRequestException("Los ids de usuario no pueden ser iguales");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }
        if(!userRepository.userExist(user_id_to_follow)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id_to_follow));
        }

        User user = userRepository.getUser(user_id);
        User userToFollow = userRepository.getUser(user_id_to_follow);

        boolean ussAlreadyFollow = user.checkUserFollowed(user_id_to_follow);
        boolean ussAlreadyFollowed = userToFollow.checkUserFollower(user_id);

        if (ussAlreadyFollow && ussAlreadyFollowed){
            throw new FollowException(String.format("El usuario %s ya sigue al usuario %s", user.getUserName(), userToFollow.getUserName()));
        }

        if(!ussAlreadyFollow){
            user.setUserFollowed(user_id_to_follow);
        }
        if(!ussAlreadyFollowed){
            userToFollow.setUserFollower(user_id);
        }

        return new PostRequestResponseDto(String.format("El usuario %s sigue correctamente a %s",user.getUserName(),userToFollow.getUserName()));
    }

    public UserResponseDto getFollowersCount(Integer user_id){
        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }
        User user = userRepository.getUser(user_id);
        Integer count = user.getFollowersCount();
        return new UserResponseDto(user_id,user.getUserName(),count,null,null,null);
    }

    public UserResponseDto getFollowersList(Integer user_id,String order){
        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }
        User user = userRepository.getUser(user_id);
        List<Integer> followsList = user.getFollowersList();
        List<User> userList = new ArrayList<>();
        for(Integer user_follow_id : followsList){
            userList.add(userRepository.getUser(user_follow_id));
        }
        if(order != null){
            if(order.equalsIgnoreCase("name_asc")){
                userList.sort(Comparator.comparing(User::getUserName));
            }
            if(order.equalsIgnoreCase("name_desc")){
                userList.sort(Comparator.comparing(User::getUserName).reversed());
            }
        }
        return new UserResponseDto(user_id,user.getUserName(),null,null,userList,null);

    }

    public UserResponseDto getFollowedList(Integer user_id, String order){
        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }

        User user = userRepository.getUser(user_id);
        List<Integer> followedList = user.getFollowedList();
        List<User> userList = new ArrayList<>();
        //TODO cambiar fors por maps y filters
        for(Integer user_follow_id : followedList){
            userList.add(userRepository.getUser(user_follow_id));
        }
        if(order != null){
            if(order.equalsIgnoreCase("name_asc")){
                userList.sort(Comparator.comparing(User::getUserName));
            }
            if(order.equalsIgnoreCase("name_desc")){
                userList.sort(Comparator.comparing(User::getUserName).reversed());
            }
        }
        return new UserResponseDto(user_id,user.getUserName(),null,null,null,userList);
    }

    public UsersResponseDto getUsers(){
        return new UsersResponseDto(userRepository.getUsers());
    }

    public PostRequestResponseDto unfollow(Integer user_id, Integer user_id_to_unfollow){

        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(Objects.isNull(user_id_to_unfollow)){
            throw new BadParamsRequestException("El id del usuario a seguir no es valido");
        }
        if(user_id == user_id_to_unfollow){
            throw new BadParamsRequestException("Los ids de usuario no pueden ser iguales");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }
        if(!userRepository.userExist(user_id_to_unfollow)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id_to_unfollow));
        }

        User user = userRepository.getUser(user_id);
        User userToUnFollow = userRepository.getUser(user_id_to_unfollow);

        boolean ussAlreadyFollow = user.checkUserFollowed(user_id_to_unfollow);
        boolean ussAlreadyFollowed = userToUnFollow.checkUserFollower(user_id);
        if (!ussAlreadyFollow && !ussAlreadyFollowed){
            throw new FollowException(String.format("El usuario %s no sigue al usuario %s", user.getUserName(), userToUnFollow.getUserName()));
        }

        if(ussAlreadyFollow){
            user.unFollow(user_id_to_unfollow);
        }
        if(ussAlreadyFollowed){
            userToUnFollow.unFollowed(user_id);
        }
        return new PostRequestResponseDto(String.format("El usuario %s dejo de seguir correctamente a %s",user.getUserName(),userToUnFollow.getUserName()));
    }
}
