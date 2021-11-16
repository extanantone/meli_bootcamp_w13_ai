package meli.bootcamp.socialmeli.service;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.repository.PostRepository;

import java.util.List;

public interface ISocialMeliService {
    void followUser(int userID, int userIDToFollow);
    void unfollowUser(int userID, int userIDToUnfollow);
    FollowersCountDTO getFollowersCount(int userID);
    FollowersListDTO getFollowersList(int userID);
    FollowersListDTO getFollowedList(int userID);
    void addPost(ProductsPostDTO newPost);
    List<UserFollow> lista();
    List<Post> listaPost();
    ProductsUserIDListDTO listSortedPostByUserID(int user_id);
    ProductsUserIDListDTO listSortedPostByUserID(int user_id, String order);
    FollowersListDTO getOrderedFollowersList(int userID, boolean searchFollowers, String order, boolean sortedResponse);
    void newPromoPost(ProductsPromoPostDTO productsPromoPostDTO);
}
