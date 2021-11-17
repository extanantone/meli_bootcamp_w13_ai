package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class PostRepositoryImpl implements  IPostRepository{

    private Long productCounter;

    private Long postCounter;

    private Map<Long, Post> posts;

    private Map<Long, List<Long>> usersToPosts;

    public PostRepositoryImpl() {
        this.productCounter = 1L;
        this.postCounter = 1L;
        this.posts = loadDataBase();
        this.usersToPosts = mapUsersToPosts();
    }

    @Override
    public Post getPost(Long postId) {
        return this.posts.get(postId);
    }

    @Override
    public Long savePost(Post newPost, Long userID) {
        Long newID = this.postCounter;
        this.postCounter++;
        newPost.setPostId(newID);
        this.posts.put(newID, newPost);
        this.usersToPosts.computeIfAbsent(userID, k -> new LinkedList<>());
        this.usersToPosts.get(userID).add(newID);
        return newID;
    }

    @Override
    public List<Post> getAllPosts() {
        return new LinkedList<>(this.posts.values());
    }

    @Override
    public List<Post> getUserPosts(Long userID) {
        List<Post> result = new LinkedList<>();
        this.usersToPosts.computeIfAbsent(userID, k -> new LinkedList<>()).forEach(x -> result.add(this.posts.get(x)));
        return result;
    }

    private Map<Long, Post> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:post.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> postsDB = new ArrayList<>();
        try {
            postsDB = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Long, Post> postsMap = new HashMap<>();
        for (Post post : postsDB){
            postsMap.put(post.getPostId(), post);
            this.postCounter++;
        }
        return postsMap;
    }

    private Map<Long, List<Long>> mapUsersToPosts(){
        Map<Long, List<Long>> mappedValues = new HashMap<>();
        List<Long> list = new LinkedList<>();
        for(Post post : this.posts.values()){
            list.add(post.getPostId());
        }
        mappedValues.put(1L, list);
        return mappedValues;
    }
}
