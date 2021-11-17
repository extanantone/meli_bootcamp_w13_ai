package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class PostRepository implements PostRepositoryInterface{
    private Map<Integer, Post> posts = new HashMap<>();

    public Post getPosts(Integer idPost) {
        return posts.get(idPost);
    }
    @Override
    public Post setPost(Post post){
        this.posts.put(post.getPostId(),post);
        return post;
    }
    @Override
    public List<Post> getPostFromUsersId(List<Integer> usersId){
        List<Post> postList = new ArrayList<>();
        posts.forEach((idPost,post)->{
            LocalDate now = LocalDate.now();
            if((usersId.contains(post.getUserId()) && (ChronoUnit.DAYS.between(post.getDate(), now) < 15))){
                postList.add(post);
            }
        });
        return postList;
    }
    @Override
    public List<Post> getPostFromUserId(Integer userId){
        List<Post> postList = new ArrayList<>();
        posts.forEach((idPost,post)->{
            if(userId == post.getUserId()){
                postList.add(post);
            }
        });
        return postList;
    }
    @Override
    public List<Post> getPromoPostFromUserId(Integer userId){
        List<Post> postList = new ArrayList<>();
        posts.forEach((idPost,post)->{
            System.out.println(post.getHasPromo());

            if((userId == post.getUserId()) && (post.getHasPromo())){

                postList.add(post);
            }
        });
        return postList;
    }
}
