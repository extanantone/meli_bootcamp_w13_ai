package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    List<User> usuarios = new ArrayList<>();

    public UserRepositoryImpl() {
        usuarios.add(new User(1L, "ftalgiero") );
        usuarios.add(new User(2L, "teclafarias") );
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
    public Boolean unfollow(int user_id, int id_to_unfollow) throws Exception {
        User usr = this.getById(user_id);
        User toUnfollow = this.getById(id_to_unfollow);
        if (usr == null || toUnfollow == null ) throw new Exception();
        usr.getSeguidos().removeIf(us -> us == id_to_unfollow);
        return toUnfollow.getSeguidores().removeIf(us -> us == user_id);
    }

    @Override
    public User getById(int id) {
        return this.usuarios.stream().filter(user -> user.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> getFollowers(int id) throws Exception {
        User usr = this.getById(id);
        if(usr == null) throw new Exception();
        List<User> followers = new ArrayList<>();
        for (Long u: usr.getSeguidores()
             ) {
            followers.add(this.getById(Math.toIntExact(u)));
        }
        return followers;
    }

    @Override
    public List<User> getFolloweds(int user_id) throws Exception {
        User usr = this.getById(user_id);
        if(usr == null) throw new Exception();
        List<User> followeds = new ArrayList<>();
        for (Long u: usr.getSeguidos()
        ) {
            followeds.add(this.getById(Math.toIntExact(u)));
        }
        return followeds;    }

    @Override
    public Boolean savePost(Long idPost, Long idUser) throws Exception {
        User usr = this.getById(Math.toIntExact(idUser));
        if (usr == null) throw new Exception();
        usr.getProducts().add(idPost);
        return true;
    }

}
