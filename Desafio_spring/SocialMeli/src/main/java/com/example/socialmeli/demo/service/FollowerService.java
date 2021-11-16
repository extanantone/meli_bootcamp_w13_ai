package com.example.socialmeli.demo.service;



import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestUserList;
import com.example.socialmeli.demo.dto.controllerToService.DTOUnfollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowerCount;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowersList;
import com.example.socialmeli.demo.model.Usuarios;
import com.example.socialmeli.demo.repository.IFollowerRepository;
import com.example.socialmeli.demo.repository.IUserRepository;
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
IUserRepository usuarioRepository;


    @Override
    public ResponseEntity followUser(DTOFollowUser requestDTO) {

        if(requestDTO.getUserId() == requestDTO.getUserIdToFollow())
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
    public DTOUserFollowerCount getFollowersCountByUserID(DTOUserId request) {

        int userID = request.getUserId();
        String userName;
        List<Usuarios> userFollowers;
        int userFollowersCount = 0;

        DTOUserFollowerCount response = new DTOUserFollowerCount();

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
    public DTOUserFollowersList getFollowersListOfUserID(DTORequestUserList request) {

        int userID = request.getUserId();
        String order = request.getOrder();
        String userName;
        List<Usuarios> userFollowers;
        DTOUserFollowersList response = new DTOUserFollowersList();

        //Vamos a obtener el usuario solicitado
        Usuarios user = usuarioRepository.obtenerUsuarioPorID(userID);

        if(user == null)
            throw new RuntimeException();

        userName = user.getUsername();

        userFollowers = followerRepository.getUsersWhoFollowsToUserId(userID,order);

        for (Usuarios u: userFollowers) {

            DTOUsuario uDTO = new DTOUsuario();
            uDTO.setUser_id(u.getId());
            uDTO.setUser_name(u.getUsername());

            response.addFollowerToList(uDTO);
        }

        response.setUser_id(userID);
        response.setUser_name(userName);


        return response;
    }

    @Override
    public DTOUserFollowersList getFollowedUsersOfUserId(DTORequestUserList request) {

        DTOUserFollowersList response = new DTOUserFollowersList();
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

            DTOUsuario uDTO = new DTOUsuario();
            uDTO.setUser_id(u.getId());
            uDTO.setUser_name(u.getUsername());

            response.addFollowerToList(uDTO);
        }

        response.setUser_id(userId);
        response.setUser_name(userName);

        return response;
    }

    @Override
    public ResponseEntity unFollowUser(DTOUnfollowUser request) {

        try{
            followerRepository.unFollowUser(request);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return null;
    }


}
