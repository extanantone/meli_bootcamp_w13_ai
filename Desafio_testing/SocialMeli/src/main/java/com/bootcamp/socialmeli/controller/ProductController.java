package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.dto.ResponsePostDTO;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping("/post")
    public void postProduct(
            @Valid @RequestBody RequestPostDTO postDTO) throws NotPossibleOperationException{
        
        iProductService.postProduct(postDTO);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<ResponsePostDTO> getProductsFollowed(
            @PathVariable("user_id") int userId,
            @RequestParam(required = false) String order) throws NotPossibleOperationException {

        return new ResponseEntity<>(iProductService.getProductsFollowed(userId, order), HttpStatus.OK);

    }
}
