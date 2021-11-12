package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.DTOPostProduct;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicePost implements IServicePost{

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserRepository iUserRepository;

    public ResponseEntity createPost(DTOPostProduct postProduct) {

        iUserRepository.findById(postProduct.getUserId());

        Product product = new Product(postProduct.getDetail().getProductId(),
                postProduct.getDetail().getProductName(),
                postProduct.getDetail().getType(),
                postProduct.getDetail().getBrand(),
                postProduct.getDetail().getColor(),
                postProduct.getDetail().getNotes());

        Post post = new Post(postProduct.getUserId(),
                postProduct.getIdPost(),
                postProduct.getDate(),
                product,
                postProduct.getCategory(),
                postProduct.getPrice());

        if(!iPostRepository.addPost(post))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(HttpStatus.OK);
    }

}
