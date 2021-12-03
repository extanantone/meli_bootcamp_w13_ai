
package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;

import java.util.List;

public interface ProductRepository {
    void post(Post newPost);
    List<Post> getAllPosts();
    List<Post> getPostsById(int userId);
    List<Post> getPostListFrom2WeeksAgoAsc(int userId);
    List<Post> getPostListFrom2WeeksAgoDesc(int userId);

}
