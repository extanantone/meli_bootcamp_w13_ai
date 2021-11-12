package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.*;
import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.*;
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
    public void followSeller(int user_id, int user_id_to_follow) throws NotFoundException, WrongTypeException {
        UserValidation(user_id, UserType.BUYER);
        UserValidation(user_id_to_follow, UserType.SELLER);

        Buyer buyer = (Buyer) socialRepository.getUser(user_id);
        buyer.addFollowed(user_id_to_follow);
        socialRepository.putUser(buyer);

        Seller seller = (Seller) socialRepository.getUser(user_id);
        seller.addFollower(user_id);
        socialRepository.putUser(seller);

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
    public void newPost(PostDtoIn postDtoIn) throws WrongTypeException, NotFoundException {
        UserValidation(postDtoIn.getUser_id(), UserType.SELLER);
        socialRepository.putPost(new Post(postDtoIn));
        Seller seller = (Seller) socialRepository.getUser(postDtoIn.getUser_id());
        seller.addPost(postDtoIn.getId_post());
        socialRepository.putUser(seller);
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
    public void unfollowSeller(int user_id, int user_id_to_unfollow) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.BUYER);
        UserValidation(user_id_to_unfollow, UserType.SELLER);

        Buyer buyer = (Buyer) socialRepository.getUser(user_id);
        buyer.deleteFollowed(user_id_to_unfollow);
        socialRepository.putUser(buyer);

        Seller seller = (Seller) socialRepository.getUser(user_id);
        seller.deleteFollower(user_id);
        socialRepository.putUser(seller);
    }

    @Override
    public void newPromoPost(PromoPostDtoIn promoPostDtoIn) throws WrongTypeException, NotFoundException {
        UserValidation(promoPostDtoIn.getUser_id(), UserType.SELLER);
        socialRepository.putPost(new Post(promoPostDtoIn));
        Seller seller = (Seller) socialRepository.getUser(promoPostDtoIn.getUser_id());
        seller.addPost(promoPostDtoIn.getId_post());
        socialRepository.putUser(seller);
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
                throw new NotFoundException("El id del comprador no se ha encontrado");
            else if(socialRepository.getUser(user_id).getUserType() != UserType.BUYER)
                throw new WrongTypeException("El usuario seguidor no es un comprador");
        }
        else if (userType.equals(UserType.SELLER)){
            if(!socialRepository.existsUser(user_id))
                throw new NotFoundException("El id del vendedor no se ha encontrado");
            else if(socialRepository.getUser(user_id).getUserType() != UserType.SELLER)
                throw new WrongTypeException("El usuario a seguir no es un vendedor");
        }
    }

    private List<User> orderUserByName(List<User> users, String order){
        if(order.equals("name_asc"))
            return users.stream().sorted(Comparator.comparing(User::getUser_name)).collect(Collectors.toList());
        else if(order.equals("name_desc"))
            return users.stream().sorted(Comparator.comparing(User::getUser_name).reversed()).collect(Collectors.toList());
        return users;
    }
}
