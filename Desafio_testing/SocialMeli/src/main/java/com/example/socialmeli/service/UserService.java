package com.example.socialmeli.service;

import com.example.socialmeli.dto.FollowedDto;
import com.example.socialmeli.dto.FollowersDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private List<UserDto> getList (Map<Integer,UserDto> map, String order) {
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

        if(userId.equals(userIdToFollow)) {
            throw new BadRequestException("Los id's no pueden ser identicos");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));;
        User userDto = userRepository.findById(userIdToFollow).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));;
        userRepository.follow(user,userDto);

    }

    @Override
    public void unfollow(Integer userId,Integer userIdToUnfollow) {

        if(userId.equals(userIdToUnfollow)) {
            throw new BadRequestException("Los id's no pueden ser identicos");
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));;
        User userDto = userRepository.findById(userIdToUnfollow).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));;
        userRepository.validateFollow(user,userDto).orElseThrow(() -> new BadRequestException("Usuario no sigue al vendedor con id:" + userDto.getUserId()));;
        userRepository.unFollow(user,userDto);
    }




    @Override
    public FollowersDto followersCount(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));;
        Map<Integer,UserDto> map = user.getFollowers();
        FollowersDto followersDto = new FollowersDto(user);
        followersDto.setFollowersCount(map.size());
        followersDto.setFollowers(null);

        return followersDto;
    }


    @Override
    public FollowersDto followers(Integer userId,String order) {

        if (order.equals("name_asc") || order.equals("name_desc")) {
            User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));
            ;
            Map<Integer, UserDto> map = user.getFollowers();
            FollowersDto followersDto = new FollowersDto(user, getList(map, order));
            return followersDto;
        } else {
            throw new BadRequestException("Ordenamiento no valido");
        }
    }

    @Override
    public FollowedDto followed(Integer userId,String order) {
        if (order.equals("name_asc") || order.equals("name_desc")) {
            User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));
            Map<Integer, UserDto> map = user.getFollowed();
            FollowedDto followedDto = new FollowedDto(user, getList(map, order));
            return followedDto;
        } else {

            throw new BadRequestException("Ordenamiento no valido");
        }

    }
}
