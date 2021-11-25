package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.CreatePostDTO;
import com.bootcamp.socialmeli.dto.ListedPostDTO;
import com.bootcamp.socialmeli.dto.ProductDTO;
import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.entity.Product;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    public Post createPostDTOToPost(CreatePostDTO dto){
        return new Post(
                null,
                dto.getDate(),
                productDTOToProduct(dto.getDetail()),
                dto.getCategory(),
                dto.getPrice(),
                dto.getHasPromo() != null && dto.getHasPromo(),
                dto.getDiscount() != null ? dto.getDiscount() : 0.
        );
    }

    public List<ListedPostDTO> postListToDTO(List<Post> posts){
        return posts.stream().map(this::postToListedPostDTO).collect(Collectors.toCollection(LinkedList::new));
    }

    public ListedPostDTO postToListedPostDTO(Post post){
        return new ListedPostDTO(
                post.getPostId(),
                post.getDate(),
                productToProductDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }

    public ProductDTO productToProductDTO(Product product){
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public Product productDTOToProduct(ProductDTO dto){
        return new Product(
                dto.getProductId(),
                dto.getProductName(),
                dto.getType(),
                dto.getBrand(),
                dto.getColor(),
                dto.getNotes()
        );
    }
}
