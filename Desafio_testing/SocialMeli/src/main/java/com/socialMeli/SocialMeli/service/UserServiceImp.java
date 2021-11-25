package com.socialMeli.SocialMeli.service;

import com.socialMeli.SocialMeli.exception.userExceptions.FollowItselfException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.userDto.*;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userRepository.loadUsers();
    }

    @Override
    public UserFollowDTO follow(Integer user_id, Integer user_to_follow_id) {
        if(verifyUsers(user_id,user_to_follow_id)){
            if(user_id==user_to_follow_id){
                throw new FollowItselfException();
            }
            return userRepository.follow(user_id,user_to_follow_id);
        }else{
            throw new NotFoundUserException();
        }
    }

    private boolean verifyUsers(Integer user_id, Integer user_id_to_follow){
        User user1=userRepository.getList_users().get(user_id);
        User user2=userRepository.getList_users().get(user_id_to_follow);
        if(user1 != null && user2 != null){
            return true;
        }else {
            return false;
        }
    }

    private boolean verifyUsers(Integer user_id){
        User user1=userRepository.getList_users().get(user_id);
        if(user1 != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public UserFollowersCountDTO countFollowers(Integer user_id) {
        if(verifyUsers(user_id)){
            return userRepository.countFollowers(user_id);
        }else{
            throw new NotFoundUserException();
        }
    }

    @Override
    public FollowersListDTO listFollowers(Integer user_id) {
        if(verifyUsers(user_id)){
            return userRepository.listFollowers(user_id);
        }else{
            throw new NotFoundUserException();
        }
    }

    @Override
    public FollowersListDTO listFollowers(Integer user_id, String order) {
        if(verifyUsers(user_id)){
            if(order.equals("name_asc")){
                List orderedList = userRepository.listFollowers(user_id).getFollowers().stream().sorted(Comparator.comparing(UserInfoDTO::getUser_name)).collect(Collectors.toList());
                FollowersListDTO listDTO = new FollowersListDTO(user_id,userRepository.getList_users().get(user_id).getUsername(),orderedList);
                return listDTO;
            }else{
                List orderedList = userRepository.listFollowers(user_id).getFollowers().stream().sorted(Comparator.comparing(UserInfoDTO::getUser_name).reversed()).collect(Collectors.toList());
                FollowersListDTO listDTO = new FollowersListDTO(user_id,userRepository.getList_users().get(user_id).getUsername(),orderedList);
                return listDTO;
            }
        }else{
            throw new NotFoundUserException();
        }
    }

    @Override
    public FollowedListDTO listFollowed(Integer user_id) {
        if(verifyUsers(user_id)){
            return userRepository.listFollowed(user_id);
        }else{
            throw new NotFoundUserException();
        }
    }

    @Override
    public FollowedListDTO listFollowed(Integer user_id, String order) {
        if(verifyUsers(user_id)){
            if(order.equals("name_asc")){
                List orderedList = userRepository.listFollowed(user_id).getFollowed().stream().sorted(Comparator.comparing(UserInfoDTO::getUser_name)).collect(Collectors.toList());
                FollowedListDTO listDTO = new FollowedListDTO(user_id,userRepository.getList_users().get(user_id).getUsername(),orderedList);
                return listDTO;
            }else{
                List orderedList = userRepository.listFollowed(user_id).getFollowed().stream().sorted(Comparator.comparing(UserInfoDTO::getUser_name).reversed()).collect(Collectors.toList());
                FollowedListDTO listDTO = new FollowedListDTO(user_id,userRepository.getList_users().get(user_id).getUsername(),orderedList);
                return listDTO;
            }
        }else{
            throw new NotFoundUserException();
        }
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public UserFollowDTO unfollow(Integer user_id, Integer user_id_to_unfollow) {
        if(verifyUsers(user_id,user_id_to_unfollow)){
            return userRepository.unfollow(user_id,user_id_to_unfollow);
        }else{
            throw new NotFoundUserException();
        }
    }
}
