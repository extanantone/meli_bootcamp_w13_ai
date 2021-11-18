package com.mercadolibre.socialmeli.service;
import com.mercadolibre.socialmeli.dto.*;
import com.mercadolibre.socialmeli.exception.FollowException;
import com.mercadolibre.socialmeli.exception.NotFoundException;

public interface ISocialService {
    FollowDTO followToUser(FollowDTO follow) throws NotFoundException, FollowException;
    FollowersCountDTO followersCount(Integer userId) throws NotFoundException;
    FollowersDTO allFollowers(Integer idUserFollow);
    FollowersDTO allFollowed(Integer idUser) throws NotFoundException;
    Boolean addPublication(PublicationDTO publicationDTO);
    PublicationsFollowDTO latestPublications(Integer idUser);
    Boolean unfollowUser(Integer userId, Integer userIdUnfollow);
    FollowersDTO orderingUsersFollowers(Integer userId, String order);
    FollowersDTO orderingUsersFolloweds(Integer userId, String order);
    PublicationsFollowDTO sortPublicationsSellers(Integer userId, String order);

}
