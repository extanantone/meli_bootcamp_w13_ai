package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {

    Map<Long, Post> posts;
    long currentId;

    public PostRepository() {
        this.posts = loadPostsFromJSON();
        this.currentId = posts.size();
    }

    private Map<Long, Post> loadPostsFromJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> postList = null;
        try {
            postList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postList.stream().collect(Collectors.toMap(Post::getId, Function.identity()));
    }

    @Override
    public Post getPost(long id) {
        return posts.get(id);
    }

    @Override
    public Post createPost(Post post) {
        post.setId(currentId);
        posts.put(post.getId(), post);
        currentId += 1;
        return post;
    }
}
