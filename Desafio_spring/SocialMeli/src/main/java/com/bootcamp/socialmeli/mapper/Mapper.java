package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class Mapper implements IMapper {

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
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes()
        );
    }

    @Override
    public PostDTO postToPostDTO(Post post, Product product) {
        return new PostDTO(
                post.getId(),
                post.getDate().toString(),
                post.getCategory(),
                post.getPrice(),
                post.getUserId(),
                this.productToProductDTO(product)
        );
    }

    @Override
    public Post postDTOToPost(PostDTO postDTO) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new Post(
                postDTO.getId(),
                LocalDate.parse(postDTO.getDate(), dateFormatter),
                postDTO.getCategory(),
                postDTO.getPrice(),
                postDTO.getUserId(),
                postDTO.getProduct().getId()
        );
    }
}
