package com.SocialMeli.SocialMeli.mapper;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.entity.Post;
import com.SocialMeli.SocialMeli.entity.Product;

public class PostMapper {
    public static Post postDTORequestToPost(PostDTORequest postDTORequest){
        Post post = new Post();
        post.setId(postDTORequest.getId_post());
        post.setSellerId(postDTORequest.getUser_id());
        post.setDate(postDTORequest.getDate());
        post.setCategory(postDTORequest.getCategory());
        post.setPrice(postDTORequest.getPrice());
        post.setDetail(PostMapper.productDTOToProduct(postDTORequest.getDetail()));
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

    public static PostDTORequest postToPostDTO(Post post){
        PostDTORequest postDTORequest = new PostDTORequest();
        postDTORequest.setId_post(post.getId());
        postDTORequest.setUser_id(post.getSellerId());
        postDTORequest.setCategory(post.getCategory());
        postDTORequest.setDate(post.getDate());
        postDTORequest.setCategory(post.getCategory());
        postDTORequest.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        return postDTORequest;
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

    public static PostListItemDTOResponse postToPostListDTO(Post post){
        PostListItemDTOResponse postListItemDTOResponse = new PostListItemDTOResponse();
        postListItemDTOResponse.setId_post(post.getId());
        postListItemDTOResponse.setDate(post.getDate());
        postListItemDTOResponse.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        postListItemDTOResponse.setCategory(post.getCategory());
        postListItemDTOResponse.setPrice(post.getPrice());
        return postListItemDTOResponse;
    }

    public static Post postPromoDTOToPost(PostPromoDTORequest postPromoCreateDTO){
        Post post = new Post();
        post.setId(postPromoCreateDTO.getId_post());
        post.setDate(postPromoCreateDTO.getDate());
        post.setSellerId(postPromoCreateDTO.getUser_id());
        post.setCategory(postPromoCreateDTO.getCategory());
        post.setPrice(postPromoCreateDTO.getPrice());
        post.setDetail(PostMapper.productDTOToProduct(postPromoCreateDTO.getDetail()));
        post.setHas_promo(postPromoCreateDTO.getHas_promo());
        post.setDiscount(postPromoCreateDTO.getDiscount());
        return post;
    }

    public static PostPromoDTORequest postToPostPromoDTO(Post post){
        PostPromoDTORequest postPromoDTORequest = new PostPromoDTORequest();
        postPromoDTORequest.setId_post(post.getId());
        postPromoDTORequest.setUser_id(post.getSellerId());
        postPromoDTORequest.setCategory(post.getCategory());
        postPromoDTORequest.setDate(post.getDate());
        postPromoDTORequest.setPrice(post.getPrice());
        postPromoDTORequest.setHas_promo(post.isHas_promo());
        postPromoDTORequest.setDiscount(post.getDiscount());
        postPromoDTORequest.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        return postPromoDTORequest;
    }

    public static PostPromoListItemDTOResponse postToPostPromoListDTO(Post post){
        PostPromoListItemDTOResponse postPromoListItemDTOResponse = new PostPromoListItemDTOResponse();
        postPromoListItemDTOResponse.setId_post(post.getId());
        postPromoListItemDTOResponse.setDate(post.getDate());
        postPromoListItemDTOResponse.setDetail(PostMapper.productToProductDTO(post.getDetail()));
        postPromoListItemDTOResponse.setCategory(post.getCategory());
        postPromoListItemDTOResponse.setPrice(post.getPrice());
        postPromoListItemDTOResponse.setHas_promo(post.isHas_promo());
        postPromoListItemDTOResponse.setDiscount(post.getDiscount());
        return postPromoListItemDTOResponse;
    }
}
