package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.dto.ResponsePostDTO;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;


public interface IProductService {

    void postProduct(RequestPostDTO requestPostDTO) throws NotPossibleOperationException;

    ResponsePostDTO getProductsFollowed(int userId, String order) throws NotPossibleOperationException;
}
