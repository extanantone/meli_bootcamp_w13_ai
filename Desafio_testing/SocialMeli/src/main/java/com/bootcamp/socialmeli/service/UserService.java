package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.exception.NotFoundOrderParamException;
import com.bootcamp.socialmeli.exception.NotPossibleFollowUserException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.mapper.IUserMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;
    /*
    @Autowired
    IUserMapper iUserMapper;
    */


    @Override
    public void followUser(int userId, int userToFollowId) throws NotPossibleOperationException {
        if (userId == userToFollowId) throw new NotPossibleFollowUserException();

        User user = iUserRepository.getUser(userId);
        //if (user == null)   throw new NotFoundUserException(userId);

        User userToFollow = iUserRepository.getUser(userToFollowId);
        //if (userToFollow == null) throw new NotFoundUserException(userToFollowId);

        iUserRepository.followUser(user, userToFollow);
    }

    @Override
    public UserTotalFollowersDTO getTotalUserFollowers(int id) throws NotPossibleOperationException{
        User user = iUserRepository.getUser(id);
        //if (user == null) throw new NotFoundUserException(id);

        int totalFollowers = iUserRepository.getTotalUserFollowers(user);

        UserTotalFollowersDTO userTotalFollowersDTO = new UserTotalFollowersDTO(
                user.getId(),
                user.getName(),
                totalFollowers
        );

        return userTotalFollowersDTO;

        //return iUserMapper.toUserTotalFollowersDTO(user, totalFollowers);
    }

    @Override
    public UserFollowersDTO getUsersFollowers(int id, String order) throws NotPossibleOperationException{
        User user = iUserRepository.getUser(id);
        //if (user == null) throw new NotFoundUserException(id);

        List<User> followers = iUserRepository.getUsersFollowers(user.getId());

        //if (order != null)  followers.sort((u1, u2) -> compareUser(u1, u2, order));

        if (order != null)  orderUserList(followers, order.toLowerCase());

        UserFollowersDTO userFollowersDTO = new UserFollowersDTO(
                user.getId(),
                user.getName(),
                followers.stream().map( u ->
                        new UserDTO(u.getId(), u.getName()))
                        .collect(Collectors.toList())
        );

        return userFollowersDTO;
        //return iUserMapper.toUserFollowersDTO(user, followers);
    }

    @Override
    public UserFollowedDTO getUsersFollowed(int id, String order) throws NotPossibleOperationException{
        User user = iUserRepository.getUser(id);
        //if (user == null)   throw new NotFoundUserException(id);

        List<User> followed = iUserRepository.getUsersFollowed(user);

        //if (order != null)  followed.sort((u1, u2) -> compareUser(u1, u2, order));

        if (order != null)  orderUserList(followed, order.toLowerCase());

        UserFollowedDTO userFollowedDTO = new UserFollowedDTO(
                user.getId(),
                user.getName(),
                followed.stream().map( u ->
                                new UserDTO(u.getId(), u.getName()))
                        .collect(Collectors.toList())
        );

        return userFollowedDTO;

        //return iUserMapper.toUserFollowedDTO(user, followed);
    }


    @Override
    public void unfollowUser(int userId, int userToUnfollowId) throws NotPossibleOperationException {
        if (userId == userToUnfollowId) throw new NotPossibleFollowUserException();

        User user = iUserRepository.getUser(userId);
        //if (user == null)   throw new NotFoundUserException(userId);

        User userToUnfollow = iUserRepository.getUser(userToUnfollowId);
        //if (userToUnfollow == null)   throw new NotFoundUserException(userId);

        iUserRepository.unfollowUser(user, userToUnfollow);
    }

    private void orderUserList(List<User> userList, String order) throws NotFoundOrderParamException {
        if (order.equals("name_asc")){
            userList.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
        } else if (order.equals("name_desc")){
            userList.sort((u1, u2) -> u1.getName().compareTo(u2.getName()) * -1);
        } else {
            throw new NotFoundOrderParamException(order);
        }
    }
}
