package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.UserCountFollowersDTO;
import com.example.SocialMeli.dto.UserDTO;
import com.example.SocialMeli.dto.UserFollowersDTO;
import com.example.SocialMeli.entities.User;
import com.example.SocialMeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean saveFollow(int user_id, int toFollow) throws Exception {
        User user = userRepository.getById(user_id);
        if(user == null) throw new Exception();
        return this.userRepository.saveFollow(user_id, toFollow);
    }

    @Override
    public UserCountFollowersDTO countFollowers(int user_id) throws Exception {
        User user = this.userRepository.getById(user_id);
        if (user == null) throw new Exception();
        return new UserCountFollowersDTO(user.getUser_id(), user.getUser_name(), user.getSeguidores().size());
    }

    @Override
    public UserFollowersDTO listFollowers(int user_id) throws Exception {
        List<User> followers = this.userRepository.getFollowers(user_id);
        List<UserDTO> followersDTO = new ArrayList<>();
        followers.forEach(user -> followersDTO.add(new UserDTO(Math.toIntExact(user.getUser_id()), user.getUser_name())));
        User userFinal = this.userRepository.getById(user_id);
        return new UserFollowersDTO(user_id, userFinal.getUser_name(), followersDTO );
        }

}
