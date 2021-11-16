package com.example.socialmeli.service;

import com.example.socialmeli.dto.BasicUserDTO;
import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;


@Service
public class FollowService implements IFollowService{
    private final IUserRepository userRepository;

    public FollowService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void addFollow(Integer userId, Integer followId) {
        User user = userRepository.find(userId);
        User follow = userRepository.find(followId);
        user.addFollow((followId));
        follow.addFollower(userId);
    }

    @Override
    public void removeFollow(Integer userId, Integer followId) {
        User user = userRepository.find(userId);
        User follow = userRepository.find(followId);
        user.removeFollow(followId);
        follow.removeFollower(userId);
    }

    @Override
    public FollowerCountDTO followerCount(Integer userid) {
        User user = userRepository.find(userid);
        return new FollowerCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }

    @Override
    public FollowerListDTO followerList(Integer userId) {
        User user = userRepository.find(userId);
        User follower;
        FollowerListDTO ListDTO = new FollowerListDTO(user.getId(), user.getName());
        for(Integer followerId : user.getFollowers()) {
            follower = userRepository.find(followerId);
            ListDTO.followers.add(new BasicUserDTO(follower.getId(), follower.getName()));
        }
        return ListDTO;
    }

    @Override
    public FollowerListDTO followingList(Integer userId) {
        User user = userRepository.find(userId);
        User follower;
        BasicUserDTO basicUser;
        FollowerListDTO ListDTO = new FollowerListDTO(user.getId(), user.getName());
        for(Integer followerId : user.getFollowed()) {
            follower = userRepository.find(followerId);
            basicUser = new BasicUserDTO(follower.getId(), follower.getName());
            ListDTO.followers.add(basicUser);
        }
        return ListDTO;
    }
}
