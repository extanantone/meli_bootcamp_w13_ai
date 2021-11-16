package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class PostRepository {
    private Map<Integer, Post> posts = new HashMap<Integer, Post>();

    public Post getPosts(Integer id_post) {
        return posts.get(id_post);
    }

    public Post setPost(Post post){
        this.posts.put(post.getPost_id(),post);
        return post;
    }

    public List<Post> getPostFromUsersId(List<Integer> users_id){
        List<Post> postList = new ArrayList<>();
        posts.forEach((id_post,post)->{
            LocalDate now = LocalDate.now();
            if((users_id.contains(post.getUser_id()) && (ChronoUnit.DAYS.between(post.getDate(), now) < 15))){
                postList.add(post);
            }
        });
        return postList;
    }

    public List<Post> getPostFromUserId(Integer user_id){
        List<Post> postList = new ArrayList<>();
        posts.forEach((id_post,post)->{
            if(user_id == post.getUser_id()){
                postList.add(post);
            }
        });
        return postList;
    }

    public List<Post> getPromoPostFromUserId(Integer user_id){
        List<Post> postList = new ArrayList<>();
        posts.forEach((id_post,post)->{
            System.out.println(post.getHas_promo());

            if((user_id == post.getUser_id()) && (post.getHas_promo())){

                postList.add(post);
            }
        });
        return postList;
    }
}
