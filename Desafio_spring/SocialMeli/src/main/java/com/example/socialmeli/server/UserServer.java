package com.example.socialmeli.server;

import com.example.socialmeli.dto.FollowedDto;
import com.example.socialmeli.dto.FollowersDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IUserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServer implements IUserServer{

    IUserRepository userRepository;

    public UserServer(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getList (Map<Integer,UserDto> map, String order) {
        List<UserDto> list = new ArrayList<>();
        for (Map.Entry<Integer,UserDto> follow:map.entrySet()
        ) {
            list.add(follow.getValue());
        }


        if(order.equals("name_asc") ) {
            return list.stream().sorted(Comparator.comparing(UserDto::getUserName)).collect(Collectors.toList());
        }
        else if(order.equals("name_desc")){
            return list.stream().sorted(Comparator.comparing(UserDto::getUserName).reversed()).collect(Collectors.toList());
        } else {
            return list;
        }

    }


    @Override
    public void follower(Integer userId, Integer userIdToFollow){

        User user = userRepository.findById(userId);
        User userDto = userRepository.findById(userIdToFollow);
        userRepository.follow(user,userDto);

    }

    @Override
    public void unfollow(Integer userId,Integer userIdToUnfollow) {
        User user = userRepository.findById(userId);
        User userDto = userRepository.findById(userIdToUnfollow);
        userRepository.validateFollow(user,userDto);
        userRepository.unFollow(user,userDto);
    }




    @Override
    public FollowersDto followersCount(Integer userId) {
        User user = userRepository.findById(userId);
        Map<Integer,UserDto> map = user.getFollowers();
        FollowersDto followersDto = new FollowersDto(user);
        followersDto.setFollowersCount(map.size());
        followersDto.setFollowers(null);

        return followersDto;
    }


    @Override
    public FollowersDto followers(Integer userId,String order) {
        User user = userRepository.findById(userId);
        Map<Integer,UserDto> map = user.getFollowers();
        FollowersDto followersDto = new FollowersDto(user,getList(map,order));
        return followersDto;
    }

    @Override
    public FollowedDto followed(Integer userId,String order) {
        User user = userRepository.findById(userId);
        Map<Integer,UserDto> map = user.getFollowed();
        FollowedDto followedDto = new FollowedDto(user,getList(map,order));
        return followedDto;
    }
}
