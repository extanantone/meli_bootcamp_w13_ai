package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.*;

public interface ISocialMeliService {
    MensajeDTO addFollow(int userId, int userIdFollow);
    CountFollowersDTO countFollowers(int userId);
    FollowersDTO listFollowers(int userId, String order);
    FollowedDTO listFollowed(int userId, String order);
    MensajeDTO addPost(PostDTOResponse postDto);
    ListPostsDTO listPostFollowed(int userId, String order);
    MensajeDTO unfollow(int userId, int userIdFollow);
}
