package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.exception.NotFoundUserException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.mapper.IUserMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IUserMapper iUserMapper;

    @Override
    public void followUser(int userId, int userToFollowId) throws NotPossibleOperationException {

        if (userId == userToFollowId) throw new NotPossibleOperationException();

        User user = iUserRepository.getUser(userId);
        if (user == null)   throw new NotFoundUserException(userId);

        User userToFollow = iUserRepository.getUser(userToFollowId);
        if (userToFollow == null) throw new NotFoundUserException(userToFollowId);

        iUserRepository.followUser(user, userToFollow);
    }

    @Override
    public UserTotalFollowersDTO getTotalUserFollowers(int id) throws NotPossibleOperationException{
        User user = iUserRepository.getUser(id);
        if (user == null) throw new NotFoundUserException(id);

        int totalFollowers = iUserRepository.getTotalUserFollowers(user);
        try{
            return iUserMapper.toUserTotalFollowersDTO(user, totalFollowers);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UserFollowersDTO getUsersFollowers(int id, String order) throws NotPossibleOperationException{
        User user = iUserRepository.getUser(id);
        if (user == null) throw new NotFoundUserException(id);

        List<User> followers = iUserRepository.getUsersFollowers(user.getId());

        if (order != null)  followers.sort((u1, u2) -> compareUser(u1, u2, order));
        return iUserMapper.toUserFollowersDTO(user, followers);
    }

    @Override
    public UserFollowedDTO getUsersFollowed(int id, String order) throws NotPossibleOperationException{
        User user = iUserRepository.getUser(id);
        if (user == null)   throw new NotFoundUserException(id);

        List<User> followed = iUserRepository.getUsersFollowed(user);

        if (order != null)  followed.sort((u1, u2) -> compareUser(u1, u2, order));

        return iUserMapper.toUserFollowedDTO(user, followed);
    }


    @Override
    public void unfollowUser(int userId, int userToUnfollowId) throws NotFoundUserException {
        User user = iUserRepository.getUser(userId);
        if (user == null)   throw new NotFoundUserException(userId);

        User userToUnfollow = iUserRepository.getUser(userToUnfollowId);
        if (userToUnfollow == null)   throw new NotFoundUserException(userId);
        iUserRepository.unfollowUser(user, userToUnfollow);
    }

    private int compareUser(User u1, User u2, String order){
        if (order.equals("name_asc")) {
            return u1.getName().compareTo(u2.getName());
        } else if (order.equals("name_desc")){
            return (u1.getName().compareTo(u2.getName())) * -1;
        } else {
            //TODO: Definir comportamiento en caso que el order no sea ninguno de los casos
            return 0;
        }
    }

}
