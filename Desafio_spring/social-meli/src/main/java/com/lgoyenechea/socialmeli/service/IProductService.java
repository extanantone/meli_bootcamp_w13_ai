package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserNotFoundException;

public interface IProductService {

    PostDTO save(PostCreationDTO newPost) throws UserNotFoundException;

    UserFollowedPostsListDTO followedPostsList(Long userId, String order);

    PostPromoDTO saveWithPromo(PostCreationPromoDTO newPost) throws UserNotFoundException;

    UserPromoPostCountDTO postsPromoCount(Long userId) throws UserNotFoundException;

    UserPostsPromoListDTO postsPromoList(Long userId) throws UserNotFoundException;
}
