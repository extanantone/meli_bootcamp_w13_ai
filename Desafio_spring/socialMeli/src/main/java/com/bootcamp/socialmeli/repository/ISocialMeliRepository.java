package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Post;
import com.bootcamp.socialmeli.entitiy.Seller;
import com.bootcamp.socialmeli.entitiy.comparator.SortOrder;
import org.springframework.core.annotation.Order;

import java.util.Comparator;
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

    //void getSortedSellerFollowers(List<Purchaser> list,Comparator<?> comparator, SortOrder order);

/*


    List<Purchaser> vendedorFollowersOrderByName (Integer sellerId, String orden);
    List<Seller> compradorFollowedOrderByName (Integer purchaserId, String orden);

    List<Post> postByVendedorOfCompradorOrderByDate (Integer purchaserId, String orden);*/



}
