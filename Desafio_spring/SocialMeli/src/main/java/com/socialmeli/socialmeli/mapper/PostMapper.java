package com.socialmeli.socialmeli.mapper;

import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.dto.post.PostWithoutDiscountDTO;
import com.socialmeli.socialmeli.dto.post.ProductDTO;
import com.socialmeli.socialmeli.model.Post;
import com.socialmeli.socialmeli.model.Product;
import org.springframework.stereotype.Component;

@Component
public  class PostMapper {

    public Product productDTOToProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(),productDTO.getProduct_name(),productDTO.getType(),productDTO.getBrand(),productDTO.getColor(),productDTO.getNotes());
    }
    public ProductDTO productToProductDTO(Product product){
        return new ProductDTO(product.getProduct_id(),product.getProduct_name(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }

    public Post postDTOToPost(PostDTO postDTO){
        Post post = new Post(postDTO.getUser_id(),postDTO.getId_post(),postDTO.getDate(),productDTOToProduct(postDTO.getDetail()),postDTO.getCategory(),postDTO.getPrice(),postDTO.isHas_promo(),postDTO.getDiscount());
        return post;
    }

    public PostDTO postDTOToPost(Post post){
        return new PostDTO(post.getUser_id(),post.getId_post(),post.getDate(),productToProductDTO(post.getDetail()),post.getCategory(),post.getPrice(),post.isHas_promo(),post.getDiscount());
    }

    public PostWithoutDiscountDTO postDTOToPostWithoutDiscount(PostDTO postDTO){
        return new PostWithoutDiscountDTO(postDTO.getUser_id(), postDTO.getId_post(), postDTO.getDate(), postDTO.getDetail(), postDTO.getCategory(), postDTO.getPrice());
    }
    public PostWithoutDiscountDTO postDTOToPostWithoutDiscount(Post post){
        return new PostWithoutDiscountDTO(post.getUser_id(), post.getId_post(), post.getDate(),productToProductDTO(post.getDetail()), post.getCategory(), post.getPrice());
    }

}
