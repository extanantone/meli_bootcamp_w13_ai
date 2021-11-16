package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.mapper.IUserMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IUserMapper iUserMapper;

    @Override
    public void followUser(int userId, int userToFollowId){

        User user = iUserRepository.getUser(userId);
        User userToFollow = iUserRepository.getUser(userToFollowId);
        //AGREGAR VALIDACIONES
        iUserRepository.followUser(user.getId(), userToFollow.getId());
    }

    @Override
    public UserTotalFollowersDTO getTotalUserFollowers(int id) {
        User user = iUserRepository.getUser(id);
        int totalFollowers = iUserRepository.getTotalUserFollowers(user.getId());
        return iUserMapper.toUserTotalFollowersDTO(user, totalFollowers);
    }

    @Override
    public UserFollowersDTO getUsersFollowers(int id) {
        User user = iUserRepository.getUser(id);
        List<User> followers = iUserRepository.getUsersFollowers(user.getId());
        return iUserMapper.toUserFollowersDTO(user, followers);
    }

    @Override
    public UserFollowersDTO getUsersFollowers(int id, String order) {
        User user = iUserRepository.getUser(id);
        List<User> followers = iUserRepository.getUsersFollowers(user.getId());
        followers.sort((u1, u2)-> {
            if (order.equals("name_asc")) {
                return u1.getName().compareTo(u2.getName());
            } else if (order.equals("name_desc")){
                return (u1.getName().compareTo(u2.getName())) * -1;
            } else {
                //TIRAR EXCEPCION SOBRE ORDEN NO RECONOCIDO
                return 0;
            }
        });
        return iUserMapper.toUserFollowersDTO(user, followers);
    }

    @Override
    public UserFollowedDTO getUsersFollowed(int id) {
        User user = iUserRepository.getUser(id);
        List<User> followed = iUserRepository.getUsersFollowed(user.getId());
        return iUserMapper.toUserFollowedDTO(user, followed);
    }

    @Override
    public UserFollowedDTO getUsersFollowed(int id, String order) {
        User user = iUserRepository.getUser(id);
        List<User> followed = iUserRepository.getUsersFollowed(user.getId());
        followed.sort((u1, u2)-> {
            if (order.equals("name_asc")) {
                return u1.getName().compareTo(u2.getName());
            } else if (order.equals("name_desc")){
                return (u1.getName().compareTo(u2.getName())) * -1;
            } else {
                //TIRAR EXCEPCION SOBRE ORDEN NO RECONOCIDO
                return 0;
            }
        });
        return iUserMapper.toUserFollowedDTO(user, followed);
    }


    @Override
    public void unfollowUser(int userId, int userToUnfollowId) {
        User user = iUserRepository.getUser(userId);
        User userToUnfollow = iUserRepository.getUser(userToUnfollowId);
        //AGREGAR VALIDACIONES
        iUserRepository.unfollowUser(user.getId(), userToUnfollow.getId());
    }

}
