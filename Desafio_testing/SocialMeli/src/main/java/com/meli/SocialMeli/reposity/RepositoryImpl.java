package com.meli.SocialMeli.reposity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Promo;
import com.meli.SocialMeli.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements IRepository {
    private HashMap<Integer, User> database;
    private List<Post> databasePost;
    private List<Promo> databasePromo;

    public RepositoryImpl() {
        database = loadDataBase();
        databasePost = new LinkedList<>();
        databasePromo = new LinkedList<>();
    }

    private HashMap<Integer, User> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:Users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> listUser = new LinkedList<>();
        try {
            listUser = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<Integer, User> usersHash = new HashMap<>();
        if(listUser.size()>0){
            for(User user:listUser)
                usersHash.put(user.getUserId(),user);
        }

        return usersHash;
    }

    @Override
    public User findUser(int idUser) {
        return database.get(idUser);
    }


    @Override
    public boolean containFollower(int idUserFollow, int idUser) {
        return findUser(idUser).getFollowers().stream().anyMatch(p->p.getUserId()==idUserFollow);
    }

    @Override
    public List<User> listFollowers(int idUser) {
        return findUser(idUser).getFollowers();
    }

    @Override
    public void addFollower(int idUser, int idUserFollower) {
        User user = findUser(idUser);
        User userFollower = findUser(idUserFollower);
        List<User> follower = user.getFollowers();
        List<User> followed = userFollower.getFollowed();
        follower.add(userFollower);
        followed.add(user);
        user.setFollowers(follower);
        userFollower.setFollowed(followed);
        database.put(idUser, user);
        database.put(idUserFollower, userFollower);
    }

    @Override
    public List<User> listFollowed(int idUser) {
        return findUser(idUser).getFollowers();
    }

    @Override
    public void addPost(Post post) {
        databasePost.add(post);
    }

    @Override
    public List<Post> listPostUsr(int userId) {
        List<Post> post = databasePost.stream().filter(p-> p.getUserId()==userId).collect(Collectors.toUnmodifiableList());
        return post;
    }

    public boolean containPost(int idPost){
        return databasePost.stream().anyMatch(p->p.getIdPost()==idPost);
    }

    public boolean containProduct(int userId, int idProduct){
        return databasePost.stream().filter(p-> p.getUserId()==userId).anyMatch(p->p.getDetail().getProductId()==idProduct);
    }

    @Override
    public void unfollow(int idUser, int idUserFollower) {
        User usr = findUser(idUser);
        List<User> followers = usr.getFollowers();
        User follow = findUser(idUserFollower);
        List<User> followed = follow.getFollowers();
        followers.remove(follow);
        followed.remove(usr);
        usr.setFollowers(followers);
        follow.setFollowed(followed);
        database.put(idUser, usr);
        database.put(idUserFollower, follow);
    }

    @Override
    public void addPromo(Promo promo) {
        databasePromo.add(promo);
    }

    @Override
    public List<Promo> listPromoUsr(int userId) {
        List<Promo> promo = databasePromo.stream().filter(p-> p.getUserId()==userId).collect(Collectors.toUnmodifiableList());
        return promo;
    }

    @Override
    public boolean containPromo(int idPostPromo) {
        return databasePromo.stream().anyMatch(p->p.getIdPost()==idPostPromo);
    }

    @Override
    public boolean containProductPromo(int userId, int idProductPromo) {
        return databasePromo.stream().filter(p-> p.getUserId()==userId).anyMatch(p->p.getDetail().getProductId()==idProductPromo);
    }
}
