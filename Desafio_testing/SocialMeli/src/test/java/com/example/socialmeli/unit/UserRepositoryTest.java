package com.example.socialmeli.unit;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryTest {
    private UserRepository repo = new UserRepository();;
    private SocialMeliUnitUtils meliUtils = new SocialMeliUnitUtils();

    @Test
    public void validIdShouldFindUser () {
        Integer validId = 1;
        User expectedUser = meliUtils.getDefaultUser(1).get();

        Optional<User> foundUser = repo.findById(validId);

        Assertions.assertAll(
                () -> Assertions.assertFalse(foundUser.isEmpty()),
                () -> Assertions.assertTrue(this.meliUtils.areUsersEqual(expectedUser, foundUser.get()))
        );
    }

    @Test
    public void invalidIdShouldNotFindUser () {
        Integer invalidId = 404;

        Optional<User> foundUser = repo.findById(invalidId);

        Assertions.assertTrue(foundUser.isEmpty());
    }

    @Test
    public void findAllShouldGetAllUsers () {
        List<User> foundUsers = repo.findAll();

        Assertions.assertTrue(foundUsers.stream().anyMatch(
                    u -> this.meliUtils.areUsersEqual(u, meliUtils.getDefaultUser(1).get())));
        Assertions.assertTrue(foundUsers.stream().anyMatch(
                u -> this.meliUtils.areUsersEqual(u, meliUtils.getDefaultUser(2).get())));
        Assertions.assertTrue(foundUsers.stream().anyMatch(
                u -> this.meliUtils.areUsersEqual(u, meliUtils.getDefaultUser(3).get())));
        Assertions.assertTrue(foundUsers.stream().anyMatch(
                u -> this.meliUtils.areUsersEqual(u, meliUtils.getDefaultUser(4).get())));
        Assertions.assertEquals(4, foundUsers.size());
    }

    @Test
    public void pushThrowsUnsupportedOperationException () {
        Assertions.assertThrows(UnsupportedOperationException.class,
                (() -> repo.push(new Post())));
    }

    @Test
    public void validIdShouldFindAllFollowed () {
        Integer validId = 1;
        List<Integer> expectedFollowedId = this.repo.findAll().stream().
                filter(u -> u.getFollowersId().contains(validId)).
                map(u -> u.getUserId()).collect(Collectors.toList());

        List<User> foundFollowed = this.repo.findFollowed(validId);

        Assertions.assertEquals(expectedFollowedId.size(), foundFollowed.size());
        for (int i = 0; i < expectedFollowedId.size(); i++) {
            Integer id = expectedFollowedId.get(i);
            Assertions.assertTrue(foundFollowed.stream().anyMatch(u -> u.getUserId().equals(id)));
        }
    }

    @Test
    public void invalidIdShouldNotFindFollowed () {
        Integer invalidId = 500;

        List<User> foundFollowers = this.repo.findFollowed(invalidId);

        Assertions.assertTrue(foundFollowers.isEmpty());
    }

}
