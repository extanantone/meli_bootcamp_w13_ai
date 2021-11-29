package com.example.socialmeli.services;
import com.example.socialmeli.dto.DTOResponses.DTOResponseAmountUser;
import com.example.socialmeli.dto.DTOResponses.DTOResponseListUser;
import com.example.socialmeli.dto.DTOResponses.DTOEmptyJsonResponse;


public interface IUsersServices {

    DTOEmptyJsonResponse followUser(Integer current, Integer action);

    DTOEmptyJsonResponse unFollow(Integer current, Integer action);

    DTOResponseAmountUser getAmountFollowers(Integer i);

    DTOResponseListUser getListFollowers(Integer i, String order);

    DTOResponseListUser getListFollowed(Integer i, String order);

}
