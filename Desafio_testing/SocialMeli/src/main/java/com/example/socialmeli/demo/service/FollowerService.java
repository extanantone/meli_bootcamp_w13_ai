package com.example.socialmeli.demo.service;



import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestUserList;
import com.example.socialmeli.demo.dto.controllerToService.DTOUnfollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowedList;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowerCount;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowersList;
import com.example.socialmeli.demo.exception.FollowingItselfException;
import com.example.socialmeli.demo.exception.UserNotFollowingToUserException;
import com.example.socialmeli.demo.exception.UserNotFoundException;
import com.example.socialmeli.demo.exception.VendorNotFoundException;
import com.example.socialmeli.demo.mapper.UsuarioMapper;
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
IUserService usuarioService;


    @Override
    public ResponseEntity followUser(DTOFollowUser requestDTO) {

        DTOUsuario followerUser = new DTOUsuario();
        DTOUsuario followedUser = new DTOUsuario();

        followerUser = usuarioService.getUserByUserId(requestDTO.getUserId());
        followedUser = usuarioService.getUserByUserId(requestDTO.getUserIdToFollow());

        if(followerUser == null)
            throw new UserNotFoundException();

        if(followedUser == null)
            throw new VendorNotFoundException();


        if(requestDTO.getUserId() == requestDTO.getUserIdToFollow())
            throw new FollowingItselfException();

        followerRepository.FollowUser(requestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public DTOUserFollowerCount getFollowersCountByUserID(DTOUserId request) {

        int userID = request.getUserId();
        int userFollowersCount = 0;
        String userName;
        List<Usuarios> userFollowers;

        DTOUserFollowerCount response = new DTOUserFollowerCount();
        DTOUsuario user = new DTOUsuario();

        //Vamos a obtener el usuario solicitado
        user = usuarioService.getUserByUserId(userID);

        if(user == null)
            throw new UserNotFoundException();

        userName = user.getUserName();

        userFollowers = followerRepository.getUsersWhoFollowsToUserId(userID,null);

        if(userFollowers!= null){
            userFollowersCount = userFollowers.size();
        }
        else
            userFollowersCount = 0;


        //Se arma el response
        response.setUserId(userID);
        response.setUserName(userName);
        response.setFollowersCount(userFollowersCount);

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
        DTOUsuario user = usuarioService.getUserByUserId(userID);

        if(user == null)
            throw new UserNotFoundException();

        userName = user.getUserName();

        userFollowers = followerRepository.getUsersWhoFollowsToUserId(userID,order);

        for (Usuarios u: userFollowers) {

            DTOUsuario uDTO = new DTOUsuario();
            uDTO = UsuarioMapper.UsuarioTODtoUsuario(u);
            response.addFollowerToList(uDTO);
        }

        response.setUserId(userID);
        response.setUserName(userName);

        return response;
    }

    @Override
    public DTOUserFollowedList getFollowedUsersOfUserId(DTORequestUserList request) {

        DTOUserFollowedList response = new DTOUserFollowedList();
        List<Usuarios> followedUsers = new ArrayList<>();
        int userId = request.getUserId();
        String order = request.getOrder();
        String userName;

        //Vamos a obtener el usuario solicitado
        DTOUsuario searchedUser = usuarioService.getUserByUserId(userId);

        if(searchedUser == null)
            throw new UserNotFoundException();

        userName = searchedUser.getUserName();

        followedUsers = followerRepository.getUsersFollowedByUserId(userId,order);

        for (Usuarios u: followedUsers) {

            DTOUsuario uDTO = new DTOUsuario();
            uDTO = UsuarioMapper.UsuarioTODtoUsuario(u);
            response.addFollowerToList(uDTO);
        }

        response.setUserId(userId);
        response.setUserName(userName);

        return response;
    }

    @Override
    public ResponseEntity unFollowUser(DTOUnfollowUser request) {

        DTOUsuario mainUser = usuarioService.getUserByUserId(request.getUserId());
        DTOUsuario userToUnfollow = usuarioService.getUserByUserId(request.getUserIdToUnfollow());

        if(mainUser == null)
            throw new UserNotFoundException();

        if(userToUnfollow == null)
            throw new VendorNotFoundException();

        try{
            followerRepository.unFollowUser(request);
        } catch (Exception e) {
            throw new UserNotFollowingToUserException();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }




}
