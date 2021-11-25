package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Post;

public interface IPostRepository {

    public Post getPost(long id);
    public Post createPost(Post post);
}
