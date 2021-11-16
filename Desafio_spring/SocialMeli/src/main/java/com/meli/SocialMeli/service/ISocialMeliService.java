package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.*;
import org.springframework.http.ResponseEntity;

public interface ISocialMeliService {
    public MensajeDTO addFollow(int userId, int userIdFollow);
    public CountFollowersDTO countFollowers(int userId);
    public FollowersDTO listFollowers(int userId, String order);
    public FollowedDTO listFollowed(int userId, String order);
    public MensajeDTO addPost(PostDTOResponse postDto);
    public ListPostsDTO listPostFollowed(int userId, String order);
    public MensajeDTO unfollow(int userId, int userIdFollow);
}
