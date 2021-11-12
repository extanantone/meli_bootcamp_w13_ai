package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO create(UserDTO user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO followUser(Integer user_id, Integer user_id_to_follow) {
        return userRepository.follow(user_id, user_id_to_follow);
    }
}
