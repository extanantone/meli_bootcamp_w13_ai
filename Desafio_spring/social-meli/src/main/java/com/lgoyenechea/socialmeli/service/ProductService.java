package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.PostCreationDTO;
import com.lgoyenechea.socialmeli.dto.PostDTO;
import com.lgoyenechea.socialmeli.dto.UserFollowedListDTO;
import com.lgoyenechea.socialmeli.dto.UserFollowedPostsListDTO;
import com.lgoyenechea.socialmeli.dto.mapper.ProductMapper;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    public PostDTO save(PostCreationDTO newPost) {
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

    private boolean twoWeeksAgoCheck(LocalDate date) {
        return date.equals(LocalDate.now()) ||
                (date.isBefore(LocalDate.now()) &&
                date.isAfter(LocalDate.now().minusDays(14L)));
    }
}
