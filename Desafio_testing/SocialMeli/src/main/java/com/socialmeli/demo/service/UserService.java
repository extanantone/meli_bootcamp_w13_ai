package com.socialmeli.demo.service;

import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.exceptions.BadRequestException;
import com.socialmeli.demo.exceptions.UserNotFoundException;
import com.socialmeli.demo.mapper.UserMapper;
import com.socialmeli.demo.model.User;
import com.socialmeli.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO addUser(AddUserDTO addUserDTO) {

        User newUser = this.userRepository.createUser(this.userMapper.addUserDTOToUser(addUserDTO));

        return this.userMapper.userToUserDTO(newUser);
    }

    @Override
    public UserDTO getUserById(Integer id) {

        User user = this.userRepository.findUserById(id);

        if(user == null) throw new UserNotFoundException(id);

        return this.userMapper.userToUserDTO(this.userRepository.findUserById(id));
    }

    @Override
    public List<UserDTO> getUsers() {
        return this.userRepository.getUsers().stream().map(e -> this.userMapper.userToUserDTO(e)).collect(Collectors.toList());
    }

    @Override
    public UserFollowedDTO followUser(Integer userId, Integer userToFollowId) {

        if(userId.equals(userToFollowId)) throw new BadRequestException("The user cannot follow himself.");

        User user = this.userRepository.findUserById(userId);
        User userToFollow = this.userRepository.findUserById(userToFollowId);

        if(user == null) throw new UserNotFoundException(userId);
        if(userToFollow == null) throw new UserNotFoundException(userToFollowId);

        if(user.getFollowed().contains(userToFollow)) throw new BadRequestException(
                "The user with id: " + userId + " already follows the user with id: " + userToFollowId
        );

        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        return this.userMapper.userToUserFollowedDTO(user);
    }

    @Override
    public UserFollowersDTO getUserFollowersList(Integer userId, String order) {

        User user = this.userRepository.findUserById(userId);

        if(user == null) throw new UserNotFoundException(userId);

        if(order != null){
            user.getFollowers().sort((x,y) ->{
                if (order.equals("name_asc")) {
                    return x.getUserName().compareTo(y.getUserName());
                } else if (order.equals("name_desc")) {
                    return y.getUserName().compareTo(x.getUserName());
                }
                return 0;
            });
        }

        return this.userMapper.userToUserFollowersDTO(user);
    }

    @Override
    public UserFollowedDTO getUserFollowedList(Integer userId, String order) {

        User user = this.userRepository.findUserById(userId);

        if(user == null) throw new UserNotFoundException(userId);

        if(order != null){
            user.getFollowers().sort((x,y) ->{
                if (order.equals("name_asc")) {
                    return x.getUserName().compareTo(y.getUserName());
                } else if (order.equals("name_desc")) {
                    return y.getUserName().compareTo(x.getUserName());
                }
                return 0;
            });
        }

        return this.userMapper.userToUserFollowedDTO(user);
    }

    @Override
    public UserWithFollowersCountDTO getUserFollowersCount(Integer userId) {

        User user = this.userRepository.findUserById(userId);

        if(user == null) throw new UserNotFoundException(userId);

        return this.userMapper.userToUserWithFollowersCountDTO(user);
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) {

        User follower = this.userRepository.findUserById(userId);
        User followed = this.userRepository.findUserById(userIdToUnfollow);

        if(follower == null) throw new  UserNotFoundException(userId);
        if(followed == null) throw new UserNotFoundException(userIdToUnfollow);

        if(!follower.getFollowed().contains(followed)) throw new BadRequestException(
                "The user with id: " + follower.getUserId() + " doesn't follow the user with id: " + followed.getUserId()
        );

        follower.getFollowed().remove(followed);
        followed.getFollowers().remove(follower);
    }
}
