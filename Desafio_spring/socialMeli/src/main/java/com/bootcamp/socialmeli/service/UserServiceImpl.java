package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.response.SellerFollowersInfoDTO;
import com.bootcamp.socialmeli.exception.UserException.NotFoundUsuarioException;
import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Seller;
import com.bootcamp.socialmeli.repository.ISocialMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public SellerFollowersInfoDTO getSellerFollowers(Integer sellerId) {

        var seller = socialMeliRepository.getSeller(sellerId);

        if(seller == null)
        {
            throw new NotFoundUsuarioException(sellerId);
        }
        return new SellerFollowersInfoDTO(seller.getUserID(),seller.getUserName(), seller.getFollowers().size());
    }
}
