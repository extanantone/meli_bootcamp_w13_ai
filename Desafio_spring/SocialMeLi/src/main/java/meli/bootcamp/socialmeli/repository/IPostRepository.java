package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.UserFollow;

import java.util.List;

public interface IPostRepository {
    //Metodos para generar CRUD al repo
    void addPost(Post newPost);
    Post findPostById(int postID);
    List<Post> findAll();
    Post updatePostById(int postID);
    void deletePost(int postID);
    String getPostNameById(int postID);
    List<Post> getAllList();
    public List<Post> findSortedByDatePostsByUserID(int userID);

}
