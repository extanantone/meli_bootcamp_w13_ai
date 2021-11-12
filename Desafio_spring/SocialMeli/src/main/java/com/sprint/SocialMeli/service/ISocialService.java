package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.*;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;

public interface ISocialService {
    void followSeller(int user_id, int user_id_to_follow) throws NotFoundException, WrongTypeException;
    FollowersCountDto getSellerFollowersCount(int user_id) throws WrongTypeException, NotFoundException;
    FollowersListDto getSellerFollowersList(int user_id, String order) throws WrongTypeException, NotFoundException;
    FollowedListDto getBuyerFollowedList(int user_id, String order) throws WrongTypeException, NotFoundException;
    void newPost(PostDtoIn postDtoIn) throws WrongTypeException, NotFoundException;
    FollowedPostListDto getLastTwoWeeksPostsFromFollowed(int user_id, String order) throws WrongTypeException, NotFoundException;
    void unfollowSeller(int user_id, int user_id_to_unfollow) throws WrongTypeException, NotFoundException;
    void newPromoPost(PromoPostDtoIn promoPostDtoIn) throws WrongTypeException, NotFoundException;
    PromoPostCountDto getPromoPostCount(int user_id) throws WrongTypeException, NotFoundException;
    PromoPostList getPromoPostList(int user_id) throws WrongTypeException, NotFoundException;

}
