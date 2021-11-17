package com.example.socialmeli.demo.mapper;

import com.example.socialmeli.demo.dto.controllerToService.DTOPost;
import com.example.socialmeli.demo.dto.controllerToService.DTOProduct;
import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import com.example.socialmeli.demo.dto.serviceToController.DTOPostFollowers;
import com.example.socialmeli.demo.model.Post;
import com.example.socialmeli.demo.model.Product;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {


    public static DTOPost PostTODtoPost(Post p){

        DTOPost post = new DTOPost();
        post.setIdPost(p.getIdPost());
        post.setUserId(p.getUserId());
        post.setCategory(p.getCategory());
        post.setDate(p.getDate());
        post.setPrice(p.getPrice());

        DTOProduct productDTO = new DTOProduct();
        productDTO = ProductMapper.convertProductTODTOProduct(p.getDetail());
        post.setDetail(productDTO);

        return post;
    }


    public static Post DtoPostToPost(DTOPost p){

        Post post = new Post();
        post.setIdPost(p.getIdPost());
        post.setUserId(p.getUserId());
        post.setCategory(p.getCategory());
        post.setDate(p.getDate());
        post.setPrice(p.getPrice());

        Product product = new Product();
        product = ProductMapper.convertDTOProductToProduct(p.getDetail());
        post.setDetail(product);

        return post;
    }


    public static DTOPostFollowers PostToDtoPostFollowers(Post p){

        DTOPostFollowers dtoPostFollowers = new DTOPostFollowers();
        dtoPostFollowers.setIdPost(p.getIdPost());
        dtoPostFollowers.setCategory(p.getCategory());
        dtoPostFollowers.setDate(p.getDate());
        dtoPostFollowers.setPrice(p.getPrice());

        DTOProduct productDTO = new DTOProduct();
        productDTO = ProductMapper.convertProductTODTOProduct(p.getDetail());

        dtoPostFollowers.setDetail(productDTO);

        return dtoPostFollowers;

    }




}
