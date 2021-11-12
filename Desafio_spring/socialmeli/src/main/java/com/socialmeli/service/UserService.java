package com.socialmeli.service;

import com.socialmeli.dto.SellerFollowersCountDto;
import com.socialmeli.exception.InvalidSellerException;
import com.socialmeli.exception.NotFoundUserException;
import com.socialmeli.model.User;
import com.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void followUser(int idUser, int idSeller) {
        User seller = iUserRepository.getUserById(idSeller);
        User user = iUserRepository.getUserById(idUser);
        if(seller==null || user==null)
            throw  new NotFoundUserException("Not found user to follow");
        seller.addFollower(user);
    }

    @Override
    public SellerFollowersCountDto getCountBySeller(int idSeller) {
        User seller = iUserRepository.getUserById(idSeller);
        if(seller==null)
            throw new NotFoundUserException("Not found seller");
        else if(!seller.isSeller())
            throw new InvalidSellerException("Not is seller");
        return new SellerFollowersCountDto(seller.getId(),seller.getName(),seller.getFollowers().size());
    }
}
