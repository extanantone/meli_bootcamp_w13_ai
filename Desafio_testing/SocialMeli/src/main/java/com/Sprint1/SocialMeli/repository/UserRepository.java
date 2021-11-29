package com.Sprint1.SocialMeli.repository;

import com.Sprint1.SocialMeli.exceptions.NotFoundException;
import com.Sprint1.SocialMeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    List<User> userList;

    UserRepository() {
        this.userList = openUserJson();
    }

    protected List<User> openUserJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:sellers.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper
                objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> user = null;
        try {
            user = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Optional<User> findUser (int user_id) throws NotFoundException{
        Optional<User> user = this.userList.stream()
                .filter(p -> p.getUser_id() == user_id )
                .findFirst();
//        if (true){
//            throw new NotFoundException("El numero de ID: " + user_id + " no fue encontrado");
//        }
        return user;
    }

}
