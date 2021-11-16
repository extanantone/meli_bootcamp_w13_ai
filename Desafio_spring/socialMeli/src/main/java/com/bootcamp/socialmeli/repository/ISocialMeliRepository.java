package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Post;
import com.bootcamp.socialmeli.entitiy.Seller;

import java.util.List;
import java.util.Optional;

public interface ISocialMeliRepository {

    Optional<Purchaser> getPurchaser(Integer purchaserId);

    Optional<Seller> getSeller(Integer sellerId);

    void follow(Integer purchaserId, Integer sellerId);

    void unFollow(Integer purchaserId, Integer sellerId);

    List<Purchaser> getSellerFollowers(Integer sellerId);

    List<Seller> gerPurchaserFollowed(Integer purchaserId);

    void createNewPost (Integer sellerId, Post post);

    List<Post> getSellersPosts (Integer purchaserId);


}
