package com.example.socialmeli.repository.product.post;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.user.IUserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PostRepository implements IPostRepository
{

    private List<Post> postList;

    @Autowired
    IUserRepository userRepository;


    public PostRepository(List<Post> postList)
    {
        this.postList = new LinkedList<>();
    }

    @Override
    public Map<Integer, Post> postMap()
    {
        return postList.stream().collect(Collectors.toMap(Post::getIdPost, post -> post));
    }

    @Override
    public List<Post> findTwoWeeksBeforeOrderByDateDesc(Integer userId)
    {
        LocalDate twoWeeksBeforeDate = LocalDate.now().minusWeeks(2);
        Comparator<Post> dateDesc = Comparator.comparing(Post::getDate).reversed();
        Stream<Post> twoWeeksPosts = userRepository.usersMap().get(userId).getPosts().
                stream().filter((post) -> !post.getDate().isBefore(twoWeeksBeforeDate));
        return twoWeeksPosts.sorted(dateDesc).collect(Collectors.toList());
    }

    @Override
    public List<Post> findTwoWeeksBeforeOrderByDateAsc(Integer userId)
    {
        LocalDate twoWeeksBeforeDate = LocalDate.now().minusWeeks(2);
        Comparator<Post> dateDesc = Comparator.comparing(Post::getDate);
        Stream<Post> twoWeeksPosts = userRepository.usersMap().get(userId).getPosts().
                stream().filter((post) -> !post.getDate().isBefore(twoWeeksBeforeDate));
        return twoWeeksPosts.sorted(dateDesc).collect(Collectors.toList());
    }

    @Override
    public boolean addPost(Post post)
    {
        User user;
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(post.getUserId()))
            return false;
        if (postMap().containsKey(post.getIdPost()))
            return false;

        user = userMap.get(post.getUserId());
        if (!user.addPost(post))
                return false;

        postList.add(post);
        return true;
    }

    private List<Post> getJsonData()
    {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:post.json");
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
        return posts;
    }
}
