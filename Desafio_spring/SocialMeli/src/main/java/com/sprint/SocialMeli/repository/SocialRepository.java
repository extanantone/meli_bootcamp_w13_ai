package com.sprint.SocialMeli.repository;

import com.sprint.SocialMeli.model.Buyer;
import com.sprint.SocialMeli.model.Post;
import com.sprint.SocialMeli.model.Seller;
import com.sprint.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
        Buyer buyer1 = new Buyer(0, "Pepe");
        Buyer buyer2 = new Buyer(1, "Brenda");
//        Post post1 = new Post(3, 0, LocalDate.now(), 45, "Plancha para ropa", "Electro", "Eterna", "Blanco", "Una plaaanchaza", 23, 3400D, false, 0D);
        Seller seller1 = new Seller(2, "Cacho");
        Seller seller2 = new Seller(3, "Petunia");

//        seller2.addPost(post1.getId_post());
//        seller1.addFollower(buyer1.getUser_id());
//        seller1.addFollower(buyer2.getUser_id());
//        buyer1.addFollowed(seller1.getUser_id());
//        buyer2.addFollowed(seller1.getUser_id());

        users.put(buyer1.getUser_id(), buyer1);
        users.put(buyer2.getUser_id(), buyer2);
        users.put(seller1.getUser_id(), seller1);
        users.put(seller2.getUser_id(), seller2);
//        posts.put(post1.getId_post(), post1);
    }

    public boolean existsUser(int user_id){
        return users.containsKey(user_id);
    }

    public boolean existsPost(int id_post){
        return posts.containsKey(id_post);
    }

    public User getUser(int user_id){
        return users.get(user_id);
    }

    public void putUser(User user){
        users.put(user.getUser_id(), user);
    }

    public void putPost(Post post){
        posts.put(post.getId_post(), post);
    }

    @Override
    public Post getPost(int id_post) {
        return posts.get(id_post);
    }


}
