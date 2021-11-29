package com.SocialMeli.unit.service;

import com.SocialMeli.dto.*;
import com.SocialMeli.exceptions.BadRequestException;
import com.SocialMeli.model.Post;
import com.SocialMeli.model.ProductDetail;
import com.SocialMeli.model.User;
import com.SocialMeli.repository.UserRepository;
import com.SocialMeli.service.UserService;
import com.google.common.collect.Comparators;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    private HashMap<Integer, User> usersList;
    private HashMap<Integer, Post> postsList;

    private final LocalDate date1 = LocalDate.of(2021, 10, 10);
    private final LocalDate date2 = LocalDate.of(2021, 11, 23);
    private final LocalDate date3 = LocalDate.of(2021, 11, 25);

    private final ProductDetail product1 = new ProductDetail(1,
            "Silla",
            "Mueble",
            "Eames",
            "Blanco",
            "Es una silla común");

    private final ProductDetail product2 = new ProductDetail(2,
            "Mesa",
            "Mueble",
            "Divino",
            "Madera",
            "Mesa de madera maciza");

    private final ProductDetail product3 = new ProductDetail(3,
            "Collar",
            "Accesorio",
            "Pandora",
            "Plateado",
            "Collar de plata 925");

    @BeforeEach
    public void setUp() {
        usersList = new HashMap<>();
        postsList = new HashMap<>();

        usersList.put(5, new User(5, "Juan123", false));
        usersList.put(6, new User(6, "pedro_8", false));
        usersList.put(7, new User(7, "lali_gon", true));
        usersList.put(8, new User(8, "ana-paula", true));

        postsList.put(1, new Post(7, 1, date1, product1, 20, 600.0));
        postsList.put(2, new Post(7, 2, date2, product2, 20, 1500.0));
        postsList.put(3, new Post(7, 3, date3, product3, 20, 20000.0));

        postsList.put(4, new Post(8, 4, date3, product1, 20, 600.0));
        postsList.put(5, new Post(8, 5, date2, product2, 20, 1500.0));
        postsList.put(6, new Post(8, 6, date3, product3, 20, 20000.0));

        User userWithPosts1 = usersList.get(7);
        User userWithPosts2 = usersList.get(8);

        userWithPosts1.getPosts().add(1);
        userWithPosts1.getPosts().add(2);
        userWithPosts1.getPosts().add(3);

        userWithPosts2.getPosts().add(4);
        userWithPosts2.getPosts().add(5);
        userWithPosts2.getPosts().add(6);

    }

    @Test
    @DisplayName("If user to be followed exists, then continue execution")
    public void followUserSuccess() {

        Integer followerUserId = 5;
        Integer userToFollowId = 6;

        when(repository.getUsers()).thenReturn(usersList);

        HttpStatus expected = HttpStatus.OK;
        HttpStatus response = service.followUser(followerUserId,
                userToFollowId).getStatusCode();

        verify(repository, atLeastOnce()).getUsers();

        assertEquals(expected, response);

    }

    @Test
    @DisplayName("If user to be followed doesn't exists, then throws exception")
    public void followUserFailure() {

        Integer followerUserId = 5;
        Integer userToFollowId = 10;

        when(repository.getUsers()).thenReturn(usersList);

        assertThrows(BadRequestException.class,
                () -> service.followUser(followerUserId, userToFollowId).getStatusCode());

        verify(repository, atLeastOnce()).getUsers();

    }

