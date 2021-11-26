package com.bootcamp.socialmeliSprint1.repository;

import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Post;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class SocialMeliRepositoryImpl implements ISocialMeliRepository {

    private Map<Integer, Purchaser> purchasers;
    private Map<Integer, Seller> sellers;

    public SocialMeliRepositoryImpl() {
        this.purchasers = new HashMap<>();
        this.sellers = new HashMap<>();
        purchasers.put(1,new Purchaser(1,"Comprador1"));
        purchasers.put(2,new Purchaser(2,"Comprador2"));
        sellers.put(3,new Seller(3,"Vendedor1"));
        sellers.put(4,new Seller(4,"Vendedor2"));
    }

    @Override
    public Optional<Purchaser> getPurchaser(Integer purchaserId) {
        return (purchasers.containsKey(purchaserId))
                ? Optional.of(purchasers.get(purchaserId))
                : Optional.empty();
    }

    @Override
    public Optional<Seller> getSeller(Integer sellerId) {
        return (sellers.containsKey(sellerId))
                ? Optional.of(sellers.get(sellerId))
                : Optional.empty();
    }

    @Override
    public void follow(Integer purchaserId, Integer sellerId) {
            purchasers.get(purchaserId).addFollowed(sellerId);
            sellers.get(sellerId).addFollower(purchaserId);
    }

    @Override
    public void unFollow(Integer purchaserId, Integer sellerId) {
            purchasers.get(purchaserId).deleteFollowed(sellerId);
            sellers.get(sellerId).deleteFollower(purchaserId);
    }

    @Override
    public List<Purchaser> getSellerFollowers(Integer sellerId) {
        var s = sellers.get(sellerId).getFollowers();
        List <Purchaser> followers = new ArrayList<>();
        s.stream().forEach(e -> {
            followers.add(purchasers.get(e));
        });
        return followers;
    }

    @Override
    public List<Seller> getPurchaserFollowed(Integer purchaserId) {
        var s = purchasers.get(purchaserId).getFollowed();
        List<Seller> followed = new ArrayList<>();
        s.stream().forEach(e->{
            followed.add(sellers.get(e));
        });
        return followed;
    }

    @Override
    public void createNewPost(Integer sellerId, Post post) {
        sellers.get(sellerId).setPost(post);
    }


    @Override
    public List<Post> getSellersPosts(Integer purchaserId) {

        List<Seller> followed = getPurchaserFollowed(purchaserId);

        List<Post> posts = new ArrayList<>();

        for (Seller seller: followed) {
            seller.getPosts().values().forEach(post -> {
                if(post.getDate().isAfter(LocalDate.now().minusWeeks(2))){
                    posts.add(post);
                }
            });
        }
        return posts;
    }

}
