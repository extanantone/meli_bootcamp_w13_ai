package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.DTOPostProduct;
import org.springframework.http.ResponseEntity;

public interface IServicePost {

    ResponseEntity createPost(DTOPostProduct postProduct);

    ResponseEntity createPostPromo(DTOPostProduct postProduct);

    ResponseEntity countPostPromo(int userId);

    ResponseEntity getPostPromo(int userId);

}
