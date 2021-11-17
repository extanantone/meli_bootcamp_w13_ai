package com.example.socialmeli.repository;

import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository implements IUserRepository{

    private List<User> users= new ArrayList<>();

    public UserRepository() {
        this.users = readJson();
    }

    public List<User> readJson () {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void follow(User userId, User userIdToFollow) {

        userId.addFollowed(new UserDto(userIdToFollow));
        userIdToFollow.addFollower(new UserDto(userId));
    }

    @Override
    public User validateFollow(User userId, User userIdToFollow) {
        return users.stream()
                .filter(x -> x.getFollowed().containsKey(userIdToFollow.getUserId()))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Usuario no sigue al vendedor con id:" + userIdToFollow.getUserId()));
    }
    @Override
    public User findById(Integer userId) {

        return users.stream()
                .filter(x -> x.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));
    }

    @Override
    public void unFollow(User userId, User userIdToUnfollow) {
        userId.removeFollowed(new UserDto(userIdToUnfollow));
        userIdToUnfollow.removeFollowed(new UserDto(userId));
    }
}


