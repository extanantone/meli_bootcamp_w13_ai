package com.socialmeli.service;

import com.socialmeli.dto.*;
import com.socialmeli.dto.SellerFollowersCountDto;

import java.util.List;

public interface IUserService {

    void followUser(int idUser,int idSeller);
    SellerFollowersCountDto getCountBySeller(int idSeller);
    FollowerListDto getFollowerList(int idSeller);
    FollowedListDto getFollowed(int userId);
    void addPost(PostDto dto);
    ListPostDto getListDtoSubscriptionByUser(int iduser);
    void unfollowSeller(int id, int seller);
    FollowerListDto getFollowerListOrderByNameAsc(int userId);

    FollowerListDto getFollowerListOrderByNameDesc(int userId);

    FollowedListDto getFollowedListOrderByNameAsc(int userId);

    FollowedListDto getFollowedListOrderByNameDesc(int userId);

    ListPostDto getListDtoSubscriptionByUserAndOrderByDateAsc(int id);

    ListPostDto getListDtoSubscriptionByUserAndOrderByDateDesc(int id);

    void addPostDiscount(DicountPostDto dto);

    PostCount getCountPromoDiscount(int userId);

    ProductDiscountListDto getProductDiscountListDto(int seller);

    Integer addUser(UserRequestDto dto);

    List<UserDto> getAllUsers();

    List<UserDto> getAllSellers();
}
