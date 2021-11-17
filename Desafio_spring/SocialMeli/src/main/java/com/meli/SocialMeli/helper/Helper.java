package com.meli.SocialMeli.helper;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
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
        ProductDTO product = new ProductDTO();
        ModelMapper modelMapper = new ModelMapper();
        product = modelMapper.map(post.getDetail(), ProductDTO.class);
        postDTO = modelMapper.map(post, PostDTOResponse.class);
        postDTO.setDetail(product);
        return postDTO;
    }

    public static Post postDTOToPost(PostDTOResponse postDTO){
        Post post = new Post();
        Product product = new Product();
        ModelMapper modelMapper = new ModelMapper();
        product = modelMapper.map(postDTO.getDetail(), Product.class);
        post = modelMapper.map(postDTO, Post.class);
        post.setDetail(product);
        return post;
    }

    public static ListPostsDTO listPostToListPostDTO(List<Post> postList, int userId){
        ListPostsDTO lista= new ListPostsDTO();
        lista.setUserId(userId);
        ModelMapper modelMapper = new ModelMapper();
        ProductDTO prod = new ProductDTO();

        List<PostDTO> postsDTO = new LinkedList<>();
        for(Post post: postList){
            prod = modelMapper.map(post.getDetail(), ProductDTO.class);
            PostDTO postDTO = new PostDTO(post.getIdPost(), post.getDate(), post.getCategory(), post.getPrice(),prod);
            postsDTO.add(postDTO);
        }
        lista.setPosts(postsDTO);
        return lista;
    }

}
