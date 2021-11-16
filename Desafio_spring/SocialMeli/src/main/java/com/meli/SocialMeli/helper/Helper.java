package com.meli.SocialMeli.helper;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.User;
import org.modelmapper.ModelMapper;

import java.util.LinkedList;
import java.util.List;

public class Helper {

    public static FollowersDTO listFollowersToFollowers(User usr){
        FollowersDTO followers = new FollowersDTO();
        followers.setUserId(usr.getUserId());
        followers.setUserName(usr.getUserName());
        List<UserDTO> followersList = new LinkedList<>();
        for(User usrCurrent: usr.getFollowed()){
            UserDTO usrDTO = new UserDTO(usrCurrent.getUserId(), usrCurrent.getUserName());
            followersList.add(usrDTO);
        }
        followers.setFollowers(followersList);
        return followers;
    }

    public static FollowedDTO listFollowedToFollowed(User usr){
        FollowedDTO followed = new FollowedDTO();
        followed.setUserId(usr.getUserId());
        followed.setUserName(usr.getUserName());
        List<UserDTO> followedList = new LinkedList<>();
        for(User usrCurrent: usr.getFollowers()){
            UserDTO usrDTO = new UserDTO(usrCurrent.getUserId(), usrCurrent.getUserName());
            followedList.add(usrDTO);
        }
        followed.setFollowed(followedList);
        return followed;
    }

    public static PostDTOResponse postToPostDTO(Post post){
        PostDTOResponse postDTO = new PostDTOResponse();
        postDTO.setIdPost(post.getIdPost());
        postDTO.setCategory(post.getCategory());
        postDTO.setDate(post.getDate());
        postDTO.setPrice(post.getPrice());
        //postDTO.setDetail(post.getDetail());
        ModelMapper modelMapper = new ModelMapper();
        postDTO = modelMapper.map(post, PostDTOResponse.class);
        return postDTO;
    }

    public static Post postDTOToPost(PostDTOResponse postDTO){
        Post post = new Post();
        post.setIdPost(postDTO.getIdPost());
        post.setCategory(postDTO.getCategory());
        post.setDate(postDTO.getDate());
        post.setPrice(postDTO.getPrice());
        //postDTO.setDetail(post.getDetail());
        ModelMapper modelMapper = new ModelMapper();
        post = modelMapper.map(postDTO, Post.class);
        return post;
    }

    public static ListPostsDTO listPostToListPostDTO(List<Post> postList, int userId){
        ListPostsDTO lista= new ListPostsDTO();
        lista.setUserId(userId);
        ModelMapper modelMapper = new ModelMapper();
        ProductDTO prod = new ProductDTO();
        List<PostDTO> postsDTO = new LinkedList<>();
        for(Post post: postList){
            PostDTO postDTO = new PostDTO(post.getIdPost(), post.getDate(), post.getCategory(), post.getPrice(),modelMapper.map(prod, ProductDTO.class));
            postsDTO.add(postDTO);
        }
        lista.setPosts(postsDTO);
        return lista;
    }

}
