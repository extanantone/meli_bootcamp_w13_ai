package com.example.SocialMeli.repository;

import com.example.SocialMeli.exceptions.DuplicatePostException;
import com.example.SocialMeli.exceptions.FollowException;
import com.example.SocialMeli.exceptions.UserNotFoundException;
import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;

@Repository
public class SocialRepository implements ISocialRepository{

    List<User> usuarios;

    public SocialRepository() {
        this.usuarios = loadUsers();
    }

    protected List<User> loadUsers(){
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

    public User getUser(int userId){
        return this.usuarios.stream()
                .filter(u -> u.getUserId()==userId)
                .findFirst()
                .orElseThrow(() ->
                        new UserNotFoundException("Usuario "+userId+" no encontrado")
                );
    }

    @Override
    public void followUser(int userId, int userIdToFollow) {
        User user = this.getUser(userId);
        User userToFollow = this.getUser(userIdToFollow);

        if(user.getFollowers().contains(userToFollow)){
            throw new FollowException("El usuario "+userId+" ya esta siguiendo a "+userToFollow);
        }

        user.addFollowed(userToFollow);
        userToFollow.addFollower(user);

    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        User user = this.getUser(userId);
        User userToUnfollow = this.getUser(userIdToUnfollow);
        if(!user.getFollowed().contains(userToUnfollow)){
            throw new FollowException("El usuario "+userId+" no esta siguiendo a "+userIdToUnfollow);
        }
        user.getFollowed().remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(user);

    }

    @Override
    public void createPublication(int userId, Publication publication) {
        User user = this.getUser(userId);
        Publication publi = user.getPosts().stream()
                .filter(pub -> pub.getIdPost()==publication.getIdPost())
                .findFirst()
                .orElse(null);

        if(publi != null){
            throw new DuplicatePostException("Ya existe una publicación con el ID "+publication.getIdPost());
        }
        user.addPublication(publication);
    }

    @Override
    public List<User> getUsers() {
        return usuarios;
    }
}
