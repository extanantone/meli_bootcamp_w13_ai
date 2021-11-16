package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;

public interface IMapper {

    public UserDTO userToUserDTO(User user);
    public User userCreationDTOToUser(UserCreationDTO userCreationDTO);
    public UserWithFollowersDTO userToUserWithFollowersDTO(User user);
    public UserWithFollowedDTO userToUserWithFollowedDTO(User user);
    public ProductDTO productToProductDTO(Product product);
    public Product productDTOToProduct(ProductDTO productDTO);
    public PostDTO postToPostDTO(Post post);
    public Post postDTOToPost(PostDTO postDTO);
}
