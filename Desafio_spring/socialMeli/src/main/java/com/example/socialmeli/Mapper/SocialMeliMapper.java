package com.example.socialmeli.Mapper;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.ProductDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SocialMeliMapper {

    public UserDto userToUserDto (User user){
        return new UserDto(user.getUserId(),user.getUserName());
    }

    public PostDto postToPostDto (Post post){
        return new PostDto(post.getUserId(),post.getPostId(),post.localDateToString(),post.getCategory(),post.getHasPromo(),post.getDiscount(),post.getPrice(),this.productDtoToProduct(post.getDetail()));
    }

    public Post postDtoToPost (PostDto post){
        return new Post(post.getUserId(),post.stringToLocalDate(),post.getCategory(),post.getHasPromo(),post.getDiscount(),post.getPrice(),this.productToProductDto(post.getDetail()));
    }

    public Product productToProductDto(ProductDto productDto){
        return new Product(productDto.getProductId(),productDto.getProductName(),productDto.getType(),productDto.getBrand(),productDto.getColor(),productDto.getNotes());
    }

    public ProductDto productDtoToProduct(Product product){
        return new ProductDto(product.getProductId(),product.getProductName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }

    public List<UserDto> userToUserDto (List<User> users){
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach(user ->{
           usersDto.add(this.userToUserDto(user));
        });
        return usersDto;
    }

    public List<PostDto> postListToPostDtoList (List<Post> posts){
        List<PostDto> postsDto = new ArrayList<>();
        posts.forEach((Post post) ->{
            PostDto postDto = this.postToPostDto(post);
            postsDto.add(postDto);
        });
        return postsDto;
    }
}
