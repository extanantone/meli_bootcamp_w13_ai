package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.IllegalRequestParamException;
import com.bootcamp.socialmeli.exception.MissingBodyAttributeException;
import com.bootcamp.socialmeli.exception.MissingBodyException;
import com.bootcamp.socialmeli.exception.UserNotFoundException;
import com.bootcamp.socialmeli.mapper.PostMapper;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.util.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl  implements IPostService{

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private OrderUtils orderUtils;

    @Override
    public Long createPost(CreatePostDTO post) {
        if(post == null) throw new MissingBodyException();
        try {
            if(userRepository.getUser(post.getUserID()) == null) throw new UserNotFoundException(post.getUserID());
            return postRepository.savePost(postMapper.createPostDTOToPost(post),post.getUserID());
        } catch (NullPointerException e) {
            throw new MissingBodyAttributeException("Missing Body Attribute");
        }

    }

    @Override
    public Ordenable listFollowedPosts(Long userID, String order) {
        User user = userRepository.getUser(userID);
        if(user == null) throw new UserNotFoundException(userID);
        if(order == null) throw new IllegalRequestParamException("Valor ilegal para el request param order.");
        List<ListedPostDTO> posts = new LinkedList<>();
        user.getFollowed()
                .forEach(
                        x -> posts.addAll(
                                postMapper.postListToDTO(
                                        postRepository.getUserPosts(x.getUserId())
                                )
                        )
                );
        LocalDate minDate = LocalDate.now().minusWeeks(2);
        List<ListedPostDTO> filteredPosts = posts.stream().filter(x -> x.getDate().isAfter(minDate)).collect(Collectors.toList());
        return orderUtils.order(new ListedFollowedPostsDTO(userID, filteredPosts), order);
    }

    @Override
    public PromoCountDTO promoCountByUser(Long userID) {
        User user = userRepository.getUser(userID);
        if(user == null) throw new UserNotFoundException(userID);
        return new PromoCountDTO(
                user.getUserId(),
                user.getUserName(),
                postRepository.getUserPosts(userID).stream().filter(Post::getHasPromo).count()
        );
    }

    @Override
    public Ordenable listPromoPostsByUser(Long userID, String order) {
        User user = userRepository.getUser(userID);
        if(user == null) throw new UserNotFoundException(userID);
        if(order == null) throw new IllegalRequestParamException("Valor ilegal para el request param order.");
        List<ListedPostDTO> posts = postMapper.postListToDTO(postRepository.getUserPosts(userID).stream().filter(Post::getHasPromo).collect(Collectors.toList()));
        return orderUtils.order(new ListedPromoPostsDTO(user.getUserId(), user.getUserName(), posts), order);
    }
}
