package com.example.socialmeli.services;

import com.example.socialmeli.dto.DTORequest.DTOproductsRequest;
import com.example.socialmeli.dto.DTOResponses.DTOResponseAmountUser;
import com.example.socialmeli.dto.DTOResponses.DTOResponseProduct;
import com.example.socialmeli.dto.DTOResponses.DTOEmptyJsonResponse;

public interface IProductServices {

    DTOEmptyJsonResponse createProduct(DTOproductsRequest request);

    DTOEmptyJsonResponse createProductPromo(DTOproductsRequest request);

    DTOResponseProduct getFeedProducts(Integer user_id, String order);

    DTOResponseAmountUser getAmountProductsPromo(Integer user_id);

    DTOResponseProduct getPromos(Integer user_id, String order);
}
