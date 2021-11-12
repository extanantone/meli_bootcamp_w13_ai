package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements  IUserRepository{

    List<Seguidor> seguidors = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Post> posts = new ArrayList<>();

    public UserRepository() {

        users.add(new User(1,"User1"));
        users.add(new User(2,"User2"));
        users.add(new User(3,"User3"));
        users.add(new User(4,"User4"));

    }

    @Override
    public Seguidor setSeguidor(Seguidor seguidor) {

        seguidors.add(seguidor);
        return  seguidor;
    }

    @Override
    public User getUser(int id) {
        if(users.stream().filter(user -> user.getId() == id).count() >0){

          return users.stream().filter(user1 -> user1.getId()==id).findFirst().get();



        }
         return null;
    }
}
