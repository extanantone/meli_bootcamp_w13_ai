package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Post;
import com.bootcamp.socialmeli.entitiy.Seller;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SocialMeliRepositoryImpl implements ISocialMeliRepository {

    private Map<Integer, Purchaser> purchasers;
    private Map<Integer, Seller> sellers;

    public SocialMeliRepositoryImpl() {

        this.purchasers = new HashMap<>();
        this.sellers = new HashMap<>();
        purchasers.put(1,new Purchaser(1,"juan525c"));
        purchasers.put(2,new Purchaser(2,"andres747c"));
        purchasers.put(3,new Purchaser(3,"brian8474c"));
        sellers.put(4,new Seller(4,"Lucas323v"));
        sellers.put(5,new Seller(5,"David323v"));

    }

    @Override
    public Purchaser getPurchaser(Integer purchaserId) {
        return purchasers.get(purchaserId);
    }

    @Override
    public Seller getSeller(Integer sellerId) {
        return sellers.get(sellerId);
    }

    @Override
    public boolean follow(Integer purchaserId, Integer sellerId) {

        if(!purchasers.containsKey(purchaserId) || !sellers.containsKey(sellerId)) {
            return false;
        }else{
            Purchaser purchaser = purchasers.get(purchaserId);
            purchaser.addFollowed(sellerId);

            Seller seller = sellers.get(sellerId);
            seller.addFollower(purchaserId);

            return true;
        }

    }

    @Override
    public boolean unFollow(Integer purchaserId, Integer sellerId) {

        if(!purchasers.containsKey(purchaserId) || !sellers.containsKey(sellerId)) {
            return false;
        }else{
            Purchaser purchaser = purchasers.get(purchaserId);
            purchaser.deleteFollowed(sellerId);

            Seller seller = sellers.get(sellerId);
            seller.deleteFollower(purchaserId);
            return true;
        }

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
    public List<Seller> gerPurchaserFollowed(Integer purchaserId) {
        var s = purchasers.get(purchaserId).getFollowed();
        List<Seller> followed = new ArrayList<>();
        s.stream().forEach(e->{
            followed.add(sellers.get(e));
        });
        return followed;
    }

//    @Override
//    public Optional<Integer> getFollowerCountPerSeller(Integer sellerId) {
//        return (sellers.containsKey(sellerId))
//                ? Optional.of(sellers.get(sellerId).getFollowers().size())
//                :Optional.empty();
//    }
}
