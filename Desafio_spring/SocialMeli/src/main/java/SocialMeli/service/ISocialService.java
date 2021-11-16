package SocialMeli.service;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.request.NewUserDTO;
import SocialMeli.dto.response.list.FollowedListDTO;
import SocialMeli.dto.response.count.FollowersCountDTO;
import SocialMeli.dto.response.list.FollowersListDTO;
import SocialMeli.dto.response.list.PostListDTO;
import SocialMeli.dto.response.count.PromoCountDTO;
import SocialMeli.dto.response.list.PromoPostListDTO;

public interface ISocialService {
    void followSeller(int customerId, int sellerId);

    void unfollowSeller(int customerId, int sellerId);

    FollowersCountDTO getFollowersCount(int sellerId);

    FollowersListDTO getFollowersList(int sellerId, String order);

    FollowedListDTO getFollowedList(int customerId, String order);

    void newPost(NewPostDTO post);

    PostListDTO getTwoWeeksPost(int customerId, String order);

    void newUser(NewUserDTO newUser);

    // BONUS
    PromoCountDTO getPromoCount(int sellerId);

    PromoPostListDTO getPromoList(int user_id);
}
