package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.model.Buyer;
import com.SocialMeli.SocialMeli.model.Post;
import com.SocialMeli.SocialMeli.model.Seller;

import java.util.List;
import java.util.Optional;

public interface ISocialMeliRepository {
    public List<Buyer> ListBuyers();
    public List<Seller> ListSellers();
    public boolean follow(Buyer buy,Seller sell);
    public Buyer searchBuyer(int id);
    public Seller searchSeller(int id);
    public Optional<Buyer> searchFollower(List<Buyer>followers, int id_Buyer);
    public boolean post(Seller sell, Post post);
    public Optional<Post> searchPost(List<Post> post , int id_post);



}
