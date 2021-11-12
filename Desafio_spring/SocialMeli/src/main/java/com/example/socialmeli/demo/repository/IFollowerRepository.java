package com.example.socialmeli.demo.repository;



import com.example.socialmeli.demo.dto.controllerToService.FollowUserDTO;
import com.example.socialmeli.demo.model.Usuarios;

import java.util.List;

public interface IFollowerRepository {


    public void addUserToRepository(int userID);

    public void FollowUser(FollowUserDTO request);


    public void unFollowUser(int userId, int userToUnfollowId);

    public List<Usuarios> getUsersWhoFollowsToUserId(int vendedorUserId);

}
