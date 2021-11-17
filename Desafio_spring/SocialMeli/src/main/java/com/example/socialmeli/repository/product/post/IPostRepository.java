package com.example.socialmeli.repository.product.post;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;

import java.util.List;
import java.util.Map;

public interface IPostRepository
{
    Map<Integer, Post> postMap();

    List<Post> findFollowedTwoWeeksBeforeOrderByDateDesc(Integer userId);

    List<Post> findFollowedTwoWeeksBeforeOrderByDateAsc(Integer userId);

    boolean createPost(Post post);

    List<Post> findPromoPosts(Integer userId);

    List<Post> findPromoPostOrderByProductNameAsc(Integer userId);

    List<Post> findPromoPostsOrderByProductNameDesc(Integer userId);
}
