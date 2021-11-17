package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.dto.mapper.ProductMapper;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.exception.UserDoesNotExistsException;
import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.model.User;
import com.lgoyenechea.socialmeli.repository.ProductRepository;
import com.lgoyenechea.socialmeli.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    private final String USER_ID_ERROR = "User with id %s does not exists";

    public ProductService(ProductRepository productRepository, UserRepository userRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public PostDTO save(PostCreationDTO newPost) throws UserDoesNotExistsException {
        if (!userRepository.existsById(newPost.getUserId()))
            throw new UserDoesNotExistsException(
                    String.format(USER_ID_ERROR, newPost.getUserId()));

        Post post = productRepository.save(ProductMapper.postCreationDtoToPost(newPost));
        return ProductMapper.postToDto(post);
    }

    public UserFollowedPostsListDTO followedPostsList(Long userId, String order) throws UserArgumentNotValidException {
        UserFollowedListDTO userFollowedList = userService.followedList(userId, "name_asc");

        List<Post> posts = userFollowedList.getFollowed().stream()
                .map(userDTO -> productRepository.getByUserId(userDTO.getUserId()))
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .stream()
                .filter(post -> twoWeeksAgoCheck(post.getDate()))
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());

        if (order.equals("date_desc"))
            posts = posts.stream()
                    .sorted(Comparator.comparing(Post::getDate).reversed())
                    .collect(Collectors.toList());

        return ProductMapper.productToFollowedPostListDto(userId, posts);
    }

    public PostPromoDTO saveWithPromo(PostCreationPromoDTO newPost) throws UserDoesNotExistsException {
        if (!userRepository.existsById(newPost.getUserId()))
            throw new UserDoesNotExistsException(
                    String.format(USER_ID_ERROR, newPost.getUserId()));

        Post post = productRepository.save(ProductMapper.postCreationWithPromoDtoToPost(newPost));
        return ProductMapper.postToPromoDto(post);
    }

    public UserPromoPostCountDTO promoPostCount(Long userId) throws UserDoesNotExistsException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserDoesNotExistsException(
                String.format(USER_ID_ERROR, userId));

        int count = (int) productRepository.getByUserId(userId)
                .stream()
                .filter(Post::getHasPromo)
                .count();

        return ProductMapper.userToPromoPostCountDto(user, count);
    }

    public UserPostsPromoListDTO postsPromoList(Long userId) throws UserDoesNotExistsException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserDoesNotExistsException(
                String.format(USER_ID_ERROR, userId));

        List<PostDTO> posts = productRepository.getByUserId(userId)
                .stream()
                .filter(post -> post.getHasPromo() != null && post.getHasPromo())
                .map(ProductMapper::postToDto)
                .collect(Collectors.toList());

        return ProductMapper.userPostPromoListToDto(user, posts);
    }

    private boolean twoWeeksAgoCheck(LocalDate date) {
        return date.equals(LocalDate.now()) ||
                (date.isBefore(LocalDate.now()) &&
                        date.isAfter(LocalDate.now().minusDays(14L)));
    }
}
