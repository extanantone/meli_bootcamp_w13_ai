package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.dto.mapper.UserMapper;
import com.lgoyenechea.socialmeli.model.User;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserCreationDTO newUser) throws UserArgumentNotValidException {
        if (newUser.getUserName() == null || newUser.getUserName().equals(""))
            throw new UserArgumentNotValidException("Invalid user name.");

        User user = userRepository.save(UserMapper.userCreationDtoToUser(newUser));
        return UserMapper.userToDto(user);
    }

    public UserFollowDTO follow(Long userId, Long userIdToFollow) throws UserArgumentNotValidException {
        if (userId.equals(userIdToFollow))
            throw new UserArgumentNotValidException("Users id cannot match.");

        User user = userRepository.getById(userId);
        User followed = userRepository.getById(userIdToFollow);

        if (user == null || followed == null)
            throw new UserArgumentNotValidException("Invalid user id.");

        if (!user.getFollowed().contains(followed)) {
            user.getFollowed().add(followed);
            followed.getFollowers().add(user);
        }
        return UserMapper.userToFollow(user, followed);
    }

    public UserFollowersCountDTO followersCount(Long userId) throws UserArgumentNotValidException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserArgumentNotValidException("Invalid user id.");
        return UserMapper.userToFollowersCount(user);
    }

    public UserFollowersListDTO followersList(Long userId) throws UserArgumentNotValidException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserArgumentNotValidException("Invalid user id.");
        return UserMapper.userToFollowersList(user);
    }

    public UserFollowedListDTO followedList(Long userId) throws UserArgumentNotValidException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserArgumentNotValidException("Invalid user id.");
        return UserMapper.userToFollowedList(user);
    }
}
