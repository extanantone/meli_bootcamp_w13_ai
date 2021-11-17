package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.exceptions.NotFoundException;
import com.SocialMeli.SocialMeli.model.*;
import com.SocialMeli.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;


@Service
public class SocialMeliService implements ISocialMeliService {

    @Autowired
    ISocialMeliRepository SmRepository;


    public ResponseUserDTO follow(int id_buyer, int id_seller) throws NotFoundException {
        ResponseUserDTO response = new ResponseUserDTO();
        Buyer buyer = checkBuyer(id_buyer);
        Seller seller = checkSeller(id_seller);
        Optional<Buyer> follow = SmRepository.searchFollower(seller.getFollowers(), id_buyer);
        if (follow == null || follow.isEmpty()) {
            SmRepository.follow(buyer, seller);
            response.setMsg("The buyer " + id_buyer + " has successfully followed the seller " + id_seller);
            response.setStatusCode(200);
        } else {
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

    public FollowersDTO searchFollower(int id_seller,String order) throws NotFoundException {
        FollowersDTO followers = new FollowersDTO();
        Seller seller = checkSeller(id_seller);
        followers.setUser_id(id_seller);
        followers.setUser_name(seller.getUser_name());
        List<BuyersFollowedDTO> buyersFollow = new ArrayList<>();
        for (Buyer a : seller.getFollowers()) {
            buyersFollow.add((new BuyersFollowedDTO(a.getUser_id(), a.getUser_name())));
        }
        if(order == null ||order.equals("name_asc")){
            followers.setFollowers(buyersFollow.stream().sorted(Comparator.comparing(a->a.getUser_name())).collect(Collectors.toList()));
        }else  if(order.equals("name_desc")){
            followers.setFollowers(buyersFollow.stream().sorted(Collections.reverseOrder(Comparator.comparing(a->a.getUser_name()))).collect(Collectors.toList()));
        }
        return followers;
    }

    public FollowedDTO searchFollowed(int id_buyer,String order) throws NotFoundException {
        FollowedDTO followed = new FollowedDTO();
        Buyer buyer = checkBuyer(id_buyer);
        followed.setUser_id(id_buyer);
        followed.setUser_name(buyer.getUser_name());
        List<SellersFollowedDTO> sellersFollowed = new ArrayList<>();
        for (Seller a : buyer.getFollowed()) {
            sellersFollowed.add(new SellersFollowedDTO(a.getUser_id(), a.getUser_name()));
        }
        if(order == null ||order.equals("name_asc")){
            followed.setFollowed(sellersFollowed.stream().sorted(Comparator.comparing(a->a.getUser_name())).collect(Collectors.toList()));
        }else  if(order.equals("name_desc")){
            followed.setFollowed(sellersFollowed.stream().sorted(Collections.reverseOrder(Comparator.comparing(a->a.getUser_name()))).collect(Collectors.toList()));
        }
        return followed;

    }

    public ResponseUserDTO createPost(PostDTO post) throws NotFoundException {
        ResponseUserDTO response = new ResponseUserDTO();
        Seller sell = checkSeller(post.getUser_id());
        ProductDTO product = new ProductDTO(post.getDetail().getProduct_id(), post.getDetail().getProduct_name(), post.getDetail().getType(), post.getDetail().getBrand(),
                post.getDetail().getColor(), post.getDetail().getNotes());
        Post posting = new Post(post.getUser_id(), post.getId_post(), post.getDate(), product, post.getCategory(), post.getPrice(),Collections.emptyList());
        Optional<Post> searchPost = SmRepository.searchPost(sell.getPosts(), post.getId_post());
        if (searchPost == null || searchPost.isEmpty()) {
            SmRepository.post(sell, posting);
            response.setMsg("User id " + post.getUser_id() + " The post id " + post.getId_post() + " was added");
            response.setStatusCode(200);
        } else {
            throw new NotFoundException("User id " + post.getUser_id() + " The post id " + post.getId_post() + " it was already added");
        }
        return response;

    }

    public List<PostDTO> searchPost(int user_id, String order) throws NotFoundException {
        List<PostDTO> postDTOS = new ArrayList<>();
        List<List<PostDTO>> posts = new ArrayList<>();
        Buyer buy = SmRepository.searchBuyer(user_id);
        List<Seller> sellers = buy.getFollowed();
        for (Seller s: sellers) {
            for (Post p : s.getPosts()) {
                LocalDate currentDate = LocalDate.now();
                int DAYS = 14;
                long diff = p.getDate().until(currentDate, ChronoUnit.DAYS);
                if (DAYS >= diff) {
                    PostSellerDTO posting = new PostSellerDTO(s.getUser_id());
                    ProductDTO product = new ProductDTO(p.getDetail().getProduct_id(), p.getDetail().getProduct_name(), p.getDetail().getType(), p.getDetail().getBrand(), p.getDetail().getColor(), p.getDetail().getNotes());
                    postDTOS.add(new PostDTO(p.getUser_id(), p.getId_post(), p.getDate(), product, p.getCategory(), p.getPrice()));
                    posting.getPosts().add(new PostDTO(p.getUser_id(), p.getId_post(), p.getDate(), product, p.getCategory(), p.getPrice()));
                    if(order == null ||order.equals("date_asc")){
                        postDTOS = postDTOS.stream().sorted(Comparator.comparing(x->x.getDate())).collect(Collectors.toList());
                    }else  if(order.equals("date_desc")){
                        postDTOS = postDTOS.stream().sorted(Collections.reverseOrder(Comparator.comparing(x->x.getDate()))).collect(Collectors.toList());
                    }
                    posts.add(postDTOS);
                } else {
                    throw new NotFoundException("Does not meet the date");
                }
            }
        }

        return postDTOS;
    }

    public ResponseUserDTO unfollow (int id_buyer, int id_seller) throws NotFoundException{
        ResponseUserDTO response = new ResponseUserDTO();
        Buyer buyer = checkBuyer(id_buyer);
        Seller seller = checkSeller(id_seller);
        Optional<Buyer> follow = SmRepository.searchFollower(seller.getFollowers(), id_buyer);
        if (!follow.isEmpty()) {
            SmRepository.unfollow(buyer, seller);
            response.setMsg("The buyer " + id_buyer + " has successfully unfollowed the seller " + id_seller);
            response.setStatusCode(200);
        } else {
            throw new NotFoundException("The buyer does not follow the seller");
        }
        return response;
    }

}


