package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.entity.Buyer;
import com.bootcamp.SocialMeli.entity.Post;
import com.bootcamp.SocialMeli.entity.Seller;


import java.util.List;
import java.util.Optional;


public interface IUserRepository {


    List<Seller> getSellersList();
    List<Buyer> getBuyersList();
    List<Post> getPostsList();
    Seller findSellerById(int userId);
    Buyer findBuyerById(int userId);
    boolean follow(Buyer buyer, Seller seller);
    void newPost(Seller seller, Post newPost);


    boolean unFollow(Buyer buyer, Seller seller);
}
