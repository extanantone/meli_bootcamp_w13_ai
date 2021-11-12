package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.DTOCount;
import com.bootcamp.socialmeli.DTO.DTOFollowers;
import com.bootcamp.socialmeli.DTO.DTOUser;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                return new ResponseEntity("El usuario ya sigue al vendedor " + userToFollows.getUserName(), HttpStatus.BAD_REQUEST);

            return new ResponseEntity("Estas siguiendo a " + userToFollows.getUserName(), HttpStatus.OK);

        } catch (Exception e){

            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<DTOCount> getCountFollowersOfuser(int idUser) {

        try {

            User user = iUserRepository.findById(idUser);

            int countFollowers = iUserRepository.getCountFollowersOfuser(idUser);

            DTOCount dtoCount = new DTOCount(user.getUserId(),user.getUserName(),countFollowers);

            return new ResponseEntity(dtoCount, HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<DTOFollowers> getFollowersFromUser(int idUser) {

        try {

            User user = iUserRepository.findById(idUser);

            List<User> followerList = iUserRepository.getFollowersFromUser(idUser);

            List<DTOUser> listDtoUsers = new ArrayList<>();

            for (User u : followerList)
                listDtoUsers.add(new DTOUser(u.getUserId(),u.getUserName()));

            return new ResponseEntity(new DTOFollowers(user.getUserId(), user.getUserName(),listDtoUsers), HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

        }

    }
}
