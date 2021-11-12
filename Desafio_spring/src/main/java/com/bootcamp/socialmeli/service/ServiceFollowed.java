package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.DTOFollowed;
import com.bootcamp.socialmeli.DTO.DTOUser;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ServiceFollowed implements IServiceFollowed{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public ResponseEntity<DTOFollowed> getFolloweds(int userId) {

        try{

            User user = iUserRepository.findById(userId);

            List<DTOUser> listDtoUsers = new ArrayList<>();

            for (Map.Entry<Integer, User> u : user.getListFolows().entrySet())
                listDtoUsers.add(new DTOUser(u.getValue().getUserId(),u.getValue().getUserName()));

            return new ResponseEntity(new DTOFollowed(user.getUserId(), user.getUserName(),listDtoUsers), HttpStatus.OK);


        } catch(Exception e) {

        return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

    }

    }
}
