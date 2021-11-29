package com.socialmeli.demo.mapper;

import com.socialmeli.demo.dto.PostDTO;
import com.socialmeli.demo.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post postDTOToPost(PostDTO postDTO){
        return new Post(
                postDTO.getUserId(),
                postDTO.getPostId(),
                postDTO.getUserName(),
                postDTO.getDate(),
                postDTO.getDetail(),
                postDTO.getCategory(),
                postDTO.getPrice()
        );
    }

    public PostDTO postToPostDTO(Post post){
        return new PostDTO(
                post.getUserId(),
                post.getPostId(),
                post.getUserName(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice()
        );
    }
}
