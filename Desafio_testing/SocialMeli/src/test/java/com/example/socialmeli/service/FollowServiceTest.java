package com.example.socialmeli.service;

import com.example.socialmeli.dto.FollowerListDTO;
import com.example.socialmeli.exception.UserIdNotFoundException;
import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FollowServiceTest {

    IUserRepository userRepository;
    IFollowService followService;

    @BeforeEach
    void setService() {
        System.out.println("\nSetting a new service with a new repository...");
        userRepository = new UserRepository();
        followService = new FollowService(userRepository);
    }

    @Test
    void shouldAddOneFollowerToUserOne() {
        assertEquals(0, userRepository.find(1).getFollowers().size());
        followService.addFollow(2, 1);
        System.out.println("User 1 should be followed by user 2, so the follow count goes up by one");
        assertEquals(1, userRepository.find(1).getFollowers().size());
    }

    @Test void shouldRemoveOneFollowerFromUserOne() {
        assertEquals(0, userRepository.find(1).getFollowers().size());
        System.out.println("User 2 will follow user 1");
        followService.addFollow(2, 1);
        assertEquals(1, userRepository.find(1).getFollowers().size());
        System.out.println("User 2 will no loner follow user 1");
        followService.removeFollow(2, 1);
        assertEquals(0, userRepository.find(1).getFollowers().size());
    }

    @Test
    void shouldThrowUserIdNotFoundExceptionWhenAddFollow() {
        System.out.println("User 9999 -non existant- will attempt to follow/be followed...");
        System.out.println("User 999 attempts to follow user 1...");
        assertThrows(UserIdNotFoundException.class, () -> followService.addFollow(999, 1));
        System.out.println("User 1 attempts to follow user 999...");
        assertThrows(UserIdNotFoundException.class, () -> followService.addFollow(1, 999));
    }

    @Test
    void shouldThrowUserIdNotFoundExceptionWhenRemoveFollow() {
        System.out.println("User 9999 -non existant- will attempt to remove follow/be unfollowed...");
        System.out.println("User 999 attempts to unfollow user 1...");
        assertThrows(UserIdNotFoundException.class, () -> followService.removeFollow(999, 1));
        System.out.println("User 1 attempts to unfollow user 999...");
        assertThrows(UserIdNotFoundException.class, () -> followService.removeFollow(1, 999));
    }

    @Test
    void shouldGetCorrectCountOfFollowers() {
        System.out.println("Adding a follower to user 1 directly through repository...");
        userRepository.find(1).addFollower(2);
        System.out.println("Follower count of user 1 should be 1...");
        assertEquals(1, followService.followerCount(1).getFollowersCount());
    }

    @Test
    void shouldGetListOfFollowers() {
        System.out.println("Adding a follower to user 1 directly through repository...");
        userRepository.find(1).addFollower(2);
        System.out.println("Follower list of user 1 should be of size 1...");
        assertEquals(1, followService.followerList(1).followers.size());
    }

    @Test
    void shouldGetListOfFollowing() {
        System.out.println("Following user 1 with user 2...");
        userRepository.find(2).addFollow(1);
        System.out.println("Following list of user 2 should be of size 1...");
        assertEquals(1, followService.followingList(2).followers.size());
    }

    @Test
    void shouldGetSortedFollowerListAsc() {
        System.out.println("Following user 1 with user 2 through repository...");
        userRepository.find(1).addFollower(2);
        System.out.println("Following user 1 with user 3 through repository...");
        userRepository.find(1).addFollower(3);
        FollowerListDTO followerListDTOAsc = followService.sortedFollowerList(1, "name_asc");
        System.out.println("The correct order should be Pepa and then Popa...");
        assertTrue("Pepa".equals(followerListDTOAsc.followers.get(0).getUserName()));
        assertTrue("Popa".equals((followerListDTOAsc.followers.get(1).getUserName())));

    }

    @Test
    void shouldGetSortedFollowerListDesc() {
        System.out.println("Following user 1 with user 2 through repository...");
        userRepository.find(1).addFollower(2);
        System.out.println("Following user 1 with user 3 through repository...");
        userRepository.find(1).addFollower(3);
        FollowerListDTO followerListDTOAsc = followService.sortedFollowerList(1, "name_desc");
        System.out.println("The correct order should be Popa and then Pepa...");
        assertTrue("Popa".equals(followerListDTOAsc.followers.get(0).getUserName()));
        assertTrue("Pepa".equals((followerListDTOAsc.followers.get(1).getUserName())));
    }

    @Test
    void shouldGetSortedFollowingListAsc() {
        System.out.println("Following user 2 with user 1 through repository...");
        userRepository.find(1).addFollow(2);
        System.out.println("Following user 3 with user 1 through repository...");
        userRepository.find(1).addFollow(3);
        FollowerListDTO followerListDTOAsc = followService.sortedFollowingList(1, "name_asc");
        System.out.println("The correct order should be Popa and then Pepa...");
        assertTrue("Pepa".equals(followerListDTOAsc.followers.get(0).getUserName()));
        assertTrue("Popa".equals((followerListDTOAsc.followers.get(1).getUserName())));
    }

    @Test
    void shouldGetSortedFollowingListDesc() {
        System.out.println("Following user 2 with user 1 through repository...");
        userRepository.find(1).addFollow(2);
        System.out.println("Following user 3 with user 1 through repository...");
        userRepository.find(1).addFollow(3);
        FollowerListDTO followerListDTOAsc = followService.sortedFollowingList(1, "name_desc");
        System.out.println("The correct order should be Pepa and then Popa...");
        assertTrue("Popa".equals(followerListDTOAsc.followers.get(0).getUserName()));
        assertTrue("Pepa".equals((followerListDTOAsc.followers.get(1).getUserName())));
    }
}
