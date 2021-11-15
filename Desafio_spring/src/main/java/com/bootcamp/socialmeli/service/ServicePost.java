package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.DTOCountpromo;
import com.bootcamp.socialmeli.DTO.DTOPostProduct;
import com.bootcamp.socialmeli.DTO.DTOPromoPost;
import com.bootcamp.socialmeli.DTO.DTOPublishFollowed;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                postProduct.getPrice(),
                false,
                0.0);

        if(!iPostRepository.addPost(post))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity createPostPromo(DTOPostProduct postProduct) {

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
                postProduct.getPrice(),
                true,
                postProduct.getDiscount());

        if(!iPostRepository.addPost(post))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity countPostPromo(int userId) {

        try{

            User user = iUserRepository.findById(userId);

            List<Post> postList = iPostRepository.getPost(userId);

            int count = 0;

            for (Post p: postList) {
                if(p.getHasPromo())
                    count++;
            }

            return new ResponseEntity(new DTOCountpromo(userId,user.getUserName(),count), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity("Error: Usuario inexistente", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity getPostPromo(int userId) {

        List<Post> posts = new ArrayList<>();

        try{

            User user = iUserRepository.findById(userId);

            posts = iPostRepository.getPromoPost(userId);

            return new ResponseEntity(new DTOPromoPost(userId,user.getUserName(),posts),HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity("Error: Usuario inexistente", HttpStatus.BAD_REQUEST);
        }
    }

}
