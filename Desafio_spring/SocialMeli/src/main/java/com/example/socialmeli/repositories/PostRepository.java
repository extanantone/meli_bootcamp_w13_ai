package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.PostNotFoundException;
import com.example.socialmeli.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository("PostRepository")
public class PostRepository implements IRepository<Post> {

    List<Post> posts;

    public PostRepository(){this.posts = loadRepository();}

    @Override
    public List<Post> loadRepository() {
        List<Post> postsList = null;

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:postsSocialMeli.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};

        try {
            postsList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return postsList;
    }

    @Override
    public void push(Post newElement) {

        this.posts.add(newElement);

    }

    @Override
    public Post getById(Integer id) throws PostNotFoundException {
        //return posts.stream().findFirst().orElseThrow(null);
        return posts.stream().filter(post -> post.getIdPost().equals(id)).findFirst().orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public List<Post> getAll() {
        return this.posts;
    }

    @Override
    public void removeById(Integer id){
        posts.removeIf( post -> post.getIdPost().equals(id) );
    }
}
