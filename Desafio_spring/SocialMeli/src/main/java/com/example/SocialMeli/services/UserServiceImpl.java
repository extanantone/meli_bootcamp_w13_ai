package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.UserCountFollowersDTO;
import com.example.SocialMeli.dto.UserDTO;
import com.example.SocialMeli.dto.UserFollowersDTO;
import com.example.SocialMeli.entities.User;
import com.example.SocialMeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Collections.reverse;

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
    public Boolean unfollow(int user_id, int id_to_unfollow) throws Exception {
        User usr = userRepository.getById(user_id);
        if(usr == null) throw new Exception();
        this.userRepository.unfollow(user_id, id_to_unfollow);
        return null;
    }

    @Override
    public UserCountFollowersDTO countFollowers(int user_id) throws Exception {
        User user = this.userRepository.getById(user_id);
        if (user == null) throw new Exception();
        return new UserCountFollowersDTO(user.getUser_id(), user.getUser_name(), user.getSeguidores().size());
    }

    @Override
    public UserFollowersDTO listFollowers(int user_id, String order) throws Exception {
        List<UserDTO> followersDTO = new ArrayList<>();
        this.userRepository.getFollowers(user_id).forEach(user -> followersDTO.add(new UserDTO(Math.toIntExact(user.getUser_id()), user.getUser_name())));
        return new UserFollowersDTO(user_id, this.userRepository.getById(user_id).getUser_name(), this.listOrder(followersDTO, order) );
        }

    @Override
    public UserFollowersDTO listFolloweds(int user_id, String order) throws Exception {
        List<UserDTO> followedsDTO = new ArrayList<>();
        this.userRepository.getFolloweds(user_id).forEach(user -> followedsDTO.add(new UserDTO(Math.toIntExact(user.getUser_id()), user.getUser_name())));
        return new UserFollowersDTO(user_id, this.userRepository.getById(user_id).getUser_name(), this.listOrder(followedsDTO, order) );    }

    public List<UserDTO> listOrder(List<UserDTO> follows, String order) {
        follows.sort(Comparator.comparing(UserDTO::getUser_name));
        if(Objects.equals(order, "name_desc")) reverse(follows);
        return follows;
    }

}
