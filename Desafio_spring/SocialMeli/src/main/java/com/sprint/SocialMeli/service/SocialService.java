package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.*;
import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.*;
import com.sprint.SocialMeli.exceptions.DuplicateException;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;
import com.sprint.SocialMeli.model.*;
import com.sprint.SocialMeli.repository.ISocialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialService implements ISocialService{
    ISocialRepository socialRepository;

    public SocialService(ISocialRepository socialRepository){
        this.socialRepository = socialRepository;
    }


    @Override
    public void followSeller(int user_id, int user_id_to_follow) throws Exception {
        UserValidation(user_id, UserType.BUYER);
        UserValidation(user_id_to_follow, UserType.SELLER);

        try{
            Buyer buyer = (Buyer) socialRepository.getUser(user_id);
            buyer.addFollowed(user_id_to_follow);
            socialRepository.putUser(buyer);

            Seller seller = (Seller) socialRepository.getUser(user_id_to_follow);
            seller.addFollower(user_id);
            socialRepository.putUser(seller);
        }
        catch (Exception e){
            throw new Exception("Error al seguir un usuario : " + e.getMessage());
        }


    }

    @Override
    public FollowersCountDto getSellerFollowersCount(int user_id) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);

        return new FollowersCountDto(seller.getUser_id(),
                seller.getUser_name(),
                seller.followersCount());
    }

    @Override
    public FollowersListDto getSellerFollowersList(int user_id, String order) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);

        return new FollowersListDto(seller.getUser_id(),
                seller.getUser_name(),
                orderUserByName(seller.getFollowersIds().stream()
                        .map(f -> socialRepository.getUser(f))
                        .collect(Collectors.toList()), order)
                            .stream()
                            .map(u -> new UserDto(u.getUser_id(), u.getUser_name()))
                            .collect(Collectors.toList()));
    }

    @Override
    public FollowedListDto getBuyerFollowedList(int user_id, String order) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.BUYER);
        Buyer buyer = (Buyer) socialRepository.getUser(user_id);

        return new FollowedListDto(buyer.getUser_id(),
                buyer.getUser_name(),
                orderUserByName(buyer.getFollowedIds().stream()
                        .map(f -> socialRepository.getUser(f))
                        .collect(Collectors.toList()), order)
                            .stream()
                            .map(u -> new UserDto(u.getUser_id(), u.getUser_name()))
                            .collect(Collectors.toList()));
    }

    @Override
    public void newPost(PostDtoIn postDtoIn) throws Exception {
        savePost(new Post(postDtoIn));
    }

    @Override
    public FollowedPostListDto getLastTwoWeeksPostsFromFollowed(int user_id, String order) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.BUYER);
        Buyer buyer = (Buyer) socialRepository.getUser(user_id);

        if(order == null)
            order = "date_desc";

        List<Post> posts = new ArrayList<>();
        List<Seller> sellers = buyer.getFollowedIds().stream()
                                .map(f -> (Seller) socialRepository.getUser(f))
                                .collect(Collectors.toList());

        sellers.forEach(s -> posts.addAll(
                                s.getPostsIds().stream()
                                .map(p -> socialRepository.getPost(p))
                                .filter(p -> p.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                                .collect(Collectors.toList())));

        return new FollowedPostListDto(buyer.getUser_id(),
                (order.equals("date_asc") ?
                        posts.stream()
                                .sorted(Comparator.comparing(Post::getDate))
                        :
                        posts.stream()
                                .sorted(Comparator.comparing(Post::getDate).reversed()))
                .map(PostDtoOut::new)
                .collect(Collectors.toList()));
    }

    @Override
    public void unfollowSeller(int user_id, int user_id_to_unfollow) throws Exception {
        UserValidation(user_id, UserType.BUYER);
        UserValidation(user_id_to_unfollow, UserType.SELLER);

        try{
            Buyer buyer = (Buyer) socialRepository.getUser(user_id);
            buyer.deleteFollowed(user_id_to_unfollow);
            socialRepository.putUser(buyer);

            Seller seller = (Seller) socialRepository.getUser(user_id);
            seller.deleteFollower(user_id);
            socialRepository.putUser(seller);
        }
        catch(Exception e){
            throw new Exception("Error al dejar de seguir un usuario : " + e.getMessage());
        }

    }

    @Override
    public void newPromoPost(PromoPostDtoIn promoPostDtoIn) throws Exception {
        savePost(new Post(promoPostDtoIn));
    }

    @Override
    public PromoPostCountDto getPromoPostCount(int user_id) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        return new PromoPostCountDto(user_id,
                socialRepository.getUser(user_id).getUser_name(),
                (int) ((Seller)socialRepository.getUser(user_id))
                        .getPostsIds().stream()
                        .map(p -> socialRepository.getPost(p))
                        .filter(Post::isHas_promo)
                        .count());
    }

    @Override
    public PromoPostList getPromoPostList(int user_id) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);

        return new PromoPostList(seller.getUser_id(),
                seller.getUser_name(),
                seller.getPostsIds().stream().map(p -> socialRepository.getPost(p)).filter(Post::isHas_promo).map(PromoPostDtoOut::new).collect(Collectors.toList()));
    }

    private void UserValidation(int user_id, UserType userType) throws WrongTypeException, NotFoundException {
        if (userType.equals(UserType.BUYER)){
            if(!socialRepository.existsUser(user_id))
                throw new NotFoundException("El comprador no se ha encontrado");
            else if(socialRepository.getUser(user_id).getUserType() != UserType.BUYER)
                throw new WrongTypeException("El usuario seguidor no es un comprador");
        }
        else if (userType.equals(UserType.SELLER)){
            if(!socialRepository.existsUser(user_id))
                throw new NotFoundException("El vendedor no se ha encontrado");
            else if(socialRepository.getUser(user_id).getUserType() != UserType.SELLER)
                throw new WrongTypeException("El usuario a seguir no es un vendedor");
        }
    }

    private List<User> orderUserByName(List<User> users, String order){
        if(order == null || order.equals("name_asc"))
            return users.stream().sorted(Comparator.comparing(User::getUser_name)).collect(Collectors.toList());
        else if(order.equals("name_desc"))
            return users.stream().sorted(Comparator.comparing(User::getUser_name).reversed()).collect(Collectors.toList());
        return users;
    }

    private void savePost(Post post) throws Exception {
        UserValidation(post.getUser_id(), UserType.SELLER);
        if(socialRepository.existsPost(post.getId_post()))
            throw new DuplicateException("Ya existe un post con ese  identificatorio");
        try{
            socialRepository.putPost(post);
            Seller seller = (Seller) socialRepository.getUser(post.getUser_id());
            seller.addPost(post.getId_post());
            socialRepository.putUser(seller);
        }
        catch(Exception e){
            throw new Exception("Error al crear un nuevo post : " + e.getMessage());
        }

    }
}
