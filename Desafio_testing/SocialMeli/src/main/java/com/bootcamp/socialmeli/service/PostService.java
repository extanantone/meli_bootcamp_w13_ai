package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.exceptions.BadRequestException;
import com.bootcamp.socialmeli.exceptions.NotFoundException;
import com.bootcamp.socialmeli.mapper.IMapper;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
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
    private final IUserService userService;
    private final IMapper mapper;

    public PostService(IPostRepository postRepository, IProductRepository productRepository, IUserRepository userRepository, IUserService userService, IMapper mapper) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    private void checkPostExistence(long id) {
        if (postRepository.getPost(id) == null) {
            throw new NotFoundException("Post Not Found");
        }
    }

    @Override
    public PostDTO getPost(long id) {
        checkPostExistence(id);
        return mapper.postToPostDTO(
                postRepository.getPost(id)
        );
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        if (postRepository.getPost(postDTO.getPostId()) != null) {
            throw new BadRequestException("Post already exists");
        }
        Product productToCreate = mapper.productDTOToProduct(postDTO.getDetail());
        if (productRepository.getProduct(productToCreate.getId()) != null) {
            throw new BadRequestException("Product already exists");
        }
        productRepository.createProduct(productToCreate);
        Post postCreated = postRepository.createPost(mapper.postDTOToPost(postDTO));
        userRepository.getUser(postDTO.getUserId()).getPosts().add(postCreated);
        return mapper.postToPostDTO(postCreated);
    }

    @Override
    public List<PostDTO> getLatestPosts(List<PostDTO> posts, int weeks) {
        LocalDate now = LocalDate.now();
        return posts.stream().filter(
                post -> !post.getDate().plusWeeks(weeks).isBefore(now)
        ).collect(Collectors.toList());
    }

    @Override
    public UserWithPostsDTO getLatestFollowedPosts(long userId, int weeks) {
        userService.checkUserExistence(userId);
        List<PostDTO> posts = new ArrayList<>();
        User user = userRepository.getUser(userId);
        for (User followedUser: user.getFollowed()) {
            posts.addAll(followedUser.getPosts().stream().map(
                    mapper::postToPostDTO).collect(Collectors.toList())
            );
        }
        posts = getLatestPosts(posts, weeks);
        return new UserWithPostsDTO(userId, posts);
    }

    @Override
    public List<PostDTO> orderPostsByDate(List<PostDTO> posts, String order) {
        posts.sort((p1, p2) -> {
            int ans = 0;
            LocalDate d1 = p1.getDate();
            LocalDate d2 = p2.getDate();
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

    @Override
    public PromoPostDTO getPromoPost(long id) {
        checkPostExistence(id);
        return mapper.postToPromoPostDTO(postRepository.getPost(id));
    }

    @Override
    public PromoPostDTO createPromoPost(PromoPostDTO promoPostDTO) {
        if (postRepository.getPost(promoPostDTO.getPostId()) != null) {
            throw new BadRequestException("Post already exists");
        }
        Product productToCreate = mapper.productDTOToProduct(promoPostDTO.getDetail());
        if (productRepository.getProduct(productToCreate.getId()) != null) {
            throw new BadRequestException("Product already exists");
        }
        productRepository.createProduct(productToCreate);
        Post postCreated = postRepository.createPost(mapper.promoPostDTOToPost(promoPostDTO));
        userRepository.getUser(promoPostDTO.getUserId()).getPosts().add(postCreated);
        return mapper.postToPromoPostDTO(postCreated);
    }

    @Override
    public UserWithCountDTO getUserWithPromoPostCount(long id) {
        userService.checkUserExistence(id);
        User user = userRepository.getUser(id);
        return new UserWithCountDTO(
                user.getId(),
                user.getUsername(),
                getUserWithPromoPosts(id).getPosts().size()
        );
    }

    @Override
    public UserWithPromoPostsDTO getUserWithPromoPosts(long id) {
        userService.checkUserExistence(id);
        User user = userRepository.getUser(id);
        List<PromoPostDTO> promoPosts = user.getPosts().stream().filter(
                Post::hasPromo
        ).map(
                mapper::postToPromoPostDTO
        ).collect(Collectors.toList());
        return new UserWithPromoPostsDTO(id, promoPosts);
    }
}
