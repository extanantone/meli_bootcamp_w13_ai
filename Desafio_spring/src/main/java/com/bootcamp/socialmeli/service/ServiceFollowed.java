package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.*;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IPostRepository;
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

    @Autowired
    IPostRepository iPostRepository;

    @Override
    public ResponseEntity<DTOFollowed> getFolloweds(int userId, String order) {

        try{

            User user = iUserRepository.findById(userId);

            List<DTOUser> listDtoUsers = new ArrayList<>();

            for (Map.Entry<Integer, User> u : user.getListFolows().entrySet())
                listDtoUsers.add(new DTOUser(u.getValue().getUserId(),u.getValue().getUserName()));

            listDtoUsers = iUserRepository.orderFollowersAndFolloweds(listDtoUsers, order);

            return new ResponseEntity(new DTOFollowed(user.getUserId(), user.getUserName(),listDtoUsers), HttpStatus.OK);


        } catch(Exception e) {

        return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

    }

    }

    @Override
    public ResponseEntity getPostFollowed(int userId, String order) {

        List<Post> postListAux = new ArrayList<>();

        List<DTOPublishPost> dtoPublishPostList = new ArrayList<>();

        List<DTOPublishFollowed> dtoPublishFollowedlist = new ArrayList<>();

        try{

            User user = iUserRepository.findById(userId);

            for(Map.Entry <Integer, User> u : user.getListFolows().entrySet()){

                int userIdFollowed =  u.getKey();

                postListAux.addAll(iPostRepository.getPost(userIdFollowed));

            }

            for( Post p : postListAux) {
                DTOPublishPost dtoPublishPost = new DTOPublishPost(p.getIdPost(),
                        p.getDate(),
                        p.getDetail(),
                        p.getCategory(),
                        p.getPrice());
                dtoPublishPostList.add(dtoPublishPost);
            }

            dtoPublishPostList = iPostRepository.orderPosts(dtoPublishPostList, order);

            dtoPublishFollowedlist.add(new DTOPublishFollowed(userId,dtoPublishPostList));

            return new ResponseEntity(dtoPublishFollowedlist,HttpStatus.OK);


        } catch(Exception e){

            return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);

        }
    }
}
