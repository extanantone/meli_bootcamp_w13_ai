package com.socialmeli.socialmeli.repository;

import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.model.Post;

import java.util.List;

public interface PostRepositoryI {

    String newPost(Post post);
    Post getPost(int user_id);
    boolean postExist(int post_id);
}
