package com.example.socialmeli.repositories;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository("UserRepository")
public class UsuarioRepository implements IRepository<User> {

    List<User> users;

    public UsuarioRepository(){
        loadFromUsersFile();
    }

    public void loadFromUsersFile() {
        Properties properties =  new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String SCOPE = properties.getProperty("api.scope");
            this.users = loadFromFile(SCOPE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List<User>  loadFromFile(String SCOPE) {

        List<User> loadedData = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/usersSocialMeli.json");
            loadedData = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;

    }

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream()
                .filter(us -> us.getUserId().equals(id))
                .findFirst();

    }

    @Override
    public List<User> findAll(){
        return this.users;
    }

    @Override
    public void push(Post newElement) {
        throw new UnsupportedOperationException();
    }

    public void reset() { this.users = Collections.emptyList();}

    public void overwriteWith(List<User> users) {
        this.users = users;
    }


    public List<User> findFollowed(Integer id) {
        return this.users.stream()
                .filter(user -> user.getFollowersId().contains(id) )
                .collect(Collectors.toList());
    }

}
