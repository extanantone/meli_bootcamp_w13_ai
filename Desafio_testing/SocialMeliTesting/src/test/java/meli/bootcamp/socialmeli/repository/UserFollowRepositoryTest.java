package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.exceptions.UserFollowHimselfException;
import meli.bootcamp.socialmeli.exceptions.UserNotFollowsException;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserFollowRepositoryTest {
    IUSerFollowRepository userFollowRepository;

    @BeforeEach
    public void setUp(){
        TestUtils.emptyObjectFile("userfollow");
        this.userFollowRepository= new UserFollowRepository();
    }

    @Test
    public void createTwoUsersThenFollowThemSelves(){
        //Arrange
        User userFollower = TestUtils.createNewUserWithName("Andres");
        User userFollowed = TestUtils.createNewUserWithName("Carlos");

        //Act
        userFollowRepository.newUserFollow(userFollower.getUserId(), userFollowed.getUserId());

        //Assert
        Assertions.assertTrue(userFollowRepository.checkUserFollow(userFollower.getUserId(), userFollowed.getUserId()));
    }

    /*
    @Test
    public void createOneUserThenFollowHimSelf(){
        //Arrange
        User userFollower = TestUtils.createNewUserWithName("Andres");

        //Act
        userFollowRepository.newUserFollow(userFollower.getUserId(), userFollower.getUserId());

        //Assert
        Assertions.assertThrows(
                UserFollowHimselfException.class,
                () -> userFollowRepository.checkUserFollow(
                userFollower.getUserId(), userFollower.getUserId()),
                "El usuario logro seguirse a si mismo."
        );
    }
     */

    @Test
    public void CreateTwoUsersFollowThemSelvesThenUnfollow(){
        //Arrange
        User userFollower = TestUtils.createNewUserWithName("Andres");
        User userFollowed = TestUtils.createNewUserWithName("Carlos");
        userFollowRepository.newUserFollow(userFollower.getUserId(), userFollowed.getUserId());

        //Act
        userFollowRepository.unfollowUser(userFollower.getUserId(), userFollowed.getUserId());

        //Assert
        Assertions.assertThrows(
                UserNotFollowsException.class,
                () -> userFollowRepository.checkUserFollow(userFollower.getUserId(), userFollowed.getUserId()),
                "El usuario " + userFollower.getUserName() + " no logro dejar de seguir a "
                    + userFollowed.getUserName());
    }

    @Test
    public void CreateTwoUsersFollowOneOfThemAndThenGetFollowerList(){
        //Arrange
        User userFollower1 = TestUtils.createNewUserWithName("Andres");
        User userFollower2 = TestUtils.createNewUserWithName("Pablo");
        User userFollowed1 = TestUtils.createNewUserWithName("Carlos");
        User userFollowed2 = TestUtils.createNewUserWithName("Salud");
        userFollowRepository.newUserFollow(userFollower1.getUserId(), userFollowed1.getUserId());
        userFollowRepository.newUserFollow(userFollower1.getUserId(), userFollowed2.getUserId());
        userFollowRepository.newUserFollow(userFollower2.getUserId(), userFollowed2.getUserId());

        //Act
        List<UserFollow> userFollows = userFollowRepository.listFollowedUserByID(userFollower1.getUserId());

        //Assert
        Assertions.assertTrue(
                userFollows.stream()
                    .filter(userFollow -> userFollow.getUserFollower() == userFollower1.getUserId())
                    .anyMatch(userFollow -> userFollow.getFollowedUser()==userFollowed1.getUserId())
        );

        Assertions.assertTrue(
                userFollows.stream()
                        .filter(userFollow -> userFollow.getUserFollower() == userFollower1.getUserId())
                        .anyMatch(userFollow -> userFollow.getFollowedUser()==userFollowed2.getUserId())
        );

        Assertions.assertFalse(
                userFollows.stream()
                        .filter(userFollow -> userFollow.getUserFollower() == userFollower2.getUserId())
                        .anyMatch(userFollow -> userFollow.getFollowedUser()==userFollowed1.getUserId())
        );
    }
}
