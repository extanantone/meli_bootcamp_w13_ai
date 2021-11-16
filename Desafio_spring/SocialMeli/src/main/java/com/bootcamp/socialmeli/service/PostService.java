package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.UserWithPostsDTO;
import com.bootcamp.socialmeli.mapper.IMapper;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.repository.IProductRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    private final IPostRepository postRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;
    private final IMapper mapper;

    public PostService(IPostRepository postRepository, IProductRepository productRepository, IUserRepository userRepository, IMapper mapper) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public PostDTO getPost(long id) {
        return mapper.postToPostDTO(
                postRepository.getPost(id)
        );
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        productRepository.createProduct(mapper.productDTOToProduct(postDTO.getDetail()));
        Post postCreated = postRepository.createPost(mapper.postDTOToPost(postDTO));
        userRepository.getUser(postDTO.getUserId()).getPosts().add(postCreated);
        return mapper.postToPostDTO(postCreated);
    }

    @Override
    public UserWithPostsDTO getLatestFollowedPosts(long userId, int weeks) {
        List<PostDTO> posts = new ArrayList<>();
        User user = userRepository.getUser(userId);
        LocalDate now = LocalDate.now();
        for (User followedUser: user.getFollowed()) {
            List<PostDTO> followedUserPosts = followedUser.getPosts().stream().filter(
                    post -> !post.getDate().plusWeeks(weeks).isBefore(now)
            ).map(
                    mapper::postToPostDTO
            ).collect(Collectors.toList());
            posts.addAll(followedUserPosts);
        }
        return new UserWithPostsDTO(userId, posts);
    }

    @Override
    public List<PostDTO> orderPostsByDate(List<PostDTO> posts, String order) {
        posts.sort((p1, p2) -> {
            int ans = 0;
            LocalDate d1 = mapper.postDTOToPost(p1).getDate();
            LocalDate d2 = mapper.postDTOToPost(p2).getDate();
            if (d1.isBefore(d2)) {
                ans = -1;
            } else if (d2.isBefore(d1)) {
                ans = 1;
            }
            if (order.equals("desc")) {
                ans = -ans;
            }
            return ans;
        });
        return posts;
    }
}
