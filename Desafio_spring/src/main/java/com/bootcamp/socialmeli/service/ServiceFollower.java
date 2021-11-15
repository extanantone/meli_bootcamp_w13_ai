package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.DTOCount;
import com.bootcamp.socialmeli.DTO.DTOFollower;
import com.bootcamp.socialmeli.DTO.DTOUser;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFollower implements IServiceFollower{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public ResponseEntity<String> userToFollow(int userId, int userIdToFollow) {

        if(userId == userIdToFollow)
            return new ResponseEntity("No puedes seguirte a ti mismo", HttpStatus.BAD_REQUEST);

        try{

            User user = iUserRepository.findById(userId);

            User userToFollows = iUserRepository.findById(userIdToFollow);

            boolean userFollowed = user.addListFollows(userIdToFollow,userToFollows);

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
    public ResponseEntity<DTOFollower> getFollowersFromUser(int idUser, String order) {

        try {

            User user = iUserRepository.findById(idUser);

            List<User> followerList = iUserRepository.getFollowersFromUser(idUser);

            List<DTOUser> listDtoUsers = new ArrayList<>();

            for (User u : followerList)
                listDtoUsers.add(new DTOUser(u.getUserId(),u.getUserName()));

            listDtoUsers = iUserRepository.orderFollowersAndFolloweds(listDtoUsers, order);

            return new ResponseEntity(new DTOFollower(user.getUserId(), user.getUserName(),listDtoUsers), HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity userToUnfollow(int userId, int userIdToUnfollow) {

        try {

            User user = iUserRepository.findById(userId);

            if(user.getListFolows().containsKey(userIdToUnfollow))
                user.getListFolows().remove(userIdToUnfollow);
            else {
                try {

                    User userToUnfollow = iUserRepository.findById(userIdToUnfollow);

                    return new ResponseEntity("No sigue al vendedor", HttpStatus.BAD_REQUEST);

                } catch (Exception e){

                    return new ResponseEntity("El vendedor no existe", HttpStatus.BAD_REQUEST);

                }
            }



        } catch(Exception e){

            return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

        }

        return null;
    }
}
