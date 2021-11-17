package com.example.socialmeli.Mapper;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SocialMeliMapper {

    public UserDto userToUserDto (User user){
        return new UserDto(user.getUserId(),user.getUserName());
    }

    public PostDto postToPostDto (Post post){
        return new PostDto(post.getUserId(),post.getPostId(),post.getCategory(),post.getDate().toString(),post.getHasPromo(),post.getDiscount(),post.getPrice(),post.getDetail());
    }

    public Post postDtoToPost (PostDto post){
        return new Post(post.getUserId(),post.getDate(),post.getCategory(),post.getHasPromo(),post.getDiscount(),post.getPrice(),post.getDetail());
    }

    public List<UserDto> userToUserDto (List<User> users){
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach(user ->{
           usersDto.add(this.userToUserDto(user));
        });
        return usersDto;
    }

    public List<PostDto> postListToPostDtoList (List<Post> posts){
        List<PostDto> usersDto = new ArrayList<>();
        posts.forEach(post ->{
            usersDto.add(this.postToPostDto(post));
        });
        return usersDto;
    }
}