//    ------------------------------------------------------------------------------------------------------------------------------------

    @Test
    @DisplayName("If user to be unfollowed exists, then continue execution")
    public void unfollowUserSuccess() {

        Integer followerUserId = 5;
        Integer userToUnfollowId = 6;

        usersList.get(followerUserId).getFollowedUsers().add(userToUnfollowId);
        usersList.get(userToUnfollowId).getFollowers().add(followerUserId);

        when(repository.getUsers()).thenReturn(usersList);

        HttpStatus expected = HttpStatus.OK;
        HttpStatus response = service.unfollowUser(followerUserId,
                userToUnfollowId).getStatusCode();

        verify(repository, atLeastOnce()).getUsers();

        assertEquals(expected, response);

    }

    @Test
    @DisplayName("If user to be unfollowed doesn't exists, then throws " +
            "exception")
    public void unfollowUserFailure() {

        Integer followerUserId = 5;
        Integer userToUnfollowId = 10;

        when(repository.getUsers()).thenReturn(usersList);

        assertThrows(BadRequestException.class,
                () -> service.unfollowUser(followerUserId, userToUnfollowId).getStatusCode());

        verify(repository, atLeastOnce()).getUsers();

    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class FollowedSellersOrderParam {
        Integer userId = 5;
        Integer followedUser1Id = 7;
        Integer followedUser2Id = 8;

        User user;
        User followedUser1;
        User followedUser2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            followedUser1 = usersList.get(followedUser1Id);
            followedUser2 = usersList.get(followedUser2Id);

            user.getFollowedUsers().add(followedUser1Id);
            user.getFollowedUsers().add(followedUser2Id);
            followedUser1.getFollowers().add(userId);
            followedUser2.getFollowers().add(userId);
        }

        @Test
        @DisplayName("If order param is valid when getting list of sellers followed by a user, " +
                "continue execution")
        public void listOfFollowersWithOrder() {
            String order = "name_asc";

            when(repository.getUsers()).thenReturn(usersList);

            HttpStatus expected = HttpStatus.OK;
            HttpStatus response = service.getFollowedSellersList(userId, order).getStatusCode();

            verify(repository, atLeastOnce()).getUsers();

            assertEquals(expected, response);
        }


        @Test
        @DisplayName("If order param is null  when getting list of sellers followed by a user, " +
                "throws exception")
        public void listOfFollowersWithoutOrder() {

            when(repository.getUsers()).thenReturn(usersList);

            assertThrows(BadRequestException.class, () -> service.getFollowedSellersList(userId,
                    null).getStatusCode());

            verify(repository, atLeastOnce()).getUsers();
        }
    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class SellersFollowersOrderParam {
        Integer userId = 7;
        Integer followedUser1Id = 5;
        Integer followedUser2Id = 8;

        User user;
        User followedUser1;
        User followedUser2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            followedUser1 = usersList.get(followedUser1Id);
            followedUser2 = usersList.get(followedUser2Id);

            user.getFollowedUsers().add(followedUser1Id);
            user.getFollowedUsers().add(followedUser2Id);
            followedUser1.getFollowers().add(userId);
            followedUser2.getFollowers().add(userId);
        }

        @Test
        @DisplayName("If order param is valid when getting list of followers of a seller, " +
                "continue execution")
        public void listOfFollowedSellersWithOrder() {
            String order = "name_asc";

            when(repository.getUsers()).thenReturn(usersList);

            HttpStatus expected = HttpStatus.OK;
            HttpStatus response = service.getSellerFollowersList(userId, order).getStatusCode();

            verify(repository, atLeastOnce()).getUsers();

            assertEquals(expected, response);
        }


        @Test
        @DisplayName("If order param is null when getting list of followers of a seller, throws " +
                "exception")
        public void listOfFollowedSellersWithoutOrder() {

            when(repository.getUsers()).thenReturn(usersList);

            assertThrows(BadRequestException.class, () -> service.getSellerFollowersList(userId,
                    null).getStatusCode());

            verify(repository, atLeastOnce()).getUsers();
        }
    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class SellersFollowers {
        Integer userId = 7;

        Integer follower1Id = 5;
        Integer follower2Id = 6;

        User user;
        User follower1;
        User follower2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            follower1 = usersList.get(follower1Id);
            follower2 = usersList.get(follower2Id);

            user.getFollowers().add(follower1Id);
            user.getFollowers().add(follower2Id);
            follower1.getFollowedUsers().add(userId);
            follower2.getFollowedUsers().add(userId);

        }

        @Test
        @DisplayName("Returns list of followers ordered by ascending name")
        public void listFollowersByAscendingName() {
            String order = "name_asc";

            when(repository.getUsers()).thenReturn(usersList);

            FollowersDTO response = service.getSellerFollowersList(userId, order).getBody();

            verify(repository, atLeastOnce()).getUsers();

            Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
            assertTrue(Comparators.isInOrder(response.getFollowers(), comparator));
        }

        @Test
        @DisplayName("Returns list of followers ordered by descending name")
        public void listFollowersByDescendingName() {
            String order = "name_desc";

            when(repository.getUsers()).thenReturn(usersList);

            FollowersDTO response = service.getSellerFollowersList(userId, order).getBody();

            verify(repository, atLeastOnce()).getUsers();

            Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
            assertFalse(Comparators.isInOrder(response.getFollowers(), comparator));

        }
    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class FollowedSellers {
        Integer userId = 5;
        Integer followedUser1Id = 7;
        Integer followedUser2Id = 8;

        User user;
        User followedUser1;
        User followedUser2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            followedUser1 = usersList.get(followedUser1Id);
            followedUser2 = usersList.get(followedUser2Id);

            user.getFollowedUsers().add(followedUser1Id);
            user.getFollowedUsers().add(followedUser2Id);
            followedUser1.getFollowers().add(userId);
            followedUser2.getFollowers().add(userId);
        }

        @Test
        @DisplayName("Returns list of followed sellers ordered by ascending name")
        public void listFollowedSellersByAscendingName() {

            String order = "name_asc";

            when(repository.getUsers()).thenReturn(usersList);

            FollowedUsersDTO response = service.getFollowedSellersList(userId, order).getBody();

            verify(repository, atLeastOnce()).getUsers();

            Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
            assert response != null;
            assertTrue(Comparators.isInOrder(response.getFollowedUsers(), comparator));
        }

        @Test
        @DisplayName("Returns list of followed sellers ordered by descending name")
        public void listFollowedSellersByDescendingName() {

            String order = "name_desc";

            when(repository.getUsers()).thenReturn(usersList);

            FollowedUsersDTO response = service.getFollowedSellersList(userId, order).getBody();

            Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

            verify(repository, atLeastOnce()).getUsers();

            assertFalse(Comparators.isInOrder(response.getFollowedUsers(), comparator));
        }
    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class FollowedSellersPostsWithOrder {
        Integer userId = 5;
        Integer followedUser1Id = 7;
        Integer followedUser2Id = 8;

        User user;
        User followedUser1;
        User followedUser2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            followedUser1 = usersList.get(followedUser1Id);
            followedUser2 = usersList.get(followedUser2Id);

            user.getFollowedUsers().add(followedUser1Id);
            user.getFollowedUsers().add(followedUser2Id);
            followedUser1.getFollowers().add(userId);
            followedUser2.getFollowers().add(userId);

        }

        @Test
        @DisplayName("Returns list of followed sellers recent posts, if order param is valid")
        public void listOfFollowedSellersPostsWithValidOrderParam() {

            String order = "date_asc";

            when(repository.getUsers()).thenReturn(usersList);
            when(repository.getPosts()).thenReturn(postsList);

            HttpStatus expected = HttpStatus.OK;
            HttpStatus response =
                    service.getFollowedSellersRecentPosts(userId, order).getStatusCode();

            verify(repository, atLeastOnce()).getUsers();
            verify(repository, atLeastOnce()).getPosts();

            assertEquals(expected, response);

        }

        @Test
        @DisplayName("Throws exception if order param is null when requesting list of followed sellers posts")
        public void listOfFollowedSellersPostsWithNoOrderParam() {

            assertThrows(BadRequestException.class, () -> service.getFollowedSellersRecentPosts(userId,
                    null).getStatusCode());


        }
    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class FollowedSellersPosts {
        Integer userId = 5;
        Integer followedUser1Id = 7;
        Integer followedUser2Id = 8;

        User user;
        User followedUser1;
        User followedUser2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            followedUser1 = usersList.get(followedUser1Id);
            followedUser2 = usersList.get(followedUser2Id);

            user.getFollowedUsers().add(followedUser1Id);
            user.getFollowedUsers().add(followedUser2Id);
            followedUser1.getFollowers().add(userId);
            followedUser2.getFollowers().add(userId);

        }

        @Test
        @DisplayName("Returns list of followed sellers posts ordered by ascending date")
        public void listFollowedSellersByAscendingName() {
            String order = "date_asc";

            when(repository.getUsers()).thenReturn(usersList);
            when(repository.getPosts()).thenReturn(postsList);

            List<PostsListDTO> response =
                    service.getFollowedSellersRecentPosts(userId, order).getBody();

            verify(repository, atLeastOnce()).getUsers();
            verify(repository, atLeastOnce()).getPosts();

            Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate);
            assert response != null;
            for (PostsListDTO list : response) {
                assertTrue(Comparators.isInOrder(list.getPosts(), comparator));
            }

        }

        @Test
        @DisplayName("Returns list of followed sellers posts ordered by descending date")
        public void listFollowedSellersByDescendingName() {
            String order = "date_desc";
            when(repository.getUsers()).thenReturn(usersList);
            when(repository.getPosts()).thenReturn(postsList);

            List<PostsListDTO> response =
                    service.getFollowedSellersRecentPosts(userId, order).getBody();

            verify(repository, atLeastOnce()).getUsers();
            verify(repository, atLeastOnce()).getPosts();

            Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate);
            assert response != null;
            for (PostsListDTO list : response) {
                assertFalse(Comparators.isInOrder(list.getPosts(), comparator));
            }
        }

    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class FollowersCount {
        Integer userId = 7;
        Integer followerUserId1 = 5;
        Integer followerUserId2 = 8;

        User user;
        User followerUser1;
        User followerUser2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            followerUser1 = usersList.get(followerUserId1);
            followerUser2 = usersList.get(followerUserId2);

            user.getFollowers().add(followerUserId1);
            user.getFollowers().add(followerUserId2);
            followerUser1.getFollowedUsers().add(userId);
            followerUser2.getFollowedUsers().add(userId);

        }

        @Test
        @DisplayName("Returns the correct amount of followers of a given seller")
        public void sellersFollowersCount() {

            FollowersCountDTO expected = new FollowersCountDTO(userId, user.getUserName(), 2);

            when(repository.getUsers()).thenReturn(usersList);

            FollowersCountDTO response = service.getFollowersCount(userId).getBody();
            verify(repository, atLeastOnce()).getUsers();

            assertEquals(expected, response);
        }
    }

    //    ------------------------------------------------------------------------------------------------------------------------------------

    @Nested
    class FollowedSellersRecentPosts {
        Integer userId = 7;
        Integer followerUserId1 = 5;
        Integer followerUserId2 = 8;

        User user;
        User followerUser1;
        User followerUser2;

        @BeforeEach
        public void setUp() {
            user = usersList.get(userId);
            followerUser1 = usersList.get(followerUserId1);
            followerUser2 = usersList.get(followerUserId2);

            user.getFollowers().add(followerUserId1);
            user.getFollowers().add(followerUserId2);
            followerUser1.getFollowedUsers().add(userId);
            followerUser2.getFollowedUsers().add(userId);

        }

        private boolean isDateRecent(LocalDate date) {
            int months = Period.between(date, LocalDate.now()).getMonths();
            if (months < 1) {
                return Period.between(date, LocalDate.now()).getDays() <= 14;
            } else return false;
        }

        @Test
        @DisplayName("Returns posts since 14 days before until present only")
        public void recentSellersPosts() {
            String order = "date_desc";

            when(repository.getUsers()).thenReturn(usersList);
            when(repository.getPosts()).thenReturn(postsList);

            List<PostsListDTO> response =
                    service.getFollowedSellersRecentPosts(userId, order).getBody();

            assert response != null;
            for (PostsListDTO list : response) {
                for (PostDTO post : list.getPosts()) {
                    assertTrue(isDateRecent(post.getDate()));
                }
            }

            verify(repository, atLeastOnce()).getUsers();
            verify(repository, atLeastOnce()).getPosts();
        }
    }
}
