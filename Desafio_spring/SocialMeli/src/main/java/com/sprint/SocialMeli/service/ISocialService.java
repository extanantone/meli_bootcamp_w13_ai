package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.*;
import com.sprint.SocialMeli.exceptions.DuplicateException;
import com.sprint.SocialMeli.exceptions.InvalidOrderException;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;

public interface ISocialService {
    void followSeller(int userId, int userIdToFollow) throws Exception;
    FollowersCountDto getSellerFollowersCount(int userId) throws WrongTypeException, NotFoundException;
    FollowersListDto getSellerFollowersList(int userId, String order) throws WrongTypeException, NotFoundException, InvalidOrderException;
    FollowedListDto getBuyerFollowedList(int userId, String order) throws WrongTypeException, NotFoundException, InvalidOrderException;
    void newPost(PostDtoIn postDtoIn) throws Exception;
    FollowedPostListDto getLastTwoWeeksPostsFromFollowed(int userId, String order) throws WrongTypeException, NotFoundException, InvalidOrderException;
    void unfollowSeller(int userId, int userIdToUnfollow) throws Exception;
    void newPromoPost(PromoPostDtoIn promoPostDtoIn) throws Exception;
    PromoPostCountDto getPromoPostCount(int userId) throws WrongTypeException, NotFoundException;
    PromoPostList getPromoPostList(int userId) throws WrongTypeException, NotFoundException;

}
