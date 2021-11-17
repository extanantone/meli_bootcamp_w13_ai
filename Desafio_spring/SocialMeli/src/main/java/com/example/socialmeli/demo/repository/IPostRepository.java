package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Post;

import java.util.List;

public interface IPostRepository {

    public Post createPost(Post p);

    public List<Post> getPostsFromFollowedUsersSinceTwoWeeks(int userId, String order);

    public List<Post> getPromoPostOfUser(int userId);

    public int countPromoPostOfUser(int userId);

}
