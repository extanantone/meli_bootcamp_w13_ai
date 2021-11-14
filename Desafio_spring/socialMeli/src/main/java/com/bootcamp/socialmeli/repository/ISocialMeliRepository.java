package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Post;
import com.bootcamp.socialmeli.entitiy.Seller;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ISocialMeliRepository {

    Purchaser getPurchaser(Integer purchaserId);

    Seller getSeller(Integer sellerId);

    void follow(Integer purchaserId, Integer sellerId);

    void unFollow(Integer purchaserId, Integer sellerId);

    List<Purchaser> getSellerFollowers(Integer sellerId);

    List<Seller> gerPurchaserFollowed(Integer purchaserId);

    void createNewPost (Integer sellerId, Post post);

/*
    List<Post> postBySellerOfPurchaser (Integer purchaserId);

    List<Purchaser> vendedorFollowersOrderByName (Integer sellerId, String orden);
    List<Seller> compradorFollowedOrderByName (Integer purchaserId, String orden);

    List<Post> postByVendedorOfCompradorOrderByDate (Integer purchaserId, String orden);*/



}
