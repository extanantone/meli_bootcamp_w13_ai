package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.dto.UserDTO;
import meli.bootcamp.socialmeli.exceptions.UserAlreadyFollowsException;
import meli.bootcamp.socialmeli.exceptions.UserNotFollowsException;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class UserFollowRepository implements IUSerFollowRepository{
    List<UserFollow> mListUserFollow= new ArrayList<>();

    @Override
    public UserFollow newUserFollow(int userID1, int userID2) {
        UserFollow tempUser= new UserFollow(userID1, userID2);
        if (mListUserFollow.stream().
                filter(userFollow ->
                        userFollow.getUserFollower() == userID1 &&
                                userFollow.getFollowedUser() == userID2)
                .findFirst().isEmpty()) {
                    mListUserFollow.add(tempUser);
                    return tempUser;
                } else {
            throw new UserAlreadyFollowsException();
        }
    }

    @Override
    public boolean checkUserFollow(int userID1, int userID2) {
        boolean exist= mListUserFollow.stream()
                .anyMatch(userFollow -> userFollow.getUserFollower() == userID1 && userFollow.getFollowedUser() == userID2);
        if (!exist)
                throw new UserNotFollowsException();
        else
            return true;
    }

    @Override
    public List<UserFollow> listUserFollowersByID(int userID1) {
        return mListUserFollow.stream()
                .filter(userFollow -> userFollow.getFollowedUser() == userID1)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserFollow> listFollowedUserByID(int userID1) {
        return mListUserFollow.stream()
                .filter(userFollow -> userFollow.getUserFollower() == userID1)
                .collect(Collectors.toList());
    }

    @Override
    public void unfollowUser(int userID1, int userID2) {
        mListUserFollow.remove(new UserFollow(userID1, userID2));
        Predicate<UserFollow> predicate= userFollow -> userFollow.getUserFollower() == userID1 && userFollow.getFollowedUser() == userID2;
        if (!mListUserFollow.removeIf(predicate)) {
            throw new UserNotFollowsException();
        }
    }

    @Override
    public List<UserFollow> getAllList() {
        return mListUserFollow;
    }

}
