package com.SocialMeli.SocialMeli.mapper;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.entity.Post;
import com.SocialMeli.SocialMeli.entity.Product;

public class PostMapper {
    public static Post postDTOToPost(PostDTO postDTO){
        Post post = new Post();
        post.setId(postDTO.getId_post());
        post.setSellerId(postDTO.getUser_id());
        post.setDate(postDTO.getDate());
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());
        post.setDetail(PostMapper.productDTOToProduct(postDTO.getDetail()));
        return post;
    }

    public static Product productDTOToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getProduct_id());
        product.setName(productDTO.getProduct_name());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setType(productDTO.getType());
        product.setNotes(productDTO.getNotes());
        return product;
    }

    public static PostDTO postToPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId_post(post.getId());
        postDTO.setUser_id(post.getSellerId());
        postDTO.setCategory(post.getCategory());
        postDTO.setDate(post.getDate());
        postDTO.setCategory(post.getCategory());
        postDTO.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        return postDTO;
    }

    public static ProductDTO productToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(product.getId());
        productDTO.setProduct_name(product.getName());
        productDTO.setBrand(product.getBrand());
        productDTO.setColor(product.getColor());
        productDTO.setType(product.getType());
        productDTO.setNotes(product.getNotes());
        return productDTO;
    }

    public static PostListDTO postToPostListDTO(Post post){
        PostListDTO postListDTO = new PostListDTO();
        postListDTO.setId_post(post.getId());
        postListDTO.setDate(post.getDate());
        postListDTO.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        postListDTO.setCategory(post.getCategory());
        postListDTO.setPrice(post.getPrice());
        return postListDTO;
    }

    public static Post postPromoDTOToPost(PostPromoDTO postPromoCreateDTO){
        Post post = new Post();
        post.setId(postPromoCreateDTO.getId_post());
        post.setDate(postPromoCreateDTO.getDate());
        post.setSellerId(postPromoCreateDTO.getUser_id());
        post.setCategory(postPromoCreateDTO.getCategory());
        post.setPrice(postPromoCreateDTO.getPrice());
        post.setDetail(PostMapper.productDTOToProduct(postPromoCreateDTO.getDetail()));
        post.setHas_promo(postPromoCreateDTO.isHas_promo());
        post.setDiscount(postPromoCreateDTO.getDiscount());
        return post;
    }

    public static PostPromoDTO postToPostPromoDTO(Post post){
        PostPromoDTO postPromoDTO = new PostPromoDTO();
        postPromoDTO.setId_post(post.getId());
        postPromoDTO.setUser_id(post.getSellerId());
        postPromoDTO.setCategory(post.getCategory());
        postPromoDTO.setDate(post.getDate());
        postPromoDTO.setPrice(post.getPrice());
        postPromoDTO.setHas_promo(post.isHas_promo());
        postPromoDTO.setDiscount(post.getDiscount());
        postPromoDTO.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        return postPromoDTO;
    }

    public static PostPromoListDTO postToPostPromoListDTO(Post post){
        PostPromoListDTO postPromoListDTO = new PostPromoListDTO();
        postPromoListDTO.setId_post(post.getId());
        postPromoListDTO.setDate(post.getDate());
        postPromoListDTO.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        postPromoListDTO.setCategory(post.getCategory());
        postPromoListDTO.setPrice(post.getPrice());
        postPromoListDTO.setHas_promo(post.isHas_promo());
        postPromoListDTO.setDiscount(post.getDiscount());
        return postPromoListDTO;
    }
}
