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
    public void followSeller(int customerId, int sellerId);
    public void unfollowSeller(int customerId, int sellerId);
    public FollowersCountDTO getFollowersCount(int sellerId);
    public FollowersListDTO getFollowersList(int sellerId, String order);
    public FollowedListDTO getFollowedList(int customerId, String order);
    public void newPost(NewPostDTO post);
    public PostListDTO getTwoWeeksPost(int customerId, String order);
    public void newUser(NewUserDTO newUser);
    // BONUS
    public PromoCountDTO getPromoCount(int sellerId);
    public PromoPostListDTO getPromoList(int user_id);
}
