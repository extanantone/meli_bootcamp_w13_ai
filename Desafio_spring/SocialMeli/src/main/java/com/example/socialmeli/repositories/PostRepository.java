package com.example.socialmeli.repositories;

import com.example.socialmeli.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository("PostRepository")
public class PostRepository implements IRepository<Post> {

    List<Post> posts;

    public PostRepository(){
        this.posts = loadFromFile("classpath:postsSocialMeli.json");

    }
    public static List<Post>  loadFromFile(String path) {

        List<Post> loadedData = null;

        File file = null;
        try {
            file = ResourceUtils.getFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};

        try {
            loadedData = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedData;

    }


    @Override
    public void push(Post newElement) {

        this.posts.add(newElement);

    }

    @Override
    public Optional<Post> findId(Integer id) {
        return posts.stream()
                .filter(post -> post.getIdPost().equals(id))
                .findFirst();
    }

    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    @Override
    public void removeById(Integer id){
        posts.removeIf( post -> post.getIdPost().equals(id) );
    }
}
