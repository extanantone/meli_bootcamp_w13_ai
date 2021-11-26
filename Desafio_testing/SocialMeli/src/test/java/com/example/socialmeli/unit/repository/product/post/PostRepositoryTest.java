package com.example.socialmeli.unit.repository.product.post;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.example.socialmeli.unit.repository.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PostRepositoryTest
{

    @Mock
    UserRepository userRepository;

    @Mock
    Clock clock;

    @InjectMocks
    PostRepository postRepository;


    Map<Integer, User> userMap = null;
    User follower = null;
    User followed = null;
    List<Post> postList = null;
    Post post1 = null;
    Post post2 = null;
    Post post3 = null;
    Post post4 = null;
    Post oldPost1 = null;
    Post oldPost2 = null;
    Clock fixedClock = null;

    @BeforeEach
    void setUp()
    {
        Instant instant = Instant.parse("2021-11-14T16:02:42.00Z");
        ZoneId zoneId = ZoneId.of("America/Bogota");
        fixedClock = Clock.fixed(instant, zoneId);
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();

        follower = new User("Follower");
        followed = new User("Followed");
        follower.follow(followed);
        userMap = new HashMap<>();
        userMap.put(follower.getUserId(), follower);
        userMap.put(followed.getUserId(), follower);
        Product blackChair = new Product(1, "Black chair", "Office", "Razer", "Black", "Good as new");
        post1 = new Post(followed.getUserId(), 1, LocalDate.of(2021, 11, 11), blackChair, 10, 100000, false, 0 );
        post2 = new Post(followed.getUserId(), 2, LocalDate.of(2021, 11, 12), blackChair, 10, 100000, false, 0 );
        post3 = new Post(followed.getUserId(), 3, LocalDate.of(2021, 11, 10), blackChair, 10, 100000, false, 0 );
        post4 = new Post(followed.getUserId(), 4, LocalDate.of(2021, 11, 13), blackChair, 10, 100000, false, 0 );
        oldPost1 = new Post(followed.getUserId(), 5, LocalDate.of(2021, 10, 13), blackChair, 10, 100000, false, 0 );
        oldPost2 = new Post(followed.getUserId(), 6, LocalDate.of(2021, 10, 30), blackChair, 10, 100000, false, 0 );

        followed.addPost(post1);
        followed.addPost(post2);
        followed.addPost(post3);
        followed.addPost(post4);
    }

    // T-0006
    //Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)

    @Test
    void findFollowedTwoWeeksBeforeOrderByDateDesc()
    {
        // Arrange
        List<Post> expected = List.of(post4, post2, post1, post3);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        List<Post> result = postRepository.findFollowedTwoWeeksBeforeOrderByDateDesc(follower.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findFollowedTwoWeeksBeforeOrderByDateAsc()
    {
        // Arrange
        List<Post> expected = List.of(post3, post1, post2, post4);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        List<Post> result = postRepository.findFollowedTwoWeeksBeforeOrderByDateAsc(follower.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }

    // T-0008
    // Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor
    // sean efectivamente de las últimas dos semanas. (US-0006)
    @Test
    void VerifyTwoWeeksConstrainOrderByDateAsc()
    {
        // Arrange
        followed.addPost(oldPost1);
        followed.addPost(oldPost2);
        List<Post> expected = List.of(post3, post1, post2, post4);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        List<Post> result = postRepository.findFollowedTwoWeeksBeforeOrderByDateAsc(follower.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void VerifyTwoWeeksConstrainOrderByDateDesc()
    {
        // Arrange
        followed.addPost(oldPost1);
        followed.addPost(oldPost2);
        List<Post> expected = List.of(post4, post2, post1, post3);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        List<Post> result = postRepository.findFollowedTwoWeeksBeforeOrderByDateDesc(follower.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }


}