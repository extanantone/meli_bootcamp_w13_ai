package com.socialmeli.demo.repository;

import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;
import com.socialmeli.demo.model.Post;

import java.util.List;

public interface IPostRepository {

    public Post createPost(Post post);
    public Post findPostById(Integer id);
    public List<Post> getPosts();
}
