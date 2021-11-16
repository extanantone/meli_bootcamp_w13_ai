package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.ProductDetailDTO;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.ProductDetail;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PostMapper implements IPostMapper{
    public Post postDTOToPost (PostDTO postDTO) {
        Post post = new Post();

        post.setId(postDTO.getIdPost());
        post.setUserId(postDTO.getUserId());
        post.setDate(postDTO.getDate());
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());

        ProductDetailDTO productDetailDTO = postDTO.getDetail();
        ProductDetail productDetail = this.productDetailDTOToProductDetail(productDetailDTO);
        post.setProductDetail(productDetail);

        return post;
    }

    private ProductDetail productDetailDTOToProductDetail(ProductDetailDTO productDetailDTO) {
        ProductDetail productDetail = new ProductDetail();

        productDetail.setId(productDetailDTO.getProductId());
        productDetail.setName(productDetailDTO.getProductName());
        productDetail.setType(productDetailDTO.getType());
        productDetail.setBrand(productDetailDTO.getBrand());
        productDetail.setColor(productDetailDTO.getColor());
        productDetail.setNotes(productDetailDTO.getNotes());

        return productDetail;
    }
}