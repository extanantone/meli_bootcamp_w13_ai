package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.*;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrontTypeException;
import com.sprint.SocialMeli.model.User;

import java.util.List;

public interface ISocialService {
    void followVendedor(int user_id, int user_id_to_follow) throws NotFoundException, WrontTypeException;
    FollowersCountDto getSellerFollowersCount(int user_id) throws WrontTypeException, NotFoundException;
    FollowersListDto getSellerFollowersList(int user_id) throws WrontTypeException, NotFoundException;
    FollowedListDto getBuyerFollowedList(int user_id) throws WrontTypeException, NotFoundException;

}
