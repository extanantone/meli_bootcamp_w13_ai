package com.socialmeli.demo.service;

import com.socialmeli.demo.dto.PostDTO;
import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;
import com.socialmeli.demo.exceptions.BadRequestException;
import com.socialmeli.demo.exceptions.UserNotFoundException;
import com.socialmeli.demo.mapper.PostMapper;
import com.socialmeli.demo.model.Post;
import com.socialmeli.demo.model.User;
import com.socialmeli.demo.repository.PostRepository;
import com.socialmeli.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public PostDTO addPost(PostDTO postDTO) {

        User user = this.userRepository.findUserById(postDTO.getUserId());

        if(user == null) throw new UserNotFoundException(postDTO.getUserId());

        if(this.postRepository.findPostById(postDTO.getPostId()) != null) throw new BadRequestException(
                "The post with id: " + postDTO.getPostId() + " already exist."
        );

        Post post = this.postMapper.postDTOToPost(postDTO);

        this.postRepository.createPost(post);
        user.getPosts().add(post);

        return postDTO;
    }

    @Override
    public UserWithFollowedPostsListDTO getUserWithFollowedPosts(Integer id, String order) {

        User user = this.userRepository.findUserById(id);

        if(user == null) throw new UserNotFoundException(id);

        List<User> followedList = user.getFollowed();
        List<PostDTO> postDTOS = new LinkedList<>();
        LocalDate today = LocalDate.now();

        for (User followed : followedList){
            List<PostDTO> followedUserPosts = followed.getPosts().stream().filter(
                    post -> !post.getDate().plusWeeks(2).isBefore(today)
            ).map(
                    this.postMapper::postToPostDTO
            ).collect(Collectors.toList());

            postDTOS.addAll(followedUserPosts);
        }

        if(order != null){

            Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate);

            if(order.equals("date_desc")){
                comparator = comparator.reversed();
            }

            postDTOS.sort(comparator);
        }

        return new UserWithFollowedPostsListDTO(id, postDTOS);
    }
}
