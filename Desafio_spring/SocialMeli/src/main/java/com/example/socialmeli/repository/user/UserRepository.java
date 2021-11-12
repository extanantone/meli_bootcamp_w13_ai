package com.example.socialmeli.repository.user;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository
{
    private List<User> userList;

    public UserRepository()
    {
        this.userList = getJsonData();
    }

    @Override
    public Map<Integer, User> usersMap()
    {

        return userList.stream().collect(Collectors.toMap(User::getUserId, x -> x));
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
