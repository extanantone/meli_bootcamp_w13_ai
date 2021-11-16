package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Publication;
import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {

    List<User> userList;
    private HashMap<Integer, Publication> publicationList;

    public SocialMeliRepository() {
        this.userList = userJson();
        this.publicationList = new HashMap<>();
    }

    public List<User> userJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> userList = null;
        try {
            userList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void addNewFollower(Integer user_id, Integer user_id_to_follow) {
        User follower = userId(user_id);
        if (!userList.equals(null)) {
            this.userList.stream().filter(user -> user.getUser_id().equals(user_id_to_follow))
                    .findFirst().orElse(null).getFollowers().add(follower);
        }
    }

    @Override
    public void addNewFollowed(Integer user_id, Integer user_id_to_follow) {
        User followed = userId(user_id_to_follow);
        if (!userList.equals(null)) {
            this.userList.stream().filter(user -> user.getUser_id().equals(user_id))
                    .findFirst().orElse(null).getFollowers().add(followed);
        }
    }

    @Override
    public User userId(Integer user_id) {
        return this.userList.stream().filter(user ->
                user.getUser_id().equals(user_id)).findFirst().orElse(null);
    }

    @Override
    public boolean findUser(Integer user_id) {
        return this.userList.stream().anyMatch(user -> user.getUser_id().equals(user_id));
    }

    @Override
    public Publication createPublication(Publication publication) {
        publicationList.put(publication.getId_post(), publication);
        return publication;
    }

    @Override
    public void deleteFollower(Integer user_id, Integer user_id_to_unfollow) {

    }

    @Override
    public void deleteFollowed(Integer user_id, Integer user_id_to_unfollow) {

    }
}
