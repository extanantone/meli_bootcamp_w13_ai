package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOPostProduct;
import com.bootcamp.socialmeli.DTO.DTOPublishPost;
import com.bootcamp.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {

    boolean addPost(Post post);

    List<Post> getPost(int idUser);

    List<DTOPublishPost> orderPosts(List<DTOPublishPost> posts, String order);

    List<Post> getPromoPost(int userId);

}
