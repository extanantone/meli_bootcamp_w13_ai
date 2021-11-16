package com.example.socialmeli.demo.mapper;

import com.example.socialmeli.demo.dto.controllerToService.DTOPost;
import com.example.socialmeli.demo.dto.controllerToService.DTOProduct;
import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import com.example.socialmeli.demo.model.Post;
import com.example.socialmeli.demo.model.Product;
import com.example.socialmeli.demo.model.PromoPost;
import org.springframework.stereotype.Component;

@Component
public class PromoMapper {

    public static DTOPromoPost PostTODtoPost(PromoPost p){

        DTOPromoPost post = new DTOPromoPost();
        post.setIdPost(p.getIdPost());
        post.setUserId(p.getUserId());
        post.setCategory(p.getCategory());
        post.setHasPromo(p.hasPromo());
        post.setDiscount(p.hasDiscount());
        post.setDate(p.getDate());
        post.setPrice(p.getPrice());


        DTOProduct productDTO = new DTOProduct();
        productDTO = ProductMapper.convertProductTODTOProduct(p.getDetail());

        post.setDetail(productDTO);

        return post;
    }

    public static DTOPromoPost PostToDtoPromoPost (Post p){

        DTOPromoPost post = new DTOPromoPost();
        post.setIdPost(p.getIdPost());
        post.setUserId(p.getUserId());
        post.setCategory(p.getCategory());
        post.setHasPromo(p.hasPromo());
        post.setDiscount(p.hasDiscount());
        post.setDate(p.getDate());
        post.setPrice(p.getPrice());

        DTOProduct productDTO = new DTOProduct();
        productDTO = ProductMapper.convertProductTODTOProduct(p.getDetail());

        post.setDetail(productDTO);

        return post;
    }

    public static PromoPost DtoPostToPost(DTOPromoPost p){

        PromoPost post = new PromoPost();
        post.setIdPost(p.getIdPost());
        post.setUserId(p.getUserId());
        post.setCategory(p.getCategory());
        post.setPromo(p.isHasPromo());
        post.setDiscount(p.getDiscount());
        post.setDate(p.getDate());
        post.setPrice(p.getPrice());

        Product product = new Product();
        product = ProductMapper.convertDTOProductToProduct(p.getDetail());

        post.setDetail(product);

        return post;


    }




}
