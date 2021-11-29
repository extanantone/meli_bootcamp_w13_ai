package com.example.socialmeli.unit;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.response.*;
import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UserRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {
    @Mock
    private UserRepository userRepo;
    @Mock
    private PostRepository postRepo;

    @InjectMocks
    private SocialMeliService service;

    private SocialMeliUnitUtils meliUtils = new SocialMeliUnitUtils();
    private ModelMapper mapper = new ModelMapper();

    @BeforeEach
    public void setUp() {
        Mockito.reset(userRepo);
        Mockito.reset(postRepo);
    }

    @Test
    public void invalidUserIdCantFollow () {
        Integer validUserId = 1;
        Integer invalidUserId = 5;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.follow(invalidUserId, validUserId));
    }

    @Test
    public void invalidUserIdCantBeFollowed () {
        Integer validUserId = 1;
        Integer invalidUserId = 5;
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.follow(validUserId, invalidUserId));
    }

    @Test
    public void userCantFollowThemselves () {
        Integer validUserId = 1;
        Assertions.assertThrows(UserSelfUseException.class,
                () -> this.service.follow(validUserId, validUserId));
    }

    @Test
    public void validUserCanFollowAnotherValidUser () {
        Integer firstValidUserId = 1;
        Integer secondValidUserId = 2;
        Mockito.when(userRepo.findById(firstValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));
        Mockito.when(userRepo.findById(secondValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));

        Assertions.assertDoesNotThrow(() -> this.service.follow(firstValidUserId, secondValidUserId));
        Mockito.verify(userRepo, Mockito.times(2)).findById(Mockito.any());
    }

    @Test
    public void userCantFollowTheSameUserTwice () {
        Integer firstValidUserId = 1;
        Integer secondValidUserId = 2;
        Mockito.when(userRepo.findById(firstValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));
        Mockito.when(userRepo.findById(secondValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));

        Assertions.assertDoesNotThrow(() -> this.service.follow(firstValidUserId, secondValidUserId));
        Assertions.assertThrows(UserAlreadyInUseException.class,
                () -> this.service.follow(firstValidUserId, secondValidUserId));
        Mockito.verify(userRepo, Mockito.times(4)).findById(Mockito.any());
    }

    @Test
    public void invalidUserIdCantUnfollow () {
        Integer validUserId = 1;
        Integer invalidUserId = 5;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.unfollow(invalidUserId, validUserId));
    }

    @Test
    public void invalidUserIdCantBeUnfollowed () {
        Integer validUserId = 1;
        Integer invalidUserId = 5;
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.unfollow(validUserId, invalidUserId));
    }

    @Test
    public void userCantUnfollowThemselves () {
        Integer validUserId = 1;
        Assertions.assertThrows(UserSelfUseException.class,
                () -> this.service.unfollow(validUserId, validUserId));
    }

    @Test
    public void validUserShouldUnfollowAnotherValidUser () {
        Integer firstValidUserId = 1;
        Integer secondValidUserId = 2;
        Mockito.when(userRepo.findById(firstValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));
        Mockito.when(userRepo.findById(secondValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));

        Assertions.assertDoesNotThrow(() -> this.service.follow(firstValidUserId, secondValidUserId));
        Assertions.assertDoesNotThrow(() -> this.service.unfollow(firstValidUserId, secondValidUserId));
        Mockito.verify(userRepo, Mockito.times(4)).findById(Mockito.any());
    }

    @Test
    public void userCantUnfollowTheSameUserTwice () {
        Integer firstValidUserId = 1;
        Integer secondValidUserId = 2;
        Mockito.when(userRepo.findById(firstValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));
        Mockito.when(userRepo.findById(secondValidUserId)).
                thenReturn(this.meliUtils.getDefaultUser(secondValidUserId));

        Assertions.assertDoesNotThrow(() -> this.service.follow(firstValidUserId, secondValidUserId));
        Assertions.assertDoesNotThrow(() -> this.service.unfollow(firstValidUserId, secondValidUserId));
        Assertions.assertThrows(UserAlreadyInUseException.class,
                () -> this.service.unfollow(firstValidUserId, secondValidUserId));
        Mockito.verify(userRepo, Mockito.times(6)).findById(Mockito.any());
    }

    @Test
    public void invalidUserCantGetFollowers () {
        Integer invalidUserId = 5;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.getFollowers(invalidUserId, null));
    }

    @Test
    public void noGivenOrderShouldGetFollowersOrderedByDescendingName () throws UserNotFoundException {
        Integer validUserId = 1;
        List<Integer> validFollowers = List.of(2, 3, 4);
        User validUser = this.meliUtils.getDefaultUser(validUserId).get();
        validUser.setFollowersId(validFollowers);
        Mockito.when(userRepo.findById(validUserId)).thenReturn(Optional.of(validUser));
        for (Integer id : validFollowers) {
            Mockito.when(userRepo.findById(id)).thenReturn(this.meliUtils.getDefaultUser(id));
        }

        FollowersResponseDTO response = this.service.getFollowers(validUserId, null);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        for (Integer id : validFollowers) {
            Assertions.assertTrue(response.getFollowers().stream().anyMatch(
                    u -> u.getUserId().equals(id)));
        }
        Assertions.assertEquals(validFollowers.size(), response.getFollowers().size());
        for (int index = 0; index < response.getFollowers().size()-1; index++) {
            Assertions.assertTrue(
                    response.getFollowers().get(index).getUserName().compareTo(
                    response.getFollowers().get(index+1).getUserName()) >= 0);
        }
    }

    @Test
    public void nameDescOrderShouldGetFollowersOrderedByDescendingName () throws UserNotFoundException {
        Integer validUserId = 3;
        List<Integer> validFollowers = List.of(2, 4, 1);
        User validUser = this.meliUtils.getDefaultUser(validUserId).get();
        validUser.setFollowersId(validFollowers);
        Mockito.when(userRepo.findById(validUserId)).thenReturn(Optional.of(validUser));
        for (Integer id : validFollowers) {
            Mockito.when(userRepo.findById(id)).thenReturn(this.meliUtils.getDefaultUser(id));
        }

        FollowersResponseDTO response = this.service.getFollowers(validUserId, "name_desc");

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        for (Integer id : validFollowers) {
            Assertions.assertTrue(response.getFollowers().stream().anyMatch(
                    u -> u.getUserId().equals(id)));
        }
        Assertions.assertEquals(validFollowers.size(), response.getFollowers().size());
        for (int index = 0; index < response.getFollowers().size()-1; index++) {
            Assertions.assertTrue(
                    response.getFollowers().get(index).getUserName().compareTo(
                            response.getFollowers().get(index+1).getUserName()) >= 0);
        }
    }

    @Test
    public void nameAscOrderShouldGetFollowersOrderedByAscendingName () throws UserNotFoundException {
        Integer validUserId = 2;
        List<Integer> validFollowers = List.of(1, 3, 4);
        User validUser = this.meliUtils.getDefaultUser(validUserId).get();
        validUser.setFollowersId(validFollowers);
        Mockito.when(userRepo.findById(validUserId)).thenReturn(Optional.of(validUser));
        for (Integer id : validFollowers) {
            Mockito.when(userRepo.findById(id)).thenReturn(this.meliUtils.getDefaultUser(id));
        }

        FollowersResponseDTO response = this.service.getFollowers(validUserId, "name_asc");

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        for (Integer id : validFollowers) {
            Assertions.assertTrue(response.getFollowers().stream().anyMatch(
                    u -> u.getUserId().equals(id)));
        }
        Assertions.assertEquals(validFollowers.size(), response.getFollowers().size());
        for (int index = 0; index < response.getFollowers().size()-1; index++) {
            Assertions.assertTrue(
                    response.getFollowers().get(index).getUserName().compareTo(
                            response.getFollowers().get(index+1).getUserName()) <= 0);
        }
    }

    @Test
    public void invalidUserCantGetFollowed () {
        Integer invalidUserId = 5;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.getFollowed(invalidUserId, null));
    }

    @Test
    public void noGivenOrderShouldGetFollowedOrderedByDescendingName () throws UserNotFoundException {
        Integer validUserId = 4;
        User validUser = this.meliUtils.getDefaultUser(validUserId).get();
        List<Integer> validFollowed = List.of(1, 2, 3);
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        this.mockFollowed(validUserId, validFollowed);

        FollowedResponseDTO response = this.service.getFollowed(validUserId, null);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        for (Integer id : validFollowed) {
            Assertions.assertTrue(response.getFollowed().stream().anyMatch(
                    u -> u.getUserId().equals(id)));
        }
        Assertions.assertEquals(validFollowed.size(), response.getFollowed().size());
        for (int index = 0; index < response.getFollowed().size()-1; index++) {
            Assertions.assertTrue(
                    response.getFollowed().get(index).getUserName().compareTo(
                            response.getFollowed().get(index+1).getUserName()) >= 0);
        }
    }

    @Test
    public void nameDescOrderShouldGetFollowedOrderedByDescendingName () throws UserNotFoundException {
        Integer validUserId = 3;
        User validUser = this.meliUtils.getDefaultUser(validUserId).get();
        List<Integer> validFollowed = List.of(1, 2, 4);
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        this.mockFollowed(validUserId, validFollowed);

        FollowedResponseDTO response = this.service.getFollowed(validUserId, "name_desc");

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        for (Integer id : validFollowed) {
            Assertions.assertTrue(response.getFollowed().stream().anyMatch(
                    u -> u.getUserId().equals(id)));
        }
        Assertions.assertEquals(validFollowed.size(), response.getFollowed().size());
        for (int index = 0; index < response.getFollowed().size()-1; index++) {
            Assertions.assertTrue(
                    response.getFollowed().get(index).getUserName().compareTo(
                            response.getFollowed().get(index+1).getUserName()) >= 0);
        }
    }

    @Test
    public void nameAscOrderShouldGetFollowedOrderedByAscendingName () throws UserNotFoundException {
        Integer validUserId = 2;
        User validUser = this.meliUtils.getDefaultUser(validUserId).get();
        List<Integer> validFollowed = List.of(1, 4, 3);
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        this.mockFollowed(validUserId, validFollowed);

        FollowedResponseDTO response = this.service.getFollowed(validUserId, "name_asc");

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        for (Integer id : validFollowed) {
            Assertions.assertTrue(response.getFollowed().stream().anyMatch(
                    u -> u.getUserId().equals(id)));
        }
        Assertions.assertEquals(validFollowed.size(), response.getFollowed().size());
        for (int index = 0; index < response.getFollowed().size()-1; index++) {
            Assertions.assertTrue(
                    response.getFollowed().get(index).getUserName().compareTo(
                            response.getFollowed().get(index+1).getUserName()) <= 0);
        }
    }

    @Test
    public void invalidUserIdCantGetFollowersCount () {
        Integer invalidUserId = 5;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.countFollowers(invalidUserId));
    }

    @Test
    public void validUserIdShouldGetFollowersCount () throws UserNotFoundException {
        Integer validUserId = 4;
        List<Integer> validFollowed = List.of(1, 2, 3);
        User validUser = this.meliUtils.getDefaultUser(validUserId).get();
        validUser.setFollowersId(validFollowed);
        Mockito.when(userRepo.findById(validUserId)).thenReturn(Optional.of(validUser));

        CountFollowersResponseDTO response = this.service.countFollowers(validUserId);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        Assertions.assertEquals(validFollowed.size(), response.getFollowersCount());
    }

    @Test
    public void cantPostWithInvalidUserId () {
        Integer invalidId = 500;
        Post invalidPost = this.meliUtils.genDefaultRecentPost(invalidId, 1, "Gamer Glass");
        Mockito.when(userRepo.findById(invalidId)).thenReturn(Optional.empty());
        Mockito.when(postRepo.findById(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.pushPost(this.mapper.map(invalidPost, PostDTO.class)));
    }

    @Test
    public void cantPostWithInvalidDiscount () {
        Integer validUserId = 2;
        Post invalidPost = this.meliUtils.genDefaultRecentPromo(validUserId, 1,
                "Gamer Glass", 300.0);
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(postRepo.findById(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(InvalidPromoException.class,
                () -> this.service.pushPost(this.mapper.map(invalidPost, PostDTO.class)));
    }

    @Test
    public void validPostShouldBePushedToRepository () {
        Integer validUserId = 3;
        Post validPost = this.meliUtils.genDefaultRecentPost(validUserId, 1,
                "Gamer Plate");
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(postRepo.findById(1)).thenReturn(Optional.empty());

        Assertions.assertDoesNotThrow(
                () -> this.service.pushPost(this.mapper.map(validPost, PostDTO.class)));
        Mockito.verify(postRepo,Mockito.times(1)).push(Mockito.any(Post.class));
    }

    @Test
    public void cantPostWithSamePostId () {
        Integer validUserId = 3;
        Integer postId = 4;
        Post validPost = this.meliUtils.genDefaultRecentPost(validUserId, postId,
                "Gamer Eraser");
        Post postWithSameId = this.meliUtils.genDefaultRecentPost(validUserId, postId,
                "Gamer Doppelganger");
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(postRepo.findById(postId)).thenReturn(Optional.empty());

        Assertions.assertDoesNotThrow(
                () -> this.service.pushPost(this.mapper.map(validPost, PostDTO.class)));
        Mockito.when(postRepo.findById(postId)).thenReturn(Optional.of(validPost));

        Assertions.assertThrows(PostAlreadyExistException.class,
                () -> this.service.pushPost(this.mapper.map(postWithSameId, PostDTO.class)));
        Mockito.verify(postRepo,Mockito.times(1)).push(Mockito.any(Post.class));
    }

    @Test
    public void cantGetFollowedPostListFromInvalidUserId () {
        Integer invalidUserId = 505;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.getFollowedPostList(invalidUserId, null));
    }

    @Test
    public void cantGetFollowedPostListFromInvalidOrder () {
        Integer validUserId = 2;
        String invalidOrder = "random";
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));

        Assertions.assertThrows(NullPointerException.class,
                () -> this.service.getFollowedPostList(validUserId, invalidOrder));
    }

    @Test
    public void noRecentPostsShouldBeObtainedForNoFollowed () throws UserNotFoundException {
        Integer validUserId = 1;
        String validOrder = "date_asc";
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(userRepo.findFollowed(validUserId)).thenReturn(new ArrayList<>());

        PostsResponseDTO response = this.service.getFollowedPostList(validUserId, validOrder);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertTrue(response.getPosts().isEmpty());
    }

    @Test
    public void onlyRecentPostsShouldBeObtainedFromFollowed ()
            throws UserNotFoundException, ParseException {
        Integer validUserId = 1;
        String validOrder = "date_asc";
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        List<Integer> validFollowed = List.of(2, 4, 3);
        this.mockFollowed(validUserId, validFollowed);
        Post recentPost = this.meliUtils.genDefaultRecentPost(1, 20045, "Gamer Chair");
        Post ancientPost = this.meliUtils.genDefaultAncientPost(3, 3, "Gamer Fax");
        Mockito.when(postRepo.findByUserId(2)).thenReturn(List.of(recentPost));
        Mockito.when(postRepo.findByUserId(3)).thenReturn(List.of(ancientPost));
        Mockito.when(postRepo.findByUserId(4)).thenReturn(new ArrayList<>());

        PostsResponseDTO response = this.service.getFollowedPostList(validUserId, validOrder);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(1, response.getPosts().size());
        Assertions.assertTrue(this.meliUtils.arePostsEqual(recentPost,
                mapper.map(response.getPosts().get(0), Post.class)));
    }

    @Test
    public void dateAscOrderShouldGetRecentPostsOrderedByAscendingDate ()
            throws UserNotFoundException {
        Integer validUserId = 2;
        String validOrder = "date_asc";
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        List<Integer> validFollowed = List.of(1, 4, 3);
        this.mockFollowed(validUserId, validFollowed);
        Post firstPost = this.meliUtils.genNotSoRecentPost(3,
                20031, "Gamer Laptop", 3);
        Post secondPost = this.meliUtils.genNotSoRecentPost(1,
                20037, "Gamer Notebook", 2);
        Post thirdPost = this.meliUtils.genNotSoRecentPost(3,
                20058, "Gamer Netbook", 1);
        Mockito.when(postRepo.findByUserId(1)).thenReturn(List.of(secondPost));
        Mockito.when(postRepo.findByUserId(3)).thenReturn(List.of(firstPost, thirdPost));
        Mockito.when(postRepo.findByUserId(4)).thenReturn(new ArrayList<>());

        PostsResponseDTO response = this.service.getFollowedPostList(validUserId, validOrder);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(3, response.getPosts().size());
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(firstPost, this.mapper.map(p, Post.class))));
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(secondPost, this.mapper.map(p, Post.class))));
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(thirdPost, this.mapper.map(p, Post.class))));
        for (int index = 0; index < response.getPosts().size()-1; index++) {
            Assertions.assertTrue(
                    response.getPosts().get(index).getDate().before(
                            response.getPosts().get(index+1).getDate()));
        }
    }

    @Test
    public void dateDescOrderShouldGetRecentPostsOrderedByDescendingDate ()
            throws UserNotFoundException {
        Integer validUserId = 4;
        String validOrder = "date_desc";
        Mockito.when(userRepo.findById(validUserId)).
                thenReturn(this.meliUtils.getDefaultUser(validUserId));
        List<Integer> validFollowed = List.of(1, 2, 3);
        this.mockFollowed(validUserId, validFollowed);
        Post firstPost = this.meliUtils.genNotSoRecentPost(1,
                20012, "Gamer Apple", 3);
        Post secondPost = this.meliUtils.genNotSoRecentPost(2,
                20013, "Gamer Banana", 2);
        Post thirdPost = this.meliUtils.genNotSoRecentPost(1,
                20055, "Gamer Pear", 1);
        Mockito.when(postRepo.findByUserId(2)).thenReturn(List.of(secondPost));
        Mockito.when(postRepo.findByUserId(1)).thenReturn(List.of(firstPost, thirdPost));
        Mockito.when(postRepo.findByUserId(3)).thenReturn(new ArrayList<>());

        PostsResponseDTO response = this.service.getFollowedPostList(validUserId, validOrder);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(3, response.getPosts().size());
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(firstPost, this.mapper.map(p, Post.class))));
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(secondPost, this.mapper.map(p, Post.class))));
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(thirdPost, this.mapper.map(p, Post.class))));
        for (int index = 0; index < response.getPosts().size()-1; index++) {
            Assertions.assertTrue(
                    response.getPosts().get(index).getDate().after(
                            response.getPosts().get(index+1).getDate()));
        }
    }

    @Test
    public void cantGetPromoCountFromInvalidUserId () {
        Integer invalidUserId = 882;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.getPromoCount(invalidUserId));
    }

    @Test
    public void validUserIdShouldGetPromoCount () throws UserNotFoundException {
        Integer validUserId = 3;
        User validUser = this.meliUtils.getDefaultUser(3).get();
        Integer promoCount = 1;
        Mockito.when(userRepo.findById(validUserId)).thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(postRepo.findByUserIdAndHasPromo(validUserId, true)).thenReturn(List.of(
                this.meliUtils.genDefaultRecentPromo(validUserId, 20146, "Gamer Bike",
                        22.0)));

        CountPromosResponseDTO response = this.service.getPromoCount(validUserId);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(validUser.getUserName(), response.getUserName());
        Assertions.assertEquals(promoCount, response.getPromoProductsCount());
    }

    @Test
    public void cantGetPromoListFromInvalidUserId () {
        Integer invalidUserId = 213791;
        Mockito.when(userRepo.findById(invalidUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.getPromoPosts(invalidUserId));
    }

    @Test
    public void validUserIdShouldGetPromoPosts () throws UserNotFoundException {
        Integer validUserId = 4;
        Integer promoCount = 2;
        Post firstPromo = this.meliUtils.genDefaultRecentPromo(validUserId, 20634,
                "Gamer Motorcycle", 17.0);
        Post secondPromo = this.meliUtils.genDefaultRecentPromo(validUserId, 20238,
                "Gamer Motorcycle", 22.0);
        Mockito.when(userRepo.findById(validUserId)).thenReturn(this.meliUtils.getDefaultUser(validUserId));
        Mockito.when(postRepo.findByUserIdAndHasPromo(validUserId, true)).thenReturn(List.of(
                firstPromo, secondPromo));

        PostsResponseDTO response = this.service.getPromoPosts(validUserId);

        Assertions.assertEquals(validUserId, response.getUserId());
        Assertions.assertEquals(promoCount, response.getPosts().size());
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(firstPromo, this.mapper.map(p, Post.class))));
        Assertions.assertTrue(response.getPosts().stream().anyMatch(
                p -> this.meliUtils.arePostsEqual(secondPromo, this.mapper.map(p, Post.class))));
    }

    private void mockFollowed (Integer validUserId, List<Integer> validFollowed) {
        ArrayList<User> validUsers = new ArrayList<>();
        for (Integer id : validFollowed) {
            User user = this.meliUtils.getDefaultUser(id).get();
            user.setFollowersId(List.of(validUserId));
            validUsers.add(user);
        }
        Mockito.when(userRepo.findFollowed(validUserId)).thenReturn(validUsers);
    }
}
