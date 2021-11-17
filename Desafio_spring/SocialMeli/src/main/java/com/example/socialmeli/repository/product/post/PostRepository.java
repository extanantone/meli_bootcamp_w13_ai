package com.example.socialmeli.repository.product.post;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
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

    @Autowired
    IUserRepository userRepository;

    private List<Post> postList;

    @Override
    public List<Post> findPromoPosts(Integer userId)
    {
        return userRepository.usersMap().get(userId).getPosts().stream().filter(Post::isHasPromo).collect(Collectors.toList());
    }

    @Override
    public List<Post> findPromoPostOrderByProductNameAsc(Integer userId)
    {
        Comparator<Post> nameAsc = Comparator.comparing(post -> post.getDetail().getProductName());
        return findPromoPosts(userId).stream().sorted(nameAsc).collect(Collectors.toList());
    }

    @Override
    public List<Post> findPromoPostsOrderByProductNameDesc(Integer userId)
    {
        Comparator<Post> nameAsc = Comparator.comparing(post -> post.getDetail().getProductName());
        return findPromoPosts(userId).stream().sorted(nameAsc.reversed()).collect(Collectors.toList());
    }

    public PostRepository()
    {
        this.postList = new LinkedList<>();
    }

    @Override
    public Map<Integer, Post> postMap()
    {
        return postList.stream().collect(Collectors.toMap(Post::getIdPost, post -> post));
    }

    private Stream<Post> getTwoWeeksPosts(Integer userId)
    {

        LocalDate twoWeeksBeforeDate = LocalDate.now().minusWeeks(2);
        Stream<Post> followedPosts = userRepository.usersMap().get(userId).getFollowed().stream().flatMap(x -> x.getPosts().stream());
        return (followedPosts.filter((post) -> !post.getDate().isBefore(twoWeeksBeforeDate)));
    }

    @Override
    public List<Post> findFollowedTwoWeeksBeforeOrderByDateDesc(Integer userId)
    {
        Comparator<Post> dateDesc = Comparator.comparing(Post::getDate).reversed();
        return getTwoWeeksPosts(userId).sorted(dateDesc).collect(Collectors.toList());
    }

    @Override
    public List<Post> findFollowedTwoWeeksBeforeOrderByDateAsc(Integer userId)
    {
        Comparator<Post> dateAsc = Comparator.comparing(Post::getDate);
        return getTwoWeeksPosts(userId).sorted(dateAsc).collect(Collectors.toList());
    }

    @Override
    public boolean createPost(Post post)
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

}
