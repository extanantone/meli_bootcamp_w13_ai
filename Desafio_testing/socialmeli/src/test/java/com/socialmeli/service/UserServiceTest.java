package com.socialmeli.service;

import com.socialmeli.dto.*;
import com.socialmeli.exception.InvalidPostException;
import com.socialmeli.exception.InvalidSellerException;
import com.socialmeli.exception.InvalidUserException;
import com.socialmeli.exception.NotFoundUserException;
import com.socialmeli.model.Post;
import com.socialmeli.model.User;
import com.socialmeli.repository.IUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private IUserRepository iUserRepository;


    @AfterEach
    public void resetMocks(){
        Mockito.reset(iUserRepository);
    }


    // T001 Follow
    @Test
    public void shouldBeFollowerExistUser(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        // Verifica no salte ninguna excepcion
        assertDoesNotThrow(()->userService.followUser(1,2));
        // Se llama el get del repositorio
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
        // Agrego el usuario
        assertEquals(followed.getFollowers().size(),1);


    }

    @Test
    public void shouldntBeFollowUnexistUser(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = null;
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        assertThrows(NotFoundUserException.class,()->userService.followUser(1,2));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
    }

    @Test
    public void shouldntBeFollowUserIfUnexistFollower(){
        User follower = null;
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());;
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        assertThrows(NotFoundUserException.class,()->userService.followUser(1,2));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
    }

    // T001 Complementary
    @Test
    public void shouldFailIfUserFollowerIsFollower(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        followed.addFollower(follower);
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        assertTrue(followed.isFollower(follower));
        assertThrows(InvalidSellerException.class,()->userService.followUser(1,2));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
    }

    // T002 Unfollow
    @Test
    public void shouldBeUnfollowExistFollower(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        followed.addFollower(follower);
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        assertTrue(followed.isFollower(follower));
        assertDoesNotThrow(()->userService.unfollowSeller(1,2));
        assertFalse(followed.isFollower(follower));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
    }

    @Test
    public void shouldntBeUnfollowUnexistFollower(){
        User follower = null;
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        assertThrows(NotFoundUserException.class,()->userService.unfollowSeller(1,2));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
    }

    @Test
    public void shouldntBeUnfollowUnexistFollowed(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = null;
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        assertThrows(NotFoundUserException.class,()->userService.unfollowSeller(1,2));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
    }


    @Test
    public void shouldntBeUnfollowUserIfNotFolloer(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(follower);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        assertFalse(followed.isFollower(follower));
        assertThrows(NotFoundUserException.class,()->userService.unfollowSeller(1,2));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(2);
    }

    // T003 - T004 Ordenamiento por nombre follower
    @Test
    public void shouldBeOrderByNameAscFollowers(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User follower2 = new User(2,"Diego","diego@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User follower3 = new User(3,"Luis","luis@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        followed.addFollower(follower);
        followed.addFollower(follower3);
        followed.addFollower(follower2);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        FollowerListDto listDto = userService.getFollowerListOrderByNameAsc(2);
        for(int i=1;i<listDto.getFollowers().size();i++){
            FollowerItemDto fitem = listDto.getFollowers().get(i-1);
            FollowerItemDto sitem = listDto.getFollowers().get(i);
            assertNotEquals(fitem.getUserName(),sitem.getUserName());
            assertTrue(fitem.getUserName().compareTo(sitem.getUserName())<=0);
        }
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());
    }

    @Test
    public void shouldBeOrderByNameDescFollowers(){
        User follower = new User(1,"Juan","juan@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User follower2 = new User(2,"Diego","diego@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User follower3 = new User(3,"Luis","luis@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User followed = new User(2,"david","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        followed.addFollower(follower);
        followed.addFollower(follower3);
        followed.addFollower(follower2);
        Mockito.when(iUserRepository.getUserById(2)).thenReturn(followed);
        FollowerListDto listDto = userService.getFollowerListOrderByNameDesc(2);
        assertTrue(listDto.getFollowers().size()==3);
        for(int i=1;i<listDto.getFollowers().size();i++){
            FollowerItemDto fitem = listDto.getFollowers().get(i-1);
            FollowerItemDto sitem = listDto.getFollowers().get(i);
            assertNotEquals(fitem.getUserName(),sitem.getUserName());
            assertTrue(fitem.getUserName().compareTo(sitem.getUserName())>=0);
        }
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());
    }

    // T005 Odenar followed por nombre ascendente y desendente
    @Test
    public void shouldBeSortAscNameFollowed(){
        User seller =  new User(3,"daniel","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        User seller2 = new User(4,"luis","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        User seller3 = new User(5,"jorge","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        User buyer = new User(1,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>());
        Mockito.when(iUserRepository.followedUser(buyer)).thenReturn(List.of(seller3,seller2,seller));
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(buyer);
        FollowedListDto followedListDto = userService.getFollowedListOrderByNameAsc(1);
        assertEquals(followedListDto.getFollowed().size(),3);
        for(int i=1;i<3;i++){
            FollowedItemDto fitem = followedListDto.getFollowed().get(i-1);
            FollowedItemDto sitem = followedListDto.getFollowed().get(i);
            assertNotEquals(fitem.getUserName(),sitem.getUserName());
            assertTrue(fitem.getUserName().compareTo(sitem.getUserName())<=0);
        }

        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).followedUser(buyer);
    }

    @Test
    public void shouldBeSortDescNameFollowed(){
        User seller =  new User(3,"daniel","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        User seller2 = new User(4,"luis","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        User seller3 = new User(5,"jorge","david@mail.com",new ArrayList<>(),true,new ArrayList<>());
        User buyer = new User(1,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>());
        Mockito.when(iUserRepository.followedUser(buyer)).thenReturn(List.of(seller3,seller2,seller));
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(buyer);
        FollowedListDto followedListDto = userService.getFollowedListOrderByNameDesc(1);
        assertEquals(followedListDto.getFollowed().size(),3);
        for(int i=1;i<3;i++){
            FollowedItemDto fitem = followedListDto.getFollowed().get(i-1);
            FollowedItemDto sitem = followedListDto.getFollowed().get(i);
            assertNotEquals(fitem.getUserName(),sitem.getUserName());
            assertTrue(fitem.getUserName().compareTo(sitem.getUserName())>=0);
        }

        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).followedUser(buyer);
    }

    @Test
    public void shouldntBeFindListOrderAscDateIfUserUnexist(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(null);
        assertThrows(NotFoundUserException.class,()->userService.getFollowedListOrderByNameAsc(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(0)).getPostLastTwoWeeksOfFollowed(1);
    }

    @Test
    public void shouldntBeFindListOrderDescDateIfUserUnexist(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(null);
        assertThrows(NotFoundUserException.class,()->userService.getFollowedListOrderByNameDesc(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(0)).getPostLastTwoWeeksOfFollowed(1);
    }

    // T006 - Ordenamiento por fecha
    @Test
    public void shouldBeSortAscPublishOfNextTwoWeeks(){
        User user = new User(1,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>());
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(user);
        Mockito.when(iUserRepository.getPostLastTwoWeeksOfFollowed(1)).thenReturn(
                List.of(
                        new Post(1, LocalDate.now().minusDays(3),1,"zapato","zapato","","black","",10,1,false,0),
                        new Post(1, LocalDate.now().minusDays(4),1,"zapato","zapato","","black","",10,1,false,0),
                        new Post(1, LocalDate.now().minusDays(5),1,"zapato","zapato","","black","",10,1,false,0)
                ));
        ListPostDto listPostDto = userService.getListDtoSubscriptionByUserAndOrderByDateAsc(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getPostLastTwoWeeksOfFollowed(1);
        assertEquals(listPostDto.getPosts().size(),3);
        for(int i=1;i<3;i++){
            PostDtoWithoutUser fdto = listPostDto.getPosts().get(i-1);
            PostDtoWithoutUser sdto = listPostDto.getPosts().get(i);
            LocalDate fdate = LocalDate.parse(fdto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate sdate = LocalDate.parse(sdto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            assertTrue(fdate.isBefore(sdate));
        }
    }

    @Test
    public void shouldBeSortDescPublishOfNextTwoWeeks(){
        User user = new User(1,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>());
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(user);
        Mockito.when(iUserRepository.getPostLastTwoWeeksOfFollowed(1)).thenReturn(
                List.of(
                        new Post(5, LocalDate.now().minusDays(3),3,"zapato","zapato","","black","",10,1,false,0),
                        new Post(6, LocalDate.now().minusDays(4),4,"zapato","zapato","","black","",10,1,false,0),
                        new Post(7, LocalDate.now().minusDays(5),5,"zapato","zapato","","black","",10,1,false,0)
                ));
        ListPostDto listPostDto = userService.getListDtoSubscriptionByUserAndOrderByDateDesc(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getPostLastTwoWeeksOfFollowed(1);
        assertEquals(listPostDto.getPosts().size(),3);
        for(int i=1;i<3;i++){
            PostDtoWithoutUser fdto = listPostDto.getPosts().get(i-1);
            PostDtoWithoutUser sdto = listPostDto.getPosts().get(i);
            assertNotEquals(fdto.getPostId(),sdto.getPostId());
            LocalDate fdate = LocalDate.parse(fdto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate sdate = LocalDate.parse(sdto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            assertTrue(fdate.isAfter(sdate));
        }
    }

    // T007 Count followers
    @Test
    public void shouldntCountFollowersIfUserNotExist(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(null);
        assertThrows(NotFoundUserException.class,()->userService.getCountBySeller(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
    }

    @Test
    public void shouldntBeCountIfUserIsntSeller(){
        User buyer = new User(1,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>());
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(buyer);
        assertThrows(InvalidSellerException.class,()->userService.getCountBySeller(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());
    }

    @Test
    public void shouldBeCountFollowersForValidUser(){
        User seller = new User(1,"pablo","pablo@mail.com",new ArrayList<>(),true,new ArrayList<>());
        seller.addFollower(new User(2,"luis","luis@mail.com",new ArrayList<>(),false,new ArrayList<>()));
        seller.addFollower(new User(3,"jorge","jorge@mail.com",new ArrayList<>(),false,new ArrayList<>()));
        seller.addFollower(new User(4,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>()));
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(seller);
        SellerFollowersCountDto sellerFollowersCountDto = userService.getCountBySeller(1);
        assertEquals(sellerFollowersCountDto.getFollowersCount(),3);
        assertEquals(sellerFollowersCountDto.getUserName(),seller.getName());
        assertEquals(sellerFollowersCountDto.getUserId(),seller.getId());
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);

    }

    @Test
    public void shoundntBeFoundFollowerlIstForUnexistUser(){

        Mockito.when(iUserRepository.getUserById(1)).thenReturn(null);
        assertThrows(NotFoundUserException.class,()->userService.getFollowerList(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);

    }

    @Test
    public void shouldntBeFoundFollowerListForUserNotSeller(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(new User("pablo","pablo@mail.com",false));
        assertThrows(InvalidSellerException.class,()->userService.getFollowerList(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
    }

    @Test
    public void shouldBeFoundFollowerList(){
        User user = new User("pablo","pablo@mail.com",true);
        user.addFollower(new User("Luis","luis@mail.com",false));
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(user);
        FollowerListDto list = userService.getFollowerList(1);
        assertEquals(list.getUserId(),user.getId());
        assertEquals(list.getUserName(),user.getName());
        assertEquals(list.getFollowers().size(),1);
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(1);
    }

    @Test
    public void shouldntBeFindFollowed(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(null);
        assertThrows(NotFoundUserException.class,()->userService.getFollowed(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());
    }

    @Test
    public void shouldBeFindFollowed(){
        User user = new User("pablo","pablo@mail.com",true);
        user.setId(1);
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(user);
        List<User> followed = List.of();
        Mockito.when(iUserRepository.followedUser(user)).thenReturn(followed);
        FollowedListDto listDto = userService.getFollowed(1);
        assertEquals(listDto.getUserId(),user.getId());
        assertEquals(listDto.getUserName(),user.getName());
        assertTrue(listDto.getFollowed().isEmpty());
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());
        Mockito.verify(iUserRepository,Mockito.times(1)).followedUser(user);
    }

    @Test
    public void shouldntBeAddPostIfUserNotExist(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(null);
        assertThrows(NotFoundUserException.class,()->userService.addPost(new PostDto(1,1,LocalDate.now().toString(),null,1,1)));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());
    }

    @Test
    public void shouldBeAddNewPost(){
        User user = new User("pablo","pablo@mail.com",true);
        PostDto post = new PostDto(1,1,"01-01-2021",new DetailDto(1,"zapato","","","",""),1,1);
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(user);
        assertDoesNotThrow(()->userService.addPost(post));
        assertEquals(user.getPosts().size(),1);
    }

    @Test
    public void shouldntBeAddNewPostIfExistPostWithSameId(){
        User user = new User("pablo","pablo@mail.com",true);
        PostDto post = new PostDto(1,1,"01-01-2021",new DetailDto(1,"zapato","","","",""),1,1);
        Post postentity = new Post();
        postentity.setId(1);
        user.addPost(postentity);
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(user);
        assertThrows(InvalidPostException.class,()->userService.addPost(post));
        assertEquals(user.getPosts().size(),1);
    }

    @Test
    public void shouldntBeAddNewUserIfExist(){
        User user = new User("Juan","juan@test.com",true);
        Mockito.when(iUserRepository.findUserByEmail("juan@test.com")).thenReturn(user);
        assertThrows(InvalidUserException.class,()->userService.addUser(new UserRequestDto("Juan","juan@test.com",true)));
        Mockito.verify(iUserRepository,Mockito.times(1)).findUserByEmail(Mockito.anyString());
    }

    @Test
    public void souldntBeFindPostWithDiscountExceptionIfUserUnexist(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(null);
        assertThrows(NotFoundUserException.class,()->userService.getProductDiscountListDto(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());
    }

    @Test
    public void souldntBeFindPostWithDiscountExceptionIfUserIsNotSeller(){
        Mockito.when(iUserRepository.getUserById(1)).thenReturn(new User("Juan","juan@test.com",false));
        assertThrows(InvalidSellerException.class,()->userService.getProductDiscountListDto(1));
        Mockito.verify(iUserRepository,Mockito.times(1)).getUserById(Mockito.anyInt());

    }

    @Test
    public void shouldBeFinAllSellers(){
        Mockito.when(iUserRepository.findAllSellers()).thenReturn(List.of());
        assertTrue(userService.getAllSellers().isEmpty());
    }

    @Test
    public void shouldBeFinAllUsers(){
        Mockito.when(iUserRepository.findAll()).thenReturn(List.of());
        assertTrue(userService.getAllUsers().isEmpty());
    }


}
