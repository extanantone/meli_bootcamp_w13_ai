package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.PromoPost;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements  IUserRepository{

    List<Seguidor> seguidors = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Post> posts = new ArrayList<>();
    List<PromoPost> promoPosts = new ArrayList<>();

    public UserRepository() {

        users.add(new User(1,"Juan"));
        users.add(new User(2,"Manuel"));
        users.add(new User(3,"Julian"));
        users.add(new User(4,"Carlos"));

    }

    @Override
    public void setUser(User user) {
        users.add(user);
    }

    @Override
    public Seguidor setSeguidor(Seguidor seguidor) {
        seguidors.add(seguidor);
        return  seguidor;
    }

    @Override
    public boolean getExisteSeguidor(int idseguidor, int idseguido) {
        return seguidors.stream()
                .filter(seguidor -> seguidor.getIdSeguido()==idseguido && seguidor.getIdSeguidor()==idseguidor)
                .count() > 0?  true : false;
    }

    @Override
    public User getUser(int id) {
        if(users.stream().filter(user -> user.getUserId() == id).count() >0){
          return users.stream().filter(user1 -> user1.getUserId()==id).findFirst().get();
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

            if(users.get(i).getUserId()==id){
                User user = new User(users.get(i).getUserId(),users.get(i).getUserName());
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
        if(posts.stream().filter(post -> post.getUserId()==id).count()>0){
            return posts.stream().filter(post -> post.getUserId()==id).findFirst().get();
        }
        return null;
    }

    @Override
    public List<Post> getPosts(int id) {

        return posts.stream().filter(post -> post.getUserId()==id).collect(Collectors.toList());
    }

    @Override
    public void setpromopost(PromoPost post) {
        promoPosts.add(post);
    }

    @Override
    public PromoPost getPromoPost(int id) {
        return promoPosts.stream().filter(post -> post.getIdPost()==id).findFirst().get();
    }

    @Override
    public List<PromoPost> getlistPromopost(int id) {
        return promoPosts.stream().filter(post -> post.getUserId() == id).collect(Collectors.toList());
    }
}
