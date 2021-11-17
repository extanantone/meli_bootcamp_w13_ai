package com.socialmeli.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;
import com.socialmeli.demo.model.Post;
import com.socialmeli.demo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{

    private Map<Integer, Post> repository = new HashMap<>();
    private Integer counter;

    public PostRepository() {
        this.repository = loadDataBase();
        this.counter = this.repository.size();
    }

    private Map<Integer, Post> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  posts.stream().collect(Collectors.toMap(Post::getPostId, Function.identity()));
    }

    @Override
    public Post createPost(Post post) {

        this.repository.put(post.getPostId(), post);

        return post;
    }

    @Override
    public Post findPostById(Integer id) {
        return this.repository.get(id);
    }

    @Override
    public List<Post> getPosts() {
        return this.repository.entrySet().stream().map(e -> {
            e.getValue().setPostId(e.getKey());
            return e.getValue();
        }).collect(Collectors.toList());
    }
}
