package com.Sprint1.SocialMeli.mapper;

import com.Sprint1.SocialMeli.dto.*;
import com.Sprint1.SocialMeli.model.Post;
import com.Sprint1.SocialMeli.model.User;

import java.util.List;

public class PostMapper {


    public static PostDTO postToDTO ( Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setUser_id(post.getUser_id());
        postDTO.setId_post(post.getId_post());
        postDTO.setDate(post.getDate());
        postDTO.setDetail(post.getDetail());
        postDTO.setCategory(post.getCategory());
        postDTO.setPrice(post.getPrice());
        return postDTO;
    }

    public static PostFollowedListDTO postDTOtoFollowedListDTO (User user, List<PostDTO> postDTO){
        PostFollowedListDTO followedListDTO = new PostFollowedListDTO();
        followedListDTO.setUser_id(user.getUser_id());
        followedListDTO.setPost(postDTO);
        return followedListDTO;
    }


}
