package com.example.socialmeli.demo.repository;



import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTOUnfollowUser;
import com.example.socialmeli.demo.model.Usuarios;

import java.util.List;

public interface IFollowerRepository {


    public void addUserToRepository(int userID);

    public void FollowUser(DTOFollowUser request);


    public void unFollowUser(DTOUnfollowUser request);

    public List<Usuarios> getUsersWhoFollowsToUserId(int vendedorUserId, String order);

    public List<Usuarios> getUsersFollowedByUserId(int userId, String order);


}
