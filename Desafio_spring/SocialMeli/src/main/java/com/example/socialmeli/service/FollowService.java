package com.example.socialmeli.service;

import com.example.socialmeli.dto.FollowerCountDTO;
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
    public FollowerCountDTO followerCount(Integer userid) {
        User user = userRepository.find(userid);
        return new FollowerCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }
}
