package com.socialMeli.SocialMeli.service;

import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.postDTO.PromoPostDTO;
import com.socialMeli.SocialMeli.postDTO.PromoProductsCountDTO;
import com.socialMeli.SocialMeli.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post create(Post post, HashMap usersList) {
        if(verifyUsers(post.getUser_id(),usersList)){
            return postRepository.create(post);
        }else{
            throw new NotFoundUserException();
        }
    }

    @Override
    public Post create(PromoPostDTO post, HashMap usersList) {
        if(verifyUsers(post.getUser_id(),usersList)){
            return postRepository.create(post);
        }else{
            throw new NotFoundUserException();
        }
    }

    @Override
    public PostFollowedDTO productListFollowed(HashMap usersList,Integer user_id) {
        if(verifyUsers(user_id,usersList)){
            return postRepository.productListFollowed((User) usersList.get(user_id));
        }else{
            throw new NotFoundUserException();
        }
    }

    @Override
    public PostFollowedDTO productListFollowed(HashMap usersList,Integer user_id, String date_desc) {
        if(verifyUsers(user_id,usersList)){
            User user= (User) usersList.get(user_id);
            PostFollowedDTO productiList = postRepository.productListFollowed(user);
            Collections.reverse(productiList.getPosts());
            return productiList;
        }else{
            throw new NotFoundUserException();
        }

    }

    @Override
    public PromoProductsCountDTO promoProductsCount(Integer user_id, HashMap<Integer, User> list_users) {
        if(verifyUsers(user_id,list_users)){
            return postRepository.promoProductsCount(list_users.get(user_id));
        }else{
            throw new NotFoundUserException();
        }
    }

    public boolean verifyUsers(Integer user_id, Integer user_id_to_follow, HashMap usersList){
        User user1 = (User) usersList.get(user_id);
        User user2= (User) usersList.get(user_id_to_follow);
        if(user1 != null && user2 != null){
            return true;
        }else {
            return false;
        }
    }

    public boolean verifyUsers(Integer user_id,HashMap usersList){
        User user1 = (User) usersList.get(user_id);
        if(user1 != null){
            return true;
        }else {
            return false;
        }
    }
}
