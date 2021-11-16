package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.UserFollow;

import java.util.List;

public interface IUSerFollowRepository {
    UserFollow newUserFollow(int userID1, int userID2);
    UserFollow checkUserFollow(int userID1, int userID2);
    List<UserFollow> listUserFollowersByID(int userID1);
    List<UserFollow> listFollowedUserByID(int userID1);
    void unfollowUser(int userID1, int userID2);
    List<UserFollow> getAllList();
}
