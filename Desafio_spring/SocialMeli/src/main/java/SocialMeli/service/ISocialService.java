package SocialMeli.service;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.request.NewUserDTO;
import SocialMeli.dto.response.FollowedListDTO;
import SocialMeli.dto.response.FollowersCountDTO;
import SocialMeli.dto.response.FollowersListDTO;
import SocialMeli.dto.response.PostListDTO;

public interface ISocialService {
    public void followSeller(int customerId, int sellerId);
    public void unfollowSeller(int customerId, int sellerId);
    public FollowersCountDTO getFollowersCount(int sellerId);
    public FollowersListDTO getFollowersList(int sellerId);
    public FollowedListDTO getFollowedList(int customerId);
    public void newPost(NewPostDTO post);
    public PostListDTO getTwoWeeksPost(int customerId);
    public void newUser(NewUserDTO newUser);
}
