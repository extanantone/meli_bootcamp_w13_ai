package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;
import java.util.List;

public interface PostRepositoryInterface {
    Post setPost(Post post);
    Post getPosts(Integer idPost);
    List<Post> getPostFromUsersId(List<Integer> usersId);
    List<Post> getPostFromUserId(Integer userId);
    List<Post> getPromoPostFromUserId(Integer userId);
}
