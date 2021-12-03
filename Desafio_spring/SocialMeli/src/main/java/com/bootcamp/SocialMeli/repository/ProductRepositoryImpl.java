
package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Post> postsList;

    public ProductRepositoryImpl() {
        this.postsList = new ArrayList<>();
    }

    @Override
    public List<Post> getAllPosts() {
        return this.postsList;
    }

    @Override
    public void post(Post newPost){
        postsList.add(newPost);
    }
    @Override
    public  List<Post> getPostsById(int userId){
        List<Post> postsById;
        postsById = postsList.stream().filter(post -> post.getUserId() == userId).collect(Collectors.toList());
        return  postsById;
    }

    @Override
    public List<Post> getPostListFrom2WeeksAgoAsc(int userId){
        LocalDate startDate = LocalDate.now().minusDays(15);

        List<Post> postsLast2Weeks = getPostsById(userId)
                .stream().filter(post -> post.getDate().isAfter(startDate)).collect(Collectors.toList());

        Collections.sort(postsLast2Weeks, Comparator.comparing(Post::getDate));

        return postsLast2Weeks;

    }

    @Override
    public List<Post> getPostListFrom2WeeksAgoDesc(int userId){
        LocalDate startDate = LocalDate.now().minusDays(15);

        List<Post> postsLast2Weeks = getPostsById(userId)
                .stream().filter(post -> post.getDate().isAfter(startDate)).collect(Collectors.toList());

        Collections.sort(postsLast2Weeks, Comparator.comparing(Post::getDate).reversed());

        return postsLast2Weeks;

    }
}

