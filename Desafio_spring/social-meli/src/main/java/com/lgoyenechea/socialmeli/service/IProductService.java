package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserDoesNotExistsException;

public interface IProductService {

    PostDTO save(PostCreationDTO newPost) throws UserDoesNotExistsException;

    UserFollowedPostsListDTO followedPostsList(Long userId, String order);

    PostPromoDTO saveWithPromo(PostCreationPromoDTO newPost) throws UserDoesNotExistsException;

    UserPromoPostCountDTO postsPromoCount(Long userId) throws UserDoesNotExistsException;

    UserPostsPromoListDTO postsPromoList(Long userId) throws UserDoesNotExistsException;
}
