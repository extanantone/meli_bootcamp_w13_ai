package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;

import java.util.List;

public interface IPromoPostRepository {
    //Metodos para generar CRUD al repo
    void addPromoPost(PromoPost newPost);
    Post findPromoPostById(int postID);
    Post updatePromoPostById(int postID);
    void deletePromoPost(int postID);
    List<PromoPost> getAllList();

}
