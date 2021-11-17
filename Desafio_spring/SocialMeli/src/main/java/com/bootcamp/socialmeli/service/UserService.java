package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.exceptions.BadRequestException;
import com.bootcamp.socialmeli.exceptions.NotFoundException;
import com.bootcamp.socialmeli.mapper.IMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IMapper mapper;

    public UserService(IUserRepository userRepository, IMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public void checkUserExistence(long id){
        if (userRepository.getUser(id) == null) {
            throw new NotFoundException("User Not Found");
        }
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.getAll().stream().map(mapper::userToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(long id) {
        checkUserExistence(id);
        return mapper.userToUserDTO(userRepository.getUser(id));
    }

    @Override
    public UserDTO createUser(UserCreationDTO user) {
        User userCreated = userRepository.createUser(mapper.userCreationDTOToUser(user));
        return mapper.userToUserDTO(userCreated);
    }

    @Override
    public void deleteUser(long id) {
        checkUserExistence(id);
        userRepository.deleteUser(id);
    }

    @Override
    public void followUser(long followerId, long followedId) {
        User follower = userRepository.getUser(followerId);
        User followed = userRepository.getUser(followedId);
        if (followed.getFollowers().contains(follower)) {
            throw new BadRequestException("User is already a follower");
        } else if (followerId == followedId) {
            throw new BadRequestException("User can't follow themself");
        } else {
            follower.getFollowed().add(followed);
            followed.getFollowers().add(follower);
        }
    }

    @Override
    public UserWithCountDTO getFollowerCount(long id) {
        checkUserExistence(id);
        User user = userRepository.getUser(id);
        return new UserWithCountDTO(
                user.getId(),
                user.getUsername(),
                userRepository.getUser(id).getFollowers().size()
        );
    }

    @Override
    public UserWithFollowersDTO getFollowers(long id) {
        checkUserExistence(id);
        return mapper.userToUserWithFollowersDTO(userRepository.getUser(id));
    }

    @Override
    public UserWithCountDTO getFollowedCount(long id) {
        checkUserExistence(id);
        User user = userRepository.getUser(id);
        return new UserWithCountDTO(
                user.getId(),
                user.getUsername(),
                userRepository.getUser(id).getFollowed().size()
        );
    }

    @Override
    public UserWithFollowedDTO getFollowed(long id) {
        checkUserExistence(id);
        return mapper.userToUserWithFollowedDTO(userRepository.getUser(id));
    }

    @Override
    public void unfollowUser(long followerId, long followedId) {
        User follower = userRepository.getUser(followerId);
        User followed = userRepository.getUser(followedId);
        if (followed.getFollowers().contains(follower)) {
            follower.getFollowed().remove(followed);
            followed.getFollowers().remove(follower);
        } else {
            throw new BadRequestException("User isn't a follower");
        }
    }

    @Override
    public List<UserDTO> orderUsersByName(List<UserDTO> users, String order) {
        users.sort((u1, u2) -> {
            if (order.equals("asc")) {
                return u1.getUsername().compareTo(u2.getUsername());
            } else if (order.equals("desc")) {
                return u2.getUsername().compareTo(u1.getUsername());
            }
            return 0;
        });
        return users;
    }
}
