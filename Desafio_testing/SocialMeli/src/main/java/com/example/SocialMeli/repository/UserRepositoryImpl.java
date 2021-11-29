package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    List<User> usuarios = new ArrayList<>();

    public UserRepositoryImpl() {
        usuarios.add(new User(1L, "ftagliero") );
        usuarios.add(new User(2L, "juangomez") );
        usuarios.add(new User(3L, "marianop") );
        usuarios.add(new User(4L, "carlitosauzqui") );
    }

    @Override
    public Boolean saveFollow(int id, int toFollow) {
        User usuario = this.getById(id);
        this.getById(toFollow).getSeguidores().add((long) id);
        return usuario.getSeguidos().add((long) toFollow);
    }

    @Override
    public Boolean unfollow(int user_id, int id_to_unfollow) {
        User usr = this.getById(user_id);
        User toUnfollow = this.getById(id_to_unfollow);
        usr.getSeguidos().removeIf(us -> us == id_to_unfollow);
        return toUnfollow.getSeguidores().removeIf(us -> us == user_id);
    }

    @Override
    public User getById(int id) {
        return this.usuarios.stream().filter(user -> user.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> getFollowers(int id) {
        User usr = this.getById(id);
        List<User> followers = new ArrayList<>();
        for (Long u: usr.getSeguidores()
             ) {
            followers.add(this.getById(Math.toIntExact(u)));
        }
        return followers;
    }

    @Override
    public List<User> getFolloweds(int user_id) {
        User usr = this.getById(user_id);
        List<User> followeds = new ArrayList<>();
        for (Long u: usr.getSeguidos()
        ) {
            followeds.add(this.getById(Math.toIntExact(u)));
        }
        return followeds;    }

    @Override
    public Boolean savePost(Integer idPost, Integer idUser) {
        User usr = this.getById(Math.toIntExact(idUser));
        usr.getProducts().add(Long.valueOf(idPost));
        return true;
    }

}
