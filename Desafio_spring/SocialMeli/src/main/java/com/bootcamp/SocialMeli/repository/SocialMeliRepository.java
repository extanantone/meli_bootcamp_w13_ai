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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {

    private HashMap<Integer, Publication> publicationList;
    private HashMap<Integer, User> userList;

    public SocialMeliRepository() {
        this.userList = (HashMap<Integer, User>) this.userJson();
        this.publicationList = (HashMap<Integer, Publication>) this.publicationJson();
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

    public List<Publication> publicationJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:post.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Publication>> typeRef = new TypeReference<>() {
        };
        List<Publication> publicationList = null;
        try {
            publicationList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publicationList;
    }

    @Override
    public void newFollow(Integer user_id, Integer user_id_to_follow) {
        User follower = this.userList.get(user_id);
        follower.follow(user_id);
        User followed = this.userList.get(user_id_to_follow);
        followed.addFolower(user_id);
    }

    @Override
    public User userId(Integer user_id) {
        return this.userList.get(user_id);
    }

    @Override
    public boolean checkUser(Integer user_id) {
        return Objects.nonNull(this.userList.get(user_id));
    }

    @Override
    public List<User> follower(Integer user_id) {
        return userId(user_id).getFollower().stream()
                .map(this.userList::get)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> followed(Integer user_id) {
        return userId(user_id).getFollowed().stream()
                .map(this.userList::get)
                .collect(Collectors.toList());
    }

    @Override
    public Publication createPublication(Publication publication) {
        publicationList.put(publication.getId_post(), publication);
        return publication;
    }

    @Override
    public void deleteFollow(Integer user_id, Integer user_id_to_unfollow) {
        User uFollower = userId(user_id);
        uFollower.unfollowFollower(user_id);
        User uFollowed = userId(user_id_to_unfollow);
        uFollowed.unfollow(user_id_to_unfollow);
    }

    @Override
    public List<Publication> recentPublication(Integer user_id) {
        LocalDate now = LocalDate.now();
        return userList.get(user_id).getPublication().stream()
                .map(this.publicationList::get).filter(i ->
                        DAYS.between(i.getDate(), now) < 15)
                .collect(Collectors.toList());
    }
}
