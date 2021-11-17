package com.example.socialmeli.services;

import ch.qos.logback.core.util.InvocationGate;
import com.example.socialmeli.Models.Product;
import com.example.socialmeli.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface IUsersServices {

    EmptyJsonResponse followUser(Integer current, Integer action);

    EmptyJsonResponse unFollow(Integer current, Integer action);

    DTOResponseAmountUser getAmountFollowers(Integer i);

    DTOResponseListUser getListFollowers(Integer i, String order);

    DTOResponseListUserFollowed getListFollowed(Integer i, String order);

    EmptyJsonResponse createProduct( DTOproductsRequest request);

    DTOResponseProduct getFeedProducts(Integer user_id, String order);


}
