package com.example.socialmeli.repositories;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

@Repository("PostRepository")
public class PostRepository implements IRepository<Post> {

    List<Post> posts;

    public PostRepository(){


        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String SCOPE = properties.getProperty("api.scope");
            this.posts = loadFromFile(SCOPE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Post>  loadFromFile(String SCOPE) {

        List<Post> loadedData = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/postsSocialMeli.json");
            loadedData = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;

    }


    @Override
    public void push(Post newElement) {

        this.posts.add(newElement);

    }

    @Override
    public Optional<Post> findById(Integer id) {
        return posts.stream()
                .filter(post -> post.getIdPost().equals(id))
                .findFirst();
    }

    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    public List<Object> findByUserId(Integer userId) {
        return this.posts.stream()
                .filter(post -> post.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Object> findByUserIdAndHasPromo(Integer userId, boolean hasPromo) {
        return this.posts.stream()
                .filter(post ->
                        post.getUserId().equals(userId) && post.isHasPromo() == hasPromo)
                .collect(Collectors.toList());
    }
}
