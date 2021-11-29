package com.socialmeli.demo.util;

import com.socialmeli.demo.dto.PostDTO;
import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;
import com.socialmeli.demo.model.User;

import java.time.LocalDate;
import java.util.List;

public class TestUtil {

    public static UserWithFollowedPostsListDTO getUserWithPosts(User user,
                                                                Integer postId,
                                                                LocalDate date,
                                                                int category,
                                                                double price){

        PostDTO postDTO = new PostDTO(user.getUserId(), postId, user.getUserName(), date,
                null, category, price);

        List<PostDTO> postDTOS = List.of(postDTO);


        return new UserWithFollowedPostsListDTO(2, postDTOS);
    }
}
