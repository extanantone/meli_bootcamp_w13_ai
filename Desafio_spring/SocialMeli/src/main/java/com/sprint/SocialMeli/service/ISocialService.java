package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.*;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;

public interface ISocialService {
    void followSeller(int user_id, int user_id_to_follow) throws NotFoundException, WrongTypeException;
    FollowersCountDto getSellerFollowersCount(int user_id) throws WrongTypeException, NotFoundException;
    FollowersListDto getSellerFollowersList(int user_id) throws WrongTypeException, NotFoundException;
    FollowedListDto getBuyerFollowedList(int user_id) throws WrongTypeException, NotFoundException;
    void newPost(PostDtoIn postDtoIn);
    FollowedPostListDto getLastTwoWeeksPostsFromABuyerFollowed(int user_id) throws WrongTypeException, NotFoundException;
    void unfollowSeller(int user_id, int user_id_to_unfollow) throws WrongTypeException, NotFoundException;
}
