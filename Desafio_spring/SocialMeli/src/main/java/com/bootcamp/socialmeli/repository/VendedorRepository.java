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
import java.util.List;
import java.util.Optional;

@Repository
public class VendedorRepository implements IVendedorRepository {

    List<User> users;

    public VendedorRepository() {
        this.users = openUserJson();
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

    // US0001
    @Override
    public Optional<User> addFollowerToSeller(Long actualUserId, Long userToFollowId) {
        for (User i: this.users) {
            // TODO: check if user exist in memory

            if(userToFollowId.equals(i.getUserId())) {

            }

        }
        return Optional.empty();
    }

    // US0002
    @Override
    public Optional<User> getSellerFollowersCount(Long id) {
        return Optional.empty();
    }

    // US0003
    @Override
    public Optional<User> findSellerById(Long id) {
        for (User i: this.users) {
            if (id.equals(i.getUserId())) return Optional.of(i);
        }
        return Optional.empty();
    }






}
