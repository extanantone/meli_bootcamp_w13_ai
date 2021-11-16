package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VendedorRepository implements IVendedorRepository {

    private HashMap<Long, User> users;

    public VendedorRepository() {

        //TODO: Read from json
        //this.users = openUserJson();
        this.users = new HashMap<>();
        this.users.put(1L, new User(1L, "vendedor1"));
        this.users.put(2L, new User(2L, "comprador1"));
        this.users.put(3L, new User(3L, "comprador2"));
        this.users.put(4L, new User(4L, "comprador3"));


    }

    @Override
    public List<User> openUserJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
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
    public User getUser(Long idUser) {
        return this.users.get(idUser);
    }

    @Override
    public List<User> getFollowers(Long idUser) {
        return this.users.get(idUser).getFollowers().stream().map(
                i -> this.users.get(i)).collect(Collectors.toList());
    }

    @Override
    public List<User> getFolloweds(Long idUser) {
        return this.users.get(idUser).getFollowed().stream().map(
                i -> this.users.get(i)).collect(Collectors.toList());
    }

    // US0001
    @Override
    public void addFollow(Long idFollower, Long idFollowed) {
        User newFollower = this.users.get(idFollower);
        newFollower.addFollowed(idFollowed);
        User newFollowed = this.users.get(idFollowed);
        newFollowed.addFollower(idFollower);
    }

    // US0002


}
