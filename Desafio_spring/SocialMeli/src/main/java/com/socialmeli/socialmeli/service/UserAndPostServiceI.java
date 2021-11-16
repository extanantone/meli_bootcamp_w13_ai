package com.socialmeli.socialmeli.service;

import com.socialmeli.socialmeli.dto.ResponseSuccessfullyDTO;
import com.socialmeli.socialmeli.dto.post.FollowedSellerPostDTO;
import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.dto.user.UserFollowerCountDTO;
import com.socialmeli.socialmeli.dto.user.UserFollowexListDTO;

import java.util.Map;

public interface UserAndPostServiceI {
    Map<String,Object> addFollower(int user_id,int user_id_to_follow);


    UserFollowerCountDTO countFollowersUser(int user_id);

    UserFollowexListDTO listUserFollowex(int user_id,boolean isFollowersList,String order);

    Map<String,Object> newPost(PostDTO postDTO);

    FollowedSellerPostDTO followedSellersPost(int user_id,String order);

    Map<String,Object> unfollow(int user_id,int user_id_to_unfollow);
}
