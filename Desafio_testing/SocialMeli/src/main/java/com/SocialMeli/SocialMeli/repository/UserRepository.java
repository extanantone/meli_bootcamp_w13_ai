package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.entity.Buyer;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{
    protected Map<Integer, User> users = new HashMap<>();

    public UserRepository(){
        Buyer buyer1 = new Buyer(1, "Buyer1", new HashMap<>());
        Buyer buyer2 = new Buyer(2, "Buyer2", new HashMap<>());
        Seller seller1 = new Seller(3, "Seller1", new HashMap<>(), new HashMap<>());
        Seller seller2 = new Seller(4, "Seller2", new HashMap<>(), new HashMap<>());

        /*Map<Integer, User> sellers = new HashMap<>();
        sellers.put(seller1.getId(), seller1);
        buyer2.setFollowed(sellers);
        sellers.put(seller2.getId(), seller2);

        Map<Integer, User> buyers = new HashMap<>();
        buyers.put(buyer1.getId(), buyer1);
        buyers.put(buyer2.getId(), buyer2);

        seller1.setFollowers(buyers);
        buyer1.setFollowed(sellers);*/

        users.put(1, buyer1);
        users.put(2, buyer2);
        users.put(3, seller1);
        users.put(4, seller2);
    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public boolean addFollower(int userId, int sellerId) {
        Seller seller = (Seller)this.users.get(sellerId);
        seller.getFollowers().put(userId, this.users.get(userId));
        User follower = this.users.get(userId);
        follower.getFollowed().put(sellerId, this.users.get(sellerId));
        return true;
    }

    @Override
    public Map<Integer, User> getFollowers(int sellerId) {
        Seller seller = (Seller)this.users.get(sellerId);
        return seller.getFollowers();
    }

    @Override
    public Map<Integer, User> getFollowed(int buyerId) {
        User seller = this.users.get(buyerId);
        return seller.getFollowed();
    }

    @Override
    public boolean unFollowSeller(int userId, int sellerId) {
        Seller seller = (Seller)this.users.get(sellerId);
        seller.getFollowers().remove(userId);

        User follower = this.users.get(userId);
        follower.getFollowed().remove(sellerId);

        return true;
    }
}
