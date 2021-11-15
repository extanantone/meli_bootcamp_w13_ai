package com.example.socialmeli.demo.service;



import com.example.socialmeli.demo.dto.UsuarioDTO;
import com.example.socialmeli.demo.dto.controllerToService.FollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.RequestUserListDTO;
import com.example.socialmeli.demo.dto.controllerToService.UnfollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowerCountDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowersListDTO;
import com.example.socialmeli.demo.model.Usuarios;
import com.example.socialmeli.demo.repository.IFollowerRepository;
import com.example.socialmeli.demo.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FollowerService implements IFollowerService{

@Autowired
IFollowerRepository followerRepository;

@Autowired
IUsuarioRepository usuarioRepository;


    @Override
    public ResponseEntity followUser(FollowUserDTO requestDTO) {

        if(requestDTO.getUser_id() == requestDTO.getUser_id_to_follow())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        try {
            followerRepository.FollowUser(requestDTO);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public UserFollowerCountDTO getFollowersCountByUserID(UserIdDTO request) {

        int userID = request.getUser_id();
        String userName;
        List<Usuarios> userFollowers;
        int userFollowersCount = 0;

        UserFollowerCountDTO response = new UserFollowerCountDTO();

        //Vamos a obtener el usuario solicitado
        Usuarios user = usuarioRepository.obtenerUsuarioPorID(userID);

        if(user == null)
            throw new RuntimeException();

        userName = user.getUsername();

        userFollowers = followerRepository.getUsersWhoFollowsToUserId(userID,null);

        if(userFollowers!= null){
            userFollowersCount = userFollowers.size();
        }
        else
            userFollowersCount = 0;

        response.setUser_id(userID);
        response.setUser_name(userName);
        response.setFollowers_count(userFollowersCount);

        return response;

    }

    @Override
    public UserFollowersListDTO getFollowersListByUserID(RequestUserListDTO request) {

        int userID = request.getUserId();
        String order = request.getOrder();
        String userName;
        List<Usuarios> userFollowers;
        UserFollowersListDTO response = new UserFollowersListDTO();

        //Vamos a obtener el usuario solicitado
        Usuarios user = usuarioRepository.obtenerUsuarioPorID(userID);

        if(user == null)
            throw new RuntimeException();

        userName = user.getUsername();

        userFollowers = followerRepository.getUsersWhoFollowsToUserId(userID,order);

        for (Usuarios u: userFollowers) {

            UsuarioDTO uDTO = new UsuarioDTO();
            uDTO.setUser_id(u.getId());
            uDTO.setUser_name(u.getUsername());

            response.addFollowerToList(uDTO);
        }

        response.setUser_id(userID);
        response.setUser_name(userName);


        return response;
    }

    @Override
    public UserFollowersListDTO getFollowedUsersFromUserId(RequestUserListDTO request) {

        UserFollowersListDTO response = new UserFollowersListDTO();
        List<Usuarios> followedUsers = new ArrayList<>();
        int userId = request.getUserId();
        String order = request.getOrder();
        String userName;

        followedUsers = followerRepository.getUsersFollowedByUserId(userId,order);

        //Vamos a obtener el usuario solicitado
        Usuarios searchedUser = usuarioRepository.obtenerUsuarioPorID(userId);

        if(searchedUser == null)
            throw new RuntimeException();

        userName = searchedUser.getUsername();

        for (Usuarios u: followedUsers) {

            UsuarioDTO uDTO = new UsuarioDTO();
            uDTO.setUser_id(u.getId());
            uDTO.setUser_name(u.getUsername());

            response.addFollowerToList(uDTO);
        }

        response.setUser_id(userId);
        response.setUser_name(userName);

        return response;
    }

    @Override
    public ResponseEntity unFollowUser(UnfollowUserDTO request) {

        try{
            followerRepository.unFollowUser(request);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return null;
    }


}
