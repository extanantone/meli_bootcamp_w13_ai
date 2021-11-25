package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.dto.controllerToService.*;
import com.example.socialmeli.demo.dto.serviceToController.*;
import com.example.socialmeli.demo.exception.UserNotFoundException;
import com.example.socialmeli.demo.mapper.PostMapper;
import com.example.socialmeli.demo.mapper.PromoMapper;
import com.example.socialmeli.demo.model.Post;
import com.example.socialmeli.demo.model.PromoPost;
import com.example.socialmeli.demo.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPublicacionRepository;

    @Autowired
    IFollowerService iFollowerService;

    @Autowired
    IUserService iUserService;

    @Override
    public ResponseEntity createPost(DTOPost publicacion) {

        Post postToSave = new Post();
        postToSave = PostMapper.DtoPostToPost(publicacion);
        iPublicacionRepository.createPost(postToSave);

       return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity createPromoPost(DTOPromoPost publicacion) {

        PromoPost postToSave = new PromoPost();
        postToSave = PromoMapper.DtoPostToPost(publicacion);
        iPublicacionRepository.createPost(postToSave);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<DTOPostsFromMyFollowedUsers> getPostsFromFollowedUsersSinceTwoWeeks(DTORequestPostsFromFolloweds request) {

        int userId = request.getUserId();
        String order = request.getOrder();
        List<Post> postsFromVendor = new ArrayList<>();
        List<DTOUsuario> followedUsersFromUser = new ArrayList<>();
        List<DTOPostFollowers> postsFromVendorDTO = new ArrayList<>();
        DTOUserFollowedList followedUsersFromUserDTO = new DTOUserFollowedList();
        DTOPostsFromMyFollowedUsers response = new DTOPostsFromMyFollowedUsers();

        //Verificamos que el usuario exista
        DTOUsuario searchedUser = iUserService.getUserByUserId(userId);

        if(searchedUser == null){
            throw new UserNotFoundException();
        }

        DTORequestUserList requestToPostService = new DTORequestUserList();
        requestToPostService.setUserId(request.getUserId());
        requestToPostService.setOrder(null);

        DTOUserId userIdDTo = new DTOUserId(userId);
        followedUsersFromUserDTO = iFollowerService.getFollowedUsersOfUserId(requestToPostService);
        followedUsersFromUser = followedUsersFromUserDTO.getFollowed();

        for (DTOUsuario uDTO: followedUsersFromUser) {

            postsFromVendor = iPublicacionRepository.getPostsFromFollowedUsersSinceTwoWeeks(uDTO.getUserId(),order);

            for (Post p: postsFromVendor) {

                DTOPostFollowers postFollowersDTO = new DTOPostFollowers();
                postFollowersDTO = PostMapper.PostToDtoPostFollowers(p);
                postsFromVendorDTO.add(postFollowersDTO);
            }
        }

        response.setUserId(userId);
        response.setPosts(postsFromVendorDTO);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTOUserPromoPostList> getPromoPostListOfUserId(DTOUserId request) {

        int vendorId = request.getUserId();
        List<Post> responseFromRepository = new ArrayList<>();
        List<DTOPromoPost> promoPostList = new ArrayList<>();
        DTOUsuario searchedUser = new DTOUsuario();
        DTOUserPromoPostList response = new DTOUserPromoPostList();

        searchedUser = iUserService.getUserByUserId(vendorId);

        if(searchedUser == null){
           throw new UserNotFoundException();
        }

        response.setUserId(vendorId);
        response.setUserName(searchedUser.getUserName());

        responseFromRepository = iPublicacionRepository.getPromoPostOfUser(vendorId);

        for (Post p: responseFromRepository) {

            DTOPromoPost post = new DTOPromoPost();
            post = PromoMapper.PostToDtoPromoPost(p);
            response.addPostToList(post);
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTOUserPromoPostCount> countPromoPostOfUser(DTOUserId userId) {

        int vendorId = userId.getUserId();
        int promoProductsCount = 0;
        DTOUsuario searchedUser = new DTOUsuario();
        DTOUserPromoPostCount response = new DTOUserPromoPostCount();

        searchedUser = iUserService.getUserByUserId(vendorId);

        if(searchedUser == null){
            throw new UserNotFoundException();
        }

        response.setUserId(vendorId);
        response.setUserName(searchedUser.getUserName());

        promoProductsCount = iPublicacionRepository.countPromoPostOfUser(vendorId);
        response.setPromoProductsCount(promoProductsCount);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
