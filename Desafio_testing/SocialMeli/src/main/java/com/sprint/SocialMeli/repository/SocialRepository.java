package com.sprint.SocialMeli.repository;

import com.sprint.SocialMeli.model.Buyer;
import com.sprint.SocialMeli.model.Post;
import com.sprint.SocialMeli.model.Seller;
import com.sprint.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SocialRepository implements ISocialRepository{
    Map<Integer, User> users;
    Map<Integer, Post> posts;

    public SocialRepository(){
        users = new HashMap<>();
        posts = new HashMap<>();

        // Inicialización de datos del repositorio para poder realizar algunas pruebas
        Buyer buyer1 = new Buyer(1, "Pepe");
        Buyer buyer2 = new Buyer(2, "Brenda");
//        Post post1 = new Post(3, 1, LocalDate.now(), 45, "Plancha para ropa", "Electro", "Eterna", "Blanco", "Una plaaanchaza", 23, 3400D, false, 0D);
        Seller seller1 = new Seller(3, "Cacho");
        Seller seller2 = new Seller(4, "Petunia");

//        seller2.addPost(post1.getIdPost());
//        seller1.addFollower(buyer1.getUserId());
//        seller1.addFollower(buyer2.getUserId());
//        buyer1.addFollowed(seller1.getUserId());
//        buyer2.addFollowed(seller1.getUserId());

        users.put(buyer1.getUserId(), buyer1);
        users.put(buyer2.getUserId(), buyer2);
        users.put(seller1.getUserId(), seller1);
        users.put(seller2.getUserId(), seller2);
//        posts.put(post1.getIdPost(), post1);
    }

    public boolean existsUser(int userId){
        return users.containsKey(userId);
    }

    public boolean existsPost(int idPost){
        return posts.containsKey(idPost);
    }

    public User getUser(int userId){
        return users.get(userId);
    }

    public void putUser(User user){
        users.put(user.getUserId(), user);
    }

    public void createPost(Post post){
        posts.put(post.getIdPost(), post);
    }

    @Override
    public Post getPost(int idPost) {
        return posts.get(idPost);
    }


}
