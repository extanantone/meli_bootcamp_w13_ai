package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exception.NotFoundUserException;

public interface ISocialService {

    FollowDTO follow(int idb, int ids) throws NotFoundUserException;
    CountFollowersDTO getFollowersCount(int ids) throws NotFoundUserException;
    FollowersDTO getFollowers(int ids) throws NotFoundUserException;
    FollowedsDTO getFolloweds(int idb) throws NotFoundUserException;
    UnFollowDTO getUnFollow(int ids,int idb) throws NotFoundUserException;


}
