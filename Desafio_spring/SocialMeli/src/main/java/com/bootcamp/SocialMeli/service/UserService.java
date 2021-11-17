package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository repository;

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        // valida que existan (falta manejar excepciones)
        if(!userId.equals(userIdToFollow)){
            User user = repository.getUser(userId).orElse(null);
            User userToFollow = repository.getUser(userIdToFollow).orElse(null);
            //repository.followUser(userId, userIdToFollow);
            user.addFollowed(userToFollow);
            userToFollow.addFollower(user);
//            System.out.println(repository.getUsersList());
        }
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) {
        if(!userId.equals(userIdToUnfollow)){
            User user = repository.getUser(userId).orElse(null);
            User userToUnfollow = repository.getUser(userIdToUnfollow).orElse(null);
            user.deleteFollowed(userToUnfollow);
            userToUnfollow.deleteFollower(user);
        }
    }

    @Override
    public void newPublication(PostDTO dto) {
        System.out.println(dto.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        User user = repository.getUser(dto.getUserId()).orElse(null);
    }

    @Override
    public FollowerCountDTO countFollowers(Integer userId) {
        User user = repository.getUser(userId).orElse(null);
        Integer count = user.getFollowers().size();
        FollowerCountDTO dto = new FollowerCountDTO(user.getUserId(), user.getUserName(), count);
        return dto;
    }

    @Override
    public FollowersDTO getFollowers(Integer userId, String order) {
        User user = repository.getUser(userId).orElse(null);
        List<UserDTO> followersList = new ArrayList<>();
        for (Map.Entry<Integer, User> follower:user.getFollowers().entrySet()
        ) {
            followersList.add(new UserDTO(follower.getValue().getUserId(), follower.getValue().getUserName()));
        }
        if(!Objects.isNull(order)){
            if(order.equals("name_asc")){
                followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)).
                        collect(Collectors.toList());
            }
            if(order.equals("name_desc")){
                followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)
                                .reversed()).
                        collect(Collectors.toList());
            }
        }
        FollowersDTO dto = new FollowersDTO(user.getUserId(), user.getUserName(), followersList);
        return dto;
    }

    @Override
    public FollowedDTO getFollowed(Integer userId, String order) {
        User user = repository.getUser(userId).orElse(null);
        List<UserDTO> followedList = new ArrayList<>();
        for (Map.Entry<Integer, User> followed:user.getFollowed().entrySet()
        ) {
            followedList.add(new UserDTO(followed.getValue().getUserId(), followed.getValue().getUserName()));
        }
        if(!Objects.isNull(order)){
            if(order.equals("name_asc")){
                followedList = followedList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)).
                        collect(Collectors.toList());
            }
            if(order.equals("name_desc")){
                followedList = followedList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)
                                .reversed()).
                        collect(Collectors.toList());
            }
        }
        FollowedDTO dto = new FollowedDTO(user.getUserId(), user.getUserName(), followedList);
        return dto;
    }
}
