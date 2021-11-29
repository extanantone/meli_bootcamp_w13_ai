package com.example.socialmeli.service.repository.user;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Getter
public class UserRepository implements IUserRepository
{
    private List<User> userList;

    public UserRepository()
    {
        this.userList = getJsonData();
    }

    @Override
    public void deleteAll()
    {
        User.resetId();
        userList = getJsonData();
    }

    @Override
    public Map<Integer, User> usersMap()
    {
        return userList.stream().collect(Collectors.toMap(User::getUserId, user -> user));
    }

    @Override
    public List<User> findFollowersOrderByNameDesc(int userId)
    {
        Comparator<User> nameDesc = Comparator.comparing(User::getUserName).reversed();
        return usersMap().get(userId).getFollowers().stream().sorted(nameDesc).collect(Collectors.toList());
    }

    @Override
    public List<User> findFollowersOrderByNameAsc(int userId)
    {
        Comparator<User> nameAsc = Comparator.comparing(User::getUserName);
        return usersMap().get(userId).getFollowers().stream().sorted(nameAsc).collect(Collectors.toList());
    }

    @Override
    public List<User> findFollowedOrderByNameDesc(int userId)
    {
        Comparator<User> nameDesc = Comparator.comparing(User::getUserName).reversed();
        return usersMap().get(userId).getFollowed().stream().sorted(nameDesc).collect(Collectors.toList());
    }

    @Override
    public List<User> findFollowedOrderByNameAsc(int userId)
    {
        Comparator<User> nameAsc = Comparator.comparing(User::getUserName);
        return usersMap().get(userId).getFollowed().stream().sorted(nameAsc).collect(Collectors.toList());
    }

    private List<User> getJsonData()
    {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:user.json");
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
}
