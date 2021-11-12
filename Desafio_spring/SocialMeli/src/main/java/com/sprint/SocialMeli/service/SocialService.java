package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.FollowedListDto;
import com.sprint.SocialMeli.dto.FollowersCountDto;
import com.sprint.SocialMeli.dto.FollowersListDto;
import com.sprint.SocialMeli.dto.UserDto;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrontTypeException;
import com.sprint.SocialMeli.model.Buyer;
import com.sprint.SocialMeli.model.User;
import com.sprint.SocialMeli.model.UserType;
import com.sprint.SocialMeli.model.Seller;
import com.sprint.SocialMeli.repository.ISocialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialService implements ISocialService{
    ISocialRepository socialRepository;

    public SocialService(ISocialRepository socialRepository){
        this.socialRepository = socialRepository;
    }


    @Override
    public void followVendedor(int user_id, int user_id_to_follow) throws NotFoundException, WrontTypeException {
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
    public FollowersCountDto getSellerFollowersCount(int user_id) throws WrontTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);

        return new FollowersCountDto(seller.getUser_id(), seller.getUser_name(), seller.followersCount());
    }

    @Override
    public FollowersListDto getSellerFollowersList(int user_id) throws WrontTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);
        return new FollowersListDto(seller.getUser_id(), seller.getUser_name(),seller.getFollowersIds().stream().map(f -> socialRepository.getUser(f)).map(u -> new UserDto(u.getUser_id(), u.getUser_name())).collect(Collectors.toList()));
    }

    @Override
    public FollowedListDto getBuyerFollowedList(int user_id) throws WrontTypeException, NotFoundException {
        UserValidation(user_id, UserType.BUYER);
        Buyer buyer = (Buyer) socialRepository.getUser(user_id);
        return new FollowedListDto(buyer.getUser_id(), buyer.getUser_name(),buyer.getFollowedIds().stream().map(f -> socialRepository.getUser(f)).map(u -> new UserDto(u.getUser_id(), u.getUser_name())).collect(Collectors.toList()));
    }

    private void UserValidation(int user_id, UserType userType) throws WrontTypeException, NotFoundException {
        if (userType.equals(UserType.BUYER)){
            if(!socialRepository.existsUser(user_id))
                throw new NotFoundException("El id del comprador no se ha encontrado");
            else if(socialRepository.getUser(user_id).getUserType() != UserType.BUYER)
                throw new WrontTypeException("El usuario seguidor no es un comprador");
        }
        else if (userType.equals(UserType.SELLER)){
            if(!socialRepository.existsUser(user_id))
                throw new NotFoundException("El id del vendedor no se ha encontrado");
            else if(socialRepository.getUser(user_id).getUserType() != UserType.SELLER)
                throw new WrontTypeException("El usuario a seguir no es un vendedor");
        }
    }
}
