package com.example.socialmeli.repository.product.post;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;

import java.util.List;
import java.util.Map;

public interface IPostRepository
{
    Map<Integer, Post> postMap();

    List<Post> findTwoWeeksBeforeOrderByDateDesc(Integer userId);

    List<Post> findTwoWeeksBeforeOrderByDateAsc(Integer userId);

    boolean addPost(Post post);
}
