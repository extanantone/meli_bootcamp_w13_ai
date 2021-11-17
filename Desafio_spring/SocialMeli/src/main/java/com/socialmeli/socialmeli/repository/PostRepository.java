package com.socialmeli.socialmeli.repository;

import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.exceptions.userExceptions.NotFoundUserException;
import com.socialmeli.socialmeli.mapper.PostMapper;
import com.socialmeli.socialmeli.model.Post;
import com.socialmeli.socialmeli.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements PostRepositoryI{
    private Map<Integer, Post> postList = new HashMap<Integer, Post>();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public String newPost(Post post) {
        if(userRepository.userExists(post.getUser_id())){
            if (!postExist(post.getId_post())){
                postList.put(post.getId_post(),post);
                userRepository.addPost(post.getUser_id(),post.getId_post());
                return "true";
            } else {
                return "postExist";
            }
        } else {
            return "userExist";
        }
    }

    @Override
    public boolean postExist(int post_id){
        boolean contains = postList.containsKey(post_id);
        return contains;
    }

    @Override
    public Post getPost(int post_id){
        return postList.get(post_id);
    }
}
