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
    @Override
    public Post postDTOToPost (PostDTO postDTO) {
        Post post = new Post();

        post.setId(postDTO.getIdPost());
        post.setUserId(postDTO.getUserId());
        post.setDate(postDTO.getDate());
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());

        if (postDTO.isHasPromo()) {
            post.setHasPromo(true);
            post.setDiscount(postDTO.getDiscount());
        }

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

    public PostDTO postToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        postDTO.setIdPost(post.getId());
        postDTO.setUserId(post.getUserId());
        postDTO.setDate(post.getDate());
        postDTO.setCategory(post.getCategory());
        postDTO.setPrice(post.getPrice());

        if (post.isHasPromo()) {
            postDTO.setHasPromo(true);
            postDTO.setDiscount(post.getDiscount());
        }

        ProductDetail productDetail = post.getProductDetail();
        ProductDetailDTO productDetailDTO = this.productDetailToProductDetailDTO(productDetail);
        postDTO.setDetail(productDetailDTO);

        return postDTO;
    }

    private ProductDetailDTO productDetailToProductDetailDTO (ProductDetail productDetail) {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();

        productDetailDTO.setProductId(productDetail.getId());
        productDetailDTO.setProductName(productDetail.getName());
        productDetailDTO.setType(productDetail.getType());
        productDetailDTO.setBrand(productDetail.getBrand());
        productDetailDTO.setColor(productDetail.getColor());
        productDetailDTO.setNotes(productDetail.getNotes());

        return productDetailDTO;
    }


}