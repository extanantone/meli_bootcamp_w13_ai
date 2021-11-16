package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IProductRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class Mapper implements IMapper {

    private final IProductRepository productRepository;
    DateTimeFormatter dateFormatter;

    public Mapper(IProductRepository productRepository) {
        this.productRepository = productRepository;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }


    @Override
    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername());
    }

    @Override
    public User userCreationDTOToUser(UserCreationDTO userCreationDTO) {
        return new User(userCreationDTO.getUsername(), userCreationDTO.getEmail(), userCreationDTO.getPassword());
    }

    @Override
    public UserWithFollowersDTO userToUserWithFollowersDTO(User user) {
        return new UserWithFollowersDTO(
                user.getId(),
                user.getUsername(),
                user.getFollowers().stream().map(this::userToUserDTO).collect(Collectors.toList())
        );
    }

    @Override
    public UserWithFollowedDTO userToUserWithFollowedDTO(User user) {
        return new UserWithFollowedDTO(
                user.getId(),
                user.getUsername(),
                user.getFollowed().stream().map(this::userToUserDTO).collect(Collectors.toList())
        );
    }

    @Override
    public ProductDTO productToProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    @Override
    public Product productDTOToProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes()
        );
    }

    @Override
    public PostDTO postToPostDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getDate().format(dateFormatter),
                post.getCategory(),
                post.getPrice(),
                post.getUserId(),
                this.productToProductDTO(productRepository.getProduct(post.getProductId()))
        );
    }

    @Override
    public Post postDTOToPost(PostDTO postDTO) {
        return new Post(
                postDTO.getPostId(),
                LocalDate.parse(postDTO.getDate(), dateFormatter),
                postDTO.getCategory(),
                postDTO.getPrice(),
                postDTO.getUserId(),
                postDTO.getDetail().getProductId()
        );
    }
}
