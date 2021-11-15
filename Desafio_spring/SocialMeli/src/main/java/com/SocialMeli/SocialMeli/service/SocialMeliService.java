package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.exceptions.NotFoundException;
import com.SocialMeli.SocialMeli.model.*;
import com.SocialMeli.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SocialMeliService implements ISocialMeliService {

    @Autowired
    ISocialMeliRepository SmRepository;


    public ResponseUserDTO follow(int id_buyer, int id_seller) throws NotFoundException {
        ResponseUserDTO response = new ResponseUserDTO();
        Buyer buyer = checkBuyer(id_buyer);
        Seller seller = checkSeller(id_seller);
        Optional<Buyer> follow = SmRepository.searchFollower(seller.getFollowers(),id_buyer);
        if(follow == null || follow.isEmpty()){
            SmRepository.follow(buyer,seller);
            response.setMsg("The buyer " + id_buyer + " has successfully followed the seller " + id_seller);
            response.setStatusCode(200);
        }else{
            throw new NotFoundException("The buyer " + id_buyer + " was already following the seller " + id_seller);
        }
        return response;
        }


    public Buyer checkBuyer(int id) throws NotFoundException {
        Buyer buy = SmRepository.searchBuyer(id);
        if (buy == null) {
            throw new NotFoundException("The buyer id " + id + " is invalid");
        }
        return buy;
    }

    public Seller checkSeller(int id) throws NotFoundException {
        Seller sell = SmRepository.searchSeller(id);
        if (sell == null) {
            throw new NotFoundException("The seller id " + id + " is invalid");
        }
        return sell;
    }

    public CountFollowDTO count(int id_seller) throws NotFoundException {
        CountFollowDTO count = new CountFollowDTO();
        Seller seller = checkSeller(id_seller);
        count.setUser_id(id_seller);
        count.setUser_name(seller.getUser_name());
        count.setFollowers_count(seller.getFollowers().size());
        return count;
    }

    public FollowersDTO searchFollower(int id_seller) throws NotFoundException {
        FollowersDTO followers = new FollowersDTO();
        Seller seller = checkSeller(id_seller);
        followers.setUser_id(id_seller);
        followers.setUser_name(seller.getUser_name());
        List <BuyersFollowedDTO> buyersFollow = new ArrayList<>();
        for (Buyer a : seller.getFollowers()){
            buyersFollow.add((new BuyersFollowedDTO(a.getUser_id(), a.getUser_name())));
        }
        followers.setFollowers(buyersFollow);
        return followers;
    }

    public FollowedDTO searchFollowed(int id_buyer) throws NotFoundException {
        FollowedDTO followed = new FollowedDTO();
        Buyer buyer = checkBuyer(id_buyer);
        followed.setUser_id(id_buyer);
        followed.setUser_name(buyer.getUser_name());
        List <SellersFollowedDTO> sellersFollowed = new ArrayList<>();
        for (Seller a : buyer.getFollowed()){
            sellersFollowed.add(new SellersFollowedDTO(a.getUser_id(),a.getUser_name()));
        }
        followed.setFollowers(sellersFollowed);
        return followed;

    }

    public ResponseUserDTO createPost (PostDTO post) throws NotFoundException {
        ResponseUserDTO response = new ResponseUserDTO();
        Seller sell = checkSeller(post.getUser_id());
        ProductDTO product = new ProductDTO(post.getDetail().getProduct_id(), post.getDetail().getProduct_name(), post.getDetail().getType(), post.getDetail().getBrand(),
                post.getDetail().getColor(), post.getDetail().getNotes());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date = LocalDate.parse(post.getDate(), format);
        Post posting = new Post(post.getUser_id(),post.getId_post(),date,product,post.getCategory(), post.getPrice());
        Optional<Post> searchPost = SmRepository.searchPost(sell.getPosts(), post.getId_post());
        if(searchPost == null || searchPost.isEmpty()){
            SmRepository.post(sell,posting);
            response.setMsg("User id " + post.getUser_id() + " The post id " + post.getId_post() + " was added");
            response.setStatusCode(200);
        }else{
            throw new NotFoundException("User id " + post.getUser_id() + " The post id " + post.getId_post() + " it was already added");
        }
        return response;

    }

}

