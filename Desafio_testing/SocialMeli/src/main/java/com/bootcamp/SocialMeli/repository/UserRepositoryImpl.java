package com.bootcamp.SocialMeli.repository;
import com.bootcamp.SocialMeli.entity.Buyer;
import com.bootcamp.SocialMeli.entity.Post;
import com.bootcamp.SocialMeli.entity.Seller;
import com.bootcamp.SocialMeli.exception.ExceptionAlreadyFollows;
import com.bootcamp.SocialMeli.exception.ExceptionBuyerNotExist;
import com.bootcamp.SocialMeli.exception.ExceptionSameUser;
import com.bootcamp.SocialMeli.exception.ExceptionSellerNotExist;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    List<Seller> sellers;
    List<Buyer> buyers;
    List<Post> posts;

    public UserRepositoryImpl() {
        sellers = new ArrayList<>();
        buyers = new ArrayList<>();
        posts = new ArrayList<>();
        loadInitialData();
    }

    private void loadInitialData() {
        Buyer user1 = new Buyer(1, "Juan David");
        Buyer user2 = new Buyer(2, "Fabian Andres");
        Seller user3 = new Seller(3, "Flamingo");
        Seller user4 = new Seller(4, "Homecenter");
        buyers.add(user1);
        buyers.add(user2);
        sellers.add(user3);
        sellers.add(user4);
    }

    @Override
    public List<Seller> getSellersList() {
        return sellers;
    }

    @Override
    public List<Buyer> getBuyersList() {
        return buyers;
    }

    @Override
    public List<Post> getPostsList() {
        return posts;
    }

    @Override
    public Seller findSellerById(int userId) {
        return sellers.stream().filter
                        (user -> user.getUserId() == userId)
                .findFirst().orElseThrow(()
                        -> new ExceptionSellerNotExist(Integer.toString(userId)));
    }

    @Override
    public Buyer findBuyerById(int userId) {
        return buyers.stream().filter
                        (user -> user.getUserId() == userId)
                .findFirst().orElseThrow(()
                        -> new ExceptionBuyerNotExist(Integer.toString(userId)));
    }

    @Override
    public void follow(Buyer buyer, Seller seller) {
        if (!seller.getFollowers().contains(buyer)) {
            buyer.getFollowed().add(seller);
            seller.getFollowers().add(buyer);
        } else {
            throw new ExceptionAlreadyFollows(Integer.toString(buyer.getUserId()));
        }
    }


    @Override
    public void newPost(Seller seller, Post newPost) {
        seller.getPost().add(newPost);
        posts.add(newPost);
    }

    @Override
    public void unFollow(Buyer buyer, Seller seller) {
        seller.getFollowers().remove(buyer);
        buyer.getFollowed().remove(seller);
    }


}













