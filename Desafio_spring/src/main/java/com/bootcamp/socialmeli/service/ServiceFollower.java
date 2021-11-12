package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.DTOCount;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceFollower implements IServiceFollower{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public ResponseEntity<String> userToFollow(int idUser, int idUserToFollow) {

        if(idUser == idUserToFollow)
            return new ResponseEntity("No puedes seguirte a ti mismo", HttpStatus.BAD_REQUEST);

        try{

            User user = iUserRepository.findById(idUser);

            User userToFollows = iUserRepository.findById(idUserToFollow);

            boolean userFollowed = user.addListFollows(idUserToFollow,userToFollows);

            if(!userFollowed)
                return new ResponseEntity("El usuario ya sigue al vendedor " + userToFollows.getName(), HttpStatus.BAD_REQUEST);

            return new ResponseEntity("Estas siguiendo a " + userToFollows.getName(), HttpStatus.OK);

        } catch (Exception e){

            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<DTOCount> getCountFollowersOfuser(int idUser) {

        User user = iUserRepository.findById(idUser);

        if(user == null)
            return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

        int countFollowers = iUserRepository.getCountFollowersOfuser(idUser);

        DTOCount dtoCount = new DTOCount(user.getUserId(),user.getName(),countFollowers);

        return new ResponseEntity(dtoCount, HttpStatus.OK);
    }
}
