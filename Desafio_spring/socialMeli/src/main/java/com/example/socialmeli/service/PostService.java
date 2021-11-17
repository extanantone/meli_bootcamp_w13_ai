package com.example.socialmeli.service;

import com.example.socialmeli.dto.NewPostRequestDto;
import com.example.socialmeli.dto.PostRequestResponseDto;
import com.example.socialmeli.dto.PostResponseDto;
import com.example.socialmeli.dto.UserResponseDto;
import com.example.socialmeli.exception.BadBodyRequestException;
import com.example.socialmeli.exception.BadParamsRequestException;
import com.example.socialmeli.exception.UserNotExistException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.PostRepository;
import com.example.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service

public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public PostRequestResponseDto addPost(NewPostRequestDto postReq){
        if(Objects.isNull(postReq.getUserId())){
            throw new BadBodyRequestException("El id del usuario no es valido");
        }
        if(!userRepository.userExist(postReq.getUserId())){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", postReq.getUserId()));
        }
        if(postReq.getHasPromo()){
            Double descuento = postReq.getDiscount();
            if (!(0 < descuento && descuento < 1)){
                throw new BadBodyRequestException("El % de descuento ingresado no es valido");
            }
        }
        if(postReq.getPrice() <= 0){
            throw new BadBodyRequestException("El Precio ingresado no es valido");
        }

        System.out.println(userRepository.getUser(postReq.getUserId()).getUserName());
        Post post = new Post(postReq.getUserId(),postReq.getDate(),postReq.getCategory(),postReq.getHasPromo(),postReq.getDiscount(),postReq.getPrice(),postReq.getDetail());
        postRepository.setPost(post);
        return new PostRequestResponseDto(String.format("Se creo el post con id: %d",post.getPostId()));
    }

    public PostResponseDto getPostFromUserId(Integer user_id, String order){

        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }

        User user = userRepository.getUser(user_id);
        List<Integer> userIdList = user.getFollowedList();
        List<Post> postList = postRepository.getPostFromUsersId(userIdList);
        if(order != null){
            if ("date_desc".equals(order)) {
                postList.sort(Comparator.comparing(Post::getDate).reversed());
            }else{
                postList.sort(Comparator.comparing(Post::getDate));
            }
        }
        return new PostResponseDto(user_id,user.getUserName(),postList);
    }

    public UserResponseDto countPostFromUserId(Integer user_id){

        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }

        User user = userRepository.getUser(user_id);
        Integer count = postRepository.getPromoPostFromUserId(user_id).size();
        return new UserResponseDto(user_id,user.getUserName(),null,count,null,null);
    }

    public PostResponseDto getPromoPostFromUserId(Integer user_id){

        if(Objects.isNull(user_id)){
            throw new BadParamsRequestException("El id del usuario no es valido");
        }
        if(!userRepository.userExist(user_id)){
            throw new UserNotExistException(String.format("No existe el usuario con id %d", user_id));
        }

        User user = userRepository.getUser(user_id);
        List<Post> postList = postRepository.getPromoPostFromUserId(user_id);
        return new PostResponseDto(user_id,user.getUserName(),postList);
    }
}
