package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.UserCreationDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.dto.UserWithFollowersDTO;
import com.bootcamp.socialmeli.mapper.IMapper;
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

    @Override
    public List<UserDTO> getAll() {
        return userRepository.getAll().stream().map(mapper::userToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(long id) {
        return mapper.userToUserDTO(userRepository.getUser(id));
    }

    @Override
    public UserDTO createUser(UserCreationDTO user) {
        return null;
    }

    @Override
    public boolean deleteUser(long id) {
        return false;
    }

    @Override
    public boolean followUser(long followerId, long followedId) {
        userRepository.followUser(followerId, followedId);
        return true;
    }

    @Override
    public int getFollowerCount(long id) {
        return userRepository.getUser(id).getFollowers().size();
    }

    @Override
    public UserWithFollowersDTO getFollowers(long id) {
        return mapper.userToUserWithFollowersDTO(userRepository.getUser(id));
    }


}
