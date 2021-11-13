package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Seguidor> getSegidor() {
        return seguidors;
    }

    @Override
    public void setPost(Post post) {
        posts.add(post);
    }

    @Override
    public Post getPost(int id) {

        if(posts.stream().filter(post -> post.getIdPost()==id).count()>0){
            return posts.stream().filter(post -> post.getIdPost()==id).findFirst().get();
        }
        return null;
    }

    @Override
    public void cambiarTipo(int id) {

        for (int i=0 ; i < users.size();i++ ){

            if(users.get(i).getId()==id){
                User user = new User(users.get(i).getId(),users.get(i).getUserName());
                user.setTipo("Vendedor");
                users.remove(i);
                users.add(i,user);
                break;
            }
        }
    }

    @Override
    public void dejarDeSeguir(int idSeguidor, int idSeguido) {

        for (int i=0 ; i < seguidors.size();i++ ){

            if(seguidors.get(i).getIdSeguidor()==idSeguidor && seguidors.get(i).getIdSeguido()==idSeguido){
                seguidors.remove(i);
               break;
            }
        }
    }

    @Override
    public Post getPotsidUser(int id) {
        if(posts.stream().filter(post -> post.getIdUser()==id).count()>0){
            return posts.stream().filter(post -> post.getIdUser()==id).findFirst().get();
        }
        return null;
    }

    @Override
    public List<Post> getPosts(int id) {

        return posts.stream().filter(post -> post.getIdUser()==id).collect(Collectors.toList());
    }
}
