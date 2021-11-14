package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.response.user.BasicUserInfo;
import com.bootcamp.socialmeli.dto.response.user.PurchaserFollowedListDTO;
import com.bootcamp.socialmeli.dto.response.user.SellerFollowersInfoDTO;
import com.bootcamp.socialmeli.dto.response.user.SellerFollowersListDTO;
import com.bootcamp.socialmeli.exception.UserException.NotFoundUsuarioException;
import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Seller;
import com.bootcamp.socialmeli.repository.ISocialMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final ISocialMeliRepository socialMeliRepository;

    private final ModelMapper mapper;

    public UserServiceImpl(ISocialMeliRepository repository) {
        this.socialMeliRepository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public boolean addFollowed(Integer purchaserId, Integer sellerId)
    {

     Purchaser c = socialMeliRepository.getPurchaser(purchaserId);
     Seller v = socialMeliRepository.getSeller(sellerId);

     if(c == null)
     {
         throw new NotFoundUsuarioException(purchaserId);
     }
     if(v == null)
     {
         throw new NotFoundUsuarioException(sellerId);
     }

        return socialMeliRepository.follow(purchaserId,sellerId);
    }


    @Override
    public SellerFollowersInfoDTO getSellerFollowersCount(Integer sellerId) {

        var seller = socialMeliRepository.getSeller(sellerId);

        if(seller == null)
        {
            throw new NotFoundUsuarioException(sellerId);
        }
        return new SellerFollowersInfoDTO(seller.getUserID(),seller.getUserName(), seller.getFollowers().size());
    }

    @Override
    public SellerFollowersListDTO getSellerFollowersList(Integer sellerId) {

        Seller seller = socialMeliRepository.getSeller(sellerId);

        if(seller == null)
        {
            throw new NotFoundUsuarioException(sellerId);
        }

        List<BasicUserInfo> followers = new ArrayList<>();

        socialMeliRepository.getSellerFollowers(sellerId).stream().forEach(follower ->{
            followers.add(new BasicUserInfo(follower.getUserID(),follower.getUserName()));
        });

        return new SellerFollowersListDTO(sellerId, seller.getUserName(), followers);
    }

    @Override
    public PurchaserFollowedListDTO getPurchaserFollowedList(Integer purchaserId) {

        Purchaser purchaser = socialMeliRepository.getPurchaser(purchaserId);

        if(purchaser == null)
        {
            throw new NotFoundUsuarioException(purchaserId);
        }

        List<BasicUserInfo> followed = new ArrayList<>();

        socialMeliRepository.gerPurchaserFollowed(purchaserId).stream().forEach(follow ->{
            followed.add(new BasicUserInfo(follow.getUserID(),follow.getUserName()));
        });
        
        return new PurchaserFollowedListDTO(purchaserId,purchaser.getUserName(),followed);
    }
}
