package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.FollowedListResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerCountResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerListResponseDTO;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.BadRequestException;
import com.bootcamp.socialmeli.exception.IllegalRequestParamException;
import com.bootcamp.socialmeli.exception.UserNotFoundException;
import com.bootcamp.socialmeli.mapper.UserMapper;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.util.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderUtils orderUtils;

    @Override
    public boolean follow(Long followerID, Long followedID) {
        if(followerID.equals(followedID)) throw new BadRequestException("El usuario no puede seguirse a si mismo");
        User follower = userRepository.getUser(followerID);
        if(follower == null) throw new UserNotFoundException(followerID);
        User followed = userRepository.getUser(followedID);
        if(followed == null) throw new UserNotFoundException(followedID);
        return userRepository.follow(follower,followed);
    }

    @Override
    public boolean unfollow(Long followerID, Long followedID) {
        if(followerID.equals(followedID)) throw new BadRequestException("El usuario no puede dejar de seguirse a si mismo");
        User follower = userRepository.getUser(followerID);
        if(follower == null) throw new UserNotFoundException(followerID);
        User followed = userRepository.getUser(followedID);
        if(followed == null) throw new UserNotFoundException(followedID);
        return userRepository.unfollow(follower,followed);
    }

    @Override
    public FollowerCountResponseDTO followersCount(Long userID) {
        User user = userRepository.getUser(userID);
        if(user == null) throw new UserNotFoundException(userID);
        return new FollowerCountResponseDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    @Override
    public FollowerListResponseDTO followersList(Long userID, String order) {
        User user = userRepository.getUser(userID);
        if(user == null) throw new UserNotFoundException(userID);
        if(order == null) throw new IllegalRequestParamException("Valor ilegal para el request param order.");
        return orderUtils.order(userMapper.userToFollowerList(userRepository.getUser(userID)),order);
    }

    @Override
    public FollowedListResponseDTO followedList(Long userID, String order) {
        User user = userRepository.getUser(userID);
        if(user == null) throw new UserNotFoundException(userID);
        if(order == null) throw new IllegalRequestParamException("Valor ilegal para el request param order.");
        return orderUtils.order(userMapper.userToFollowedList(userRepository.getUser(userID)),order);
    }
}
