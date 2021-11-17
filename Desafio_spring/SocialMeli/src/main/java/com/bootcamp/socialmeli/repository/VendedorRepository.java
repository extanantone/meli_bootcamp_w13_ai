package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Promotion;
import com.bootcamp.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Repository
public class VendedorRepository implements IVendedorRepository {

    private HashMap<Long, User> users;
    private HashMap<Long, Post> post;

    public VendedorRepository() {

        //TODO: Read from json
        //this.users = openUserJson();
        this.users = new HashMap<>();
        this.post = new HashMap<>();
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
        return this.users.get(idUser).getFollowers().stream().map(this.users::get).
                collect(Collectors.toList());
    }

    @Override
    public List<User> getFolloweds(Long idUser) {
        return this.users.get(idUser).getFollowed().stream().map(this.users::get).
                collect(Collectors.toList());
    }

    // US0001
    @Override
    public void addFollow(Long idFollower, Long idFollowed) {
        User newFollower = this.users.get(idFollower);
        newFollower.addFollowed(idFollowed);
        User newFollowed = this.users.get(idFollowed);
        newFollowed.addFollower(idFollower);
    }

    @Override
    public void addPostToUser(Long idUser, Post post) {
        this.users.get(idUser).addNewPost(post.getIdPost());
        this.post.put(post.getIdPost(),post);
    }

    @Override
    public List<Post> getRecentPosts(Long idUser) {
        LocalDate now = LocalDate.now();
        return this.users.get(idUser).getPosts().stream().map(
                        this.post::get).filter(p -> DAYS.between(p.getDate(), now) < 14).
                collect(Collectors.toList());
    }

    // US 0007
    @Override
    public void unFollow(Long idFollower, Long idFollowed) {
        User Follower = this.users.get(idFollower);
        Follower.unFollowed(idFollowed);
        User Followed = this.users.get(idFollowed);
        Followed.removeFollower(idFollower);
    }


    // US 0011
    @Override
    public List<Post> getPromoPosts(Long idUser) {
        return this.users.get(idUser).getPosts().stream().map(this.post::get).
                filter(Post::isHasPromo).collect(Collectors.toList());
    }

}
