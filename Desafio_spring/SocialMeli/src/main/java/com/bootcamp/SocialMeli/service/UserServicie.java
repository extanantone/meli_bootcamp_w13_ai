package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.SeguidorDTO;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicie implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public SeguidorDTO setSeguidor(int idSeguidor, int idSeguido) {

            if(iUserRepository.getUser(idSeguidor) ==null){
                throw new NotFoundExceptionUsers(idSeguidor);
            }

        if(iUserRepository.getUser(idSeguido) ==null){
            throw new NotFoundExceptionUsers(idSeguido);
        }



            return new SeguidorDTO(iUserRepository.getUser(idSeguidor).getUserName(),idSeguidor,iUserRepository.getUser(idSeguido).getUserName(),idSeguido);

    }

}
