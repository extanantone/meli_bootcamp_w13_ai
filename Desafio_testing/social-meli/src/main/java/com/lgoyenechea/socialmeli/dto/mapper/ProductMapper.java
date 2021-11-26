package com.lgoyenechea.socialmeli.dto.mapper;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.model.Product;
import com.lgoyenechea.socialmeli.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Post postCreationDtoToPost(PostCreationDTO dto) {
        Post post = new Post();
        post.setUserId(dto.getUserId());
        post.setDate(LocalDate.parse(dto.getDate(), DATE_TIME_FORMATTER));
        post.setDetail(productCreationDtoToProduct(dto.getDetail()));
        post.setCategory(dto.getCategory());
        post.setPrice(dto.getPrice());
        return post;
    }

    public static Product productCreationDtoToProduct(ProductCreationDTO dto) {
        Product product = new Product();
        product.setName(dto.getProductName());
        product.setType(dto.getType());
        product.setBrand(dto.getBrand());
        product.setColor(dto.getColor());
        product.setNotes(dto.getNotes());
        return product;
    }

    public static PostDTO postToDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setIdPost(post.getId());
        dto.setUserId(post.getUserId());
        dto.setCategory(post.getCategory());
        dto.setDate(post.getDate().format(DATE_TIME_FORMATTER));
        dto.setPrice(post.getPrice());
        dto.setDetail(productToDto(post.getDetail()));
        return dto;
    }

    public static ProductDTO productToDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getId());
        dto.setProductName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setColor(product.getColor());
        dto.setNotes(product.getNotes());
        dto.setType(product.getType());
        return dto;
    }

    public static UserFollowedPostsListDTO productToFollowedPostListDto(Long userId, List<Post> posts) {
        UserFollowedPostsListDTO followedPostsListDto = new UserFollowedPostsListDTO();
        followedPostsListDto.setUserId(userId);
        List<PostDTO> postsDto = posts.stream()
                .map(ProductMapper::postToDto)
                .collect(Collectors.toList());
        followedPostsListDto.setPosts(postsDto);
        return followedPostsListDto;
    }

    public static Post postCreationWithPromoDtoToPost(PostCreationPromoDTO dto) {
        Post post = new Post();
        post.setUserId(dto.getUserId());
        post.setDate(LocalDate.parse(dto.getDate(), DATE_TIME_FORMATTER));
        post.setDetail(productCreationDtoToProduct(dto.getDetail()));
        post.setCategory(dto.getCategory());
        post.setPrice(dto.getPrice());
        post.setHasPromo(dto.getHasPromo());
        post.setDiscount(dto.getDiscount());
        return post;
    }

    public static PostPromoDTO postToPromoDto(Post post) {
        PostPromoDTO dto = new PostPromoDTO();
        dto.setIdPost(post.getId());
        dto.setUserId(post.getUserId());
        dto.setCategory(post.getCategory());
        dto.setDate(post.getDate().format(DATE_TIME_FORMATTER));
        dto.setPrice(post.getPrice());
        dto.setDetail(productToDto(post.getDetail()));
        dto.setHasPromo(post.getHasPromo());
        dto.setDiscount(post.getDiscount());
        return dto;
    }

    public static UserPromoPostCountDTO userToPromoPostCountDto(User user, int count) {
        UserPromoPostCountDTO dto = new UserPromoPostCountDTO();
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        dto.setPromoProductsCount(count);
        return dto;
    }

    public static UserPostsPromoListDTO userPostPromoListToDto(User user, List<PostDTO> posts) {
        UserPostsPromoListDTO dto = new UserPostsPromoListDTO();
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        dto.setPosts(posts);
        return dto;
    }
}
