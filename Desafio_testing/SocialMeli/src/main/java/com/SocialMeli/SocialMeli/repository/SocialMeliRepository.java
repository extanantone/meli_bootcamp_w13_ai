package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.model.Buyer;
import com.SocialMeli.SocialMeli.model.Post;
import com.SocialMeli.SocialMeli.model.Seller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Getter
@Repository
public class SocialMeliRepository implements ISocialMeliRepository {
        List<Buyer> buyers;
        List<Seller> sellers;


    SocialMeliRepository() {
        this.buyers = ListBuyers();
        this.sellers = ListSellers();
    }

    @Override
        public List<Buyer> ListBuyers() {
            File file = null;
            try {
                file = ResourceUtils.getFile("classpath:buyers.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Buyer>> typeRef = new TypeReference<>() {};
            List<Buyer> buyers = null;
            try {
                buyers = objectMapper.readValue(file, typeRef);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buyers;
        }

        @Override
        public List<Seller> ListSellers() {
            File file = null;
            try {
                file = ResourceUtils.getFile("classpath:buyers.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Seller>> typeRef = new TypeReference<>() {};
            List<Seller> sellers = null;
            try {
                sellers = objectMapper.readValue(file, typeRef);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sellers;
        }


    @Override
    public boolean follow (Buyer buy, Seller sell){
        sell.getFollowers().add(buy);
        buy.getFollowed().add(sell);
        return true;
    }

    @Override
    public Buyer searchBuyer(int id) {
        return this.buyers.stream().filter(p -> p.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public Seller searchSeller(int id) {
        return this.sellers.stream().filter(p -> p.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public Optional<Buyer> searchFollower(List<Buyer>followers, int id_Buyer){
            return followers.stream().filter(p -> p.getUser_id() == id_Buyer).findFirst();
    }

    @Override
    public boolean post(Seller sell, Post post){
        sell.getPosts().add(post);

        return true;
    }

    @Override
    public Optional<Post> searchPost(List<Post> post , int id_post){
        return post.stream().filter(p -> p.getId_post() == id_post).findFirst();
    }


    @Override
    public boolean unfollow (Buyer buy, Seller sell){
        sell.getFollowers().remove(buy);
        buy.getFollowed().remove(sell);
        return true;
    }



}
