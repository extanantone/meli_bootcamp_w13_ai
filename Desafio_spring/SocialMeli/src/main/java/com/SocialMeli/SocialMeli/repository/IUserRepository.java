package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.dto.*;

public interface IUserRepository {
    UserDTO createBuyers(UserDTO user);
    UserDTO createSellers(UserDTO user);
    UserDTO findBuyerByUserId(Integer user_id);
    UserDTO findSellerByUserId(Integer user_id);
    Boolean follow(Integer user_id, Integer user_id_to_follow);
    FollowersCountDTO followersCount(Integer user_id);
    SellersDTO followersList(Integer user_id);
    BuyersDTO followedList(Integer user_id);
    Boolean createPost(PostUserDTO post);
    PostListDTO postList(Integer user_id, String order);
    Boolean unfollow(Integer user_id, Integer user_id_to_unfollow);
    BuyersDTO followedListSorted(Integer userId, String order);
    SellersDTO followersListSorted(Integer userId, String order);
    PostListDTO productsListSorted(Integer user_id, String order);

    // BONUS
    Boolean createPostPromo(PostPromoUserDTO post);
    PostPromoCountDTO postPromoCount( Integer userId );

}
