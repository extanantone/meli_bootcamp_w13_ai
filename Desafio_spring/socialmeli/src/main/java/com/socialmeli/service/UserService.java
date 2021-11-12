package com.socialmeli.service;

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
}
