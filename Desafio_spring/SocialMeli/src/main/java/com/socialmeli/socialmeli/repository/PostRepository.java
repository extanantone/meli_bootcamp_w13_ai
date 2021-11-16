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
    private Map<Integer, Post> postList = new HashMap<Integer, Post>(){{
        Product pro = new Product(1,"asdasd","asdaaa","asdasd","asdasd","asdasd");
        Post p = new Post(1,1, LocalDate.of(2021,11,14),pro,1,12.03,false,0.0);

        put(1,p);
        p = new Post(2,2, LocalDate.of(2021,11,13),pro,1,11.03,false,0.0);
        put(2,p);
        p = new Post(3,3, LocalDate.of(2021,11,12),pro,1,10.03,false,0.0);
        put(3,p);
        p = new Post(3,4, LocalDate.of(2021,11,8),pro,1,10.03,false,0.0);
        put(4,p);
        p = new Post(3,5, LocalDate.of(2021,11,14),pro,1,10.03,true,12.5);
        put(5,p);
    }};

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
