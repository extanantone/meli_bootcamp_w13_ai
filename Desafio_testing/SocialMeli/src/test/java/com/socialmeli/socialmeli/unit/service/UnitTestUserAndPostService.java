package com.socialmeli.socialmeli.unit.service;

import com.socialmeli.socialmeli.dto.ResponseSuccessfullyDTO;
import com.socialmeli.socialmeli.dto.post.FollowedSellerPostDTO;
import com.socialmeli.socialmeli.dto.post.PostWithoutDiscountDTO;
import com.socialmeli.socialmeli.dto.post.ProductDTO;
import com.socialmeli.socialmeli.dto.user.UserDTO;
import com.socialmeli.socialmeli.dto.user.UserFollowersListDTO;
import com.socialmeli.socialmeli.exceptions.userExceptions.NotFoundUserException;
import com.socialmeli.socialmeli.mapper.PostMapper;
import com.socialmeli.socialmeli.mapper.UserMapper;
import com.socialmeli.socialmeli.model.Post;
import com.socialmeli.socialmeli.model.Product;
import com.socialmeli.socialmeli.model.User;
import com.socialmeli.socialmeli.repository.PostRepository;
import com.socialmeli.socialmeli.repository.UserRepository;
import com.socialmeli.socialmeli.service.UserAndPostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UnitTestUserAndPostService {

    @Mock
    UserRepository mockUserRepository;

    @Mock
    PostRepository mockPostRepository;

    @Mock
    ResponseSuccessfullyDTO mockResponseSuccessfully;

    @Mock
    UserMapper mockUserMapper;

    @Mock
    PostMapper mockPostMapper;

    @InjectMocks
    UserAndPostService userAndPostService;

    //T-0001 Verificar que el usuario a seguir exista. (US-0001)
    @Test
    public void testFollowWithCorrectUserIdToFollow() {
        /*AR*/
        int user_id = 1;
        int user_id_to_follow = 2;

        when(mockUserRepository.addFollow(user_id, user_id_to_follow)).thenReturn("true");
        when(mockUserRepository.getUserName(user_id)).thenReturn("Juan");
        when(mockUserRepository.getUserName(user_id_to_follow)).thenReturn("Pedro");

        Map<String, Object> map = new HashMap<>();
        map.put("correcto", 1);
        when(mockResponseSuccessfully.buildJson("User Juan now follow Pedro")).thenReturn(map);

        /*AC*/
        Map<String, Object> currentMap = userAndPostService.addFollower(user_id, user_id_to_follow);

        /*AS*/
        verify(mockUserRepository, atLeastOnce()).addFollow(user_id, user_id_to_follow);
        Assertions.assertEquals(1, currentMap.get("correcto"));
    }

    @Test
    public void testFollowWithIncorrectUserIdToFollow() {
        /*AR*/
        int user_id = 1;
        int user_id_to_follow = 43;

        when(mockUserRepository.addFollow(user_id, user_id_to_follow)).thenReturn("notExistentUserToFollow");


        /*AC*/
        NotFoundUserException thrown = Assertions.assertThrows(NotFoundUserException.class, () -> {
            userAndPostService.addFollower(user_id, user_id_to_follow);
        }, "NumberFormatException was expected");

        /*AS*/
        verify(mockUserRepository, atLeastOnce()).addFollow(user_id, user_id_to_follow);
        Assertions.assertEquals(user_id_to_follow, thrown.getId());
    }


    //T-0002 Verificar que el usuario a dejar de seguir exista. (US-0007)
    @Test
    public void testUnfollowWithCorrectUserIdToFollow() {
        /*AR*/
        int user_id = 1;
        int user_id_to_follow = 2;

        when(mockUserRepository.unfollow(user_id, user_id_to_follow)).thenReturn("true");
        when(mockUserRepository.getUserName(user_id)).thenReturn("Juan");
        when(mockUserRepository.getUserName(user_id_to_follow)).thenReturn("Pedro");


        Map<String, Object> map = new HashMap<>();
        map.put("correcto", 1);
        when(mockResponseSuccessfully.buildJson("User Juan now unfollow Pedro")).thenReturn(map);

        /*AC*/
        Map<String, Object> currentMap = userAndPostService.unfollow(user_id, user_id_to_follow);

        /*AS*/
        verify(mockUserRepository, atLeastOnce()).unfollow(user_id, user_id_to_follow);
        Assertions.assertEquals(1, currentMap.get("correcto"));
    }

    @Test
    public void testUnfollowWithIncorrectUserIdToFollow() {
        /*AR*/
        int user_id = 1;
        int user_id_to_follow = 43;

        when(mockUserRepository.unfollow(user_id, user_id_to_follow)).thenReturn("notExistentUserToFollow");


        /*AC*/
        NotFoundUserException thrown = Assertions.assertThrows(NotFoundUserException.class, () -> {
            userAndPostService.unfollow(user_id, user_id_to_follow);
        }, "");

        /*AS*/
        verify(mockUserRepository, atLeastOnce()).unfollow(user_id, user_id_to_follow);
        Assertions.assertEquals(user_id_to_follow, thrown.getId());
    }


    //T-0003 Verificar que el tipo de ordenamiento alfabético exista (US-0008)

    //T-0004 Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
    //public UserFollowersListDTO listUserFollowex(int user_id, boolean isFollowersList, String order) {
    @Test
    public void testOrderListFollowersOfUserWithOrderNameAsc() {
        /*AR*/
        //Repo mocks
        User u5 = new User(5, "TestUser5");
        List<Integer> followersList = new ArrayList<>();
        followersList.add(1);
        followersList.add(2);
        followersList.add(3);
        followersList.add(4);
        u5.setFollowers(followersList);
        u5.setFollowed(followersList);
        when(mockUserRepository.getUser(5)).thenReturn(u5);

        User u1 = new User(1, "TestUser1");
        when(mockUserRepository.getUser(1)).thenReturn(u1);

        User u2 = new User(2, "TestUser2");
        when(mockUserRepository.getUser(2)).thenReturn(u2);

        User u3 = new User(3, "TestUser3");
        when(mockUserRepository.getUser(3)).thenReturn(u3);

        User u4 = new User(4, "TestUser4");
        when(mockUserRepository.getUser(4)).thenReturn(u4);


        when(mockUserRepository.userExists(5)).thenReturn(true);




        //Mappers mocks
        UserDTO uDto1 = new UserDTO(1, "UserCCC");
        when(mockUserMapper.userToUserDTO(u1)).thenReturn(uDto1);
        UserDTO uDto2 = new UserDTO(2, "UserAAA");
        when(mockUserMapper.userToUserDTO(u2)).thenReturn(uDto2);
        UserDTO uDto3 = new UserDTO(3, "UserDDD");
        when(mockUserMapper.userToUserDTO(u3)).thenReturn(uDto3);
        UserDTO uDto4 = new UserDTO(4, "UserBBB");
        when(mockUserMapper.userToUserDTO(u4)).thenReturn(uDto4);


        /*AC*/
        UserFollowersListDTO currentUserFollowersList = userAndPostService.listUserFollowex(5, true, "name_asc");
        /*AS*/
        Assertions.assertEquals("UserAAA", currentUserFollowersList.getFollowers().get(0).getUser_name());
        Assertions.assertEquals("UserDDD", currentUserFollowersList.getFollowers().get(3).getUser_name());

    }

    @Test
    public void testOrderListFollowersOfUserWithOrderNameDesc() {
        /*AR*/
        //Repo mocks
        User u5 = new User(5, "TestUser5");
        List<Integer> followersList = new ArrayList<>();
        followersList.add(1);
        followersList.add(2);
        followersList.add(3);
        followersList.add(4);
        u5.setFollowers(followersList);
        u5.setFollowed(followersList);
        when(mockUserRepository.getUser(5)).thenReturn(u5);

        User u1 = new User(1, "TestUser1");
        when(mockUserRepository.getUser(1)).thenReturn(u1);

        User u2 = new User(2, "TestUser2");
        when(mockUserRepository.getUser(2)).thenReturn(u2);

        User u3 = new User(3, "TestUser3");
        when(mockUserRepository.getUser(3)).thenReturn(u3);

        User u4 = new User(4, "TestUser4");
        when(mockUserRepository.getUser(4)).thenReturn(u4);


        when(mockUserRepository.userExists(5)).thenReturn(true);




        //Mappers mocks
        UserDTO uDto1 = new UserDTO(1, "UserCCC");
        when(mockUserMapper.userToUserDTO(u1)).thenReturn(uDto1);
        UserDTO uDto2 = new UserDTO(2, "UserAAA");
        when(mockUserMapper.userToUserDTO(u2)).thenReturn(uDto2);
        UserDTO uDto3 = new UserDTO(3, "UserDDD");
        when(mockUserMapper.userToUserDTO(u3)).thenReturn(uDto3);
        UserDTO uDto4 = new UserDTO(4, "UserBBB");
        when(mockUserMapper.userToUserDTO(u4)).thenReturn(uDto4);

        when(mockUserRepository.userExists(5)).thenReturn(true);

        /*AC*/
        UserFollowersListDTO currentUserFollowersList = userAndPostService.listUserFollowex(5, true, "name_desc");
        /*AS*/
        Assertions.assertEquals("UserDDD", currentUserFollowersList.getFollowers().get(0).getUser_name());
        Assertions.assertEquals("UserAAA", currentUserFollowersList.getFollowers().get(3).getUser_name());

    }


    //T-0006 Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)
    //public FollowedSellerPostDTO followedSellersPost(int user_id,String order){
    @Test
    public void testOrderDatePostFollowedWithDateAsc() {
        when(mockUserRepository.userExists(2)).thenReturn(true);


        User u1 = new User(1, "User1");
        u1.addFollower(2);
        u1.addPublication(1);
        when(mockUserRepository.getUser(1)).thenReturn(u1);
        User u2 = new User(2, "User2");
        u2.addFollowed(1);
        u2.addFollowed(3);
        when(mockUserRepository.getUser(2)).thenReturn(u2);
        User u3 = new User(3, "User3");
        u3.addFollower(2);
        u3.addPublication(2);
        when(mockUserRepository.getUser(3)).thenReturn(u3);

        Product pr1 = new Product(1, "product1", "1", "brand1", "color1", "notes1");
        Post p1 = new Post(1, 1, LocalDate.parse("2021-11-25"), pr1, 1, 22.22, false, 0.00);
        when(mockPostRepository.getPost(1)).thenReturn(p1);

        Product pr2 = new Product(2, "product2", "1", "brand1", "color1", "notes1");
        Post p2 = new Post(3, 2, LocalDate.parse("2021-11-24"), pr2, 1, 22.22, false, 0.00);
        when(mockPostRepository.getPost(2)).thenReturn(p2);


        ProductDTO pr3 = new ProductDTO(1, "product1", "1", "brand1", "color1", "notes1");
        PostWithoutDiscountDTO p1Dto = new PostWithoutDiscountDTO(1, 1, LocalDate.parse("2021-11-25"), pr3, 1, 22.22);
        when(mockPostMapper.postDTOToPostWithoutDiscount(p1)).thenReturn(p1Dto);

        ProductDTO pr4 = new ProductDTO(2, "product1", "1", "brand1", "color1", "notes1");
        PostWithoutDiscountDTO p2Dto = new PostWithoutDiscountDTO(2, 2, LocalDate.parse("2021-11-24"), pr4, 1, 22.22);
        when(mockPostMapper.postDTOToPostWithoutDiscount(p2)).thenReturn(p2Dto);

        /*AC*/
        FollowedSellerPostDTO fspd = userAndPostService.followedSellersPost(2, "date_asc");

        /*AS*/
        Assertions.assertEquals(2, fspd.getPosts().get(0).getId_post());
        Assertions.assertEquals(1, fspd.getPosts().get(1).getId_post());
    }

    @Test
    public void testOrderDatePostFollowedWithDateDesc() {
        when(mockUserRepository.userExists(2)).thenReturn(true);


        User u1 = new User(1, "User1");
        u1.addFollower(2);
        u1.addPublication(1);
        when(mockUserRepository.getUser(1)).thenReturn(u1);
        User u2 = new User(2, "User2");
        u2.addFollowed(1);
        u2.addFollowed(3);
        when(mockUserRepository.getUser(2)).thenReturn(u2);
        User u3 = new User(3, "User3");
        u3.addFollower(2);
        u3.addPublication(2);
        when(mockUserRepository.getUser(3)).thenReturn(u3);

        Product pr1 = new Product(1, "product1", "1", "brand1", "color1", "notes1");
        Post p1 = new Post(1, 1, LocalDate.parse("2021-11-25"), pr1, 1, 22.22, false, 0.00);
        when(mockPostRepository.getPost(1)).thenReturn(p1);

        Product pr2 = new Product(2, "product2", "1", "brand1", "color1", "notes1");
        Post p2 = new Post(3, 2, LocalDate.parse("2021-11-24"), pr2, 1, 22.22, false, 0.00);
        when(mockPostRepository.getPost(2)).thenReturn(p2);


        ProductDTO pr3 = new ProductDTO(1, "product1", "1", "brand1", "color1", "notes1");
        PostWithoutDiscountDTO p1Dto = new PostWithoutDiscountDTO(1, 1, LocalDate.parse("2021-11-25"), pr3, 1, 22.22);
        when(mockPostMapper.postDTOToPostWithoutDiscount(p1)).thenReturn(p1Dto);

        ProductDTO pr4 = new ProductDTO(2, "product1", "1", "brand1", "color1", "notes1");
        PostWithoutDiscountDTO p2Dto = new PostWithoutDiscountDTO(2, 2, LocalDate.parse("2021-11-24"), pr4, 1, 22.22);
        when(mockPostMapper.postDTOToPostWithoutDiscount(p2)).thenReturn(p2Dto);

        /*AC*/
        FollowedSellerPostDTO fspd = userAndPostService.followedSellersPost(2, "date_desc");

        /*AS*/
        Assertions.assertEquals(1, fspd.getPosts().get(0).getId_post());
        Assertions.assertEquals(2, fspd.getPosts().get(1).getId_post());
    }


    //T-0008 Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado
    // vendedor sean efectivamente de las últimas dos semanas. (US-0006)
    //public FollowedSellerPostDTO followedSellersPost(int user_id,String order){
    @Test
    public void testPost2weaksAgo() {
        when(mockUserRepository.userExists(2)).thenReturn(true);


        User u1 = new User(1, "User1");
        u1.addFollower(2);
        u1.addPublication(1);
        when(mockUserRepository.getUser(1)).thenReturn(u1);
        User u2 = new User(2, "User2");
        u2.addFollowed(1);
        u2.addFollowed(3);
        when(mockUserRepository.getUser(2)).thenReturn(u2);
        User u3 = new User(3, "User3");
        u3.addFollower(2);
        u3.addPublication(2);
        when(mockUserRepository.getUser(3)).thenReturn(u3);

        Product pr1 = new Product(1, "product1", "1", "brand1", "color1", "notes1");
        Post p1 = new Post(1, 1, LocalDate.parse("2021-11-25"), pr1, 1, 22.22, false, 0.00);
        when(mockPostRepository.getPost(1)).thenReturn(p1);

        Product pr2 = new Product(2, "product2", "1", "brand1", "color1", "notes1");
        Post p2 = new Post(3, 2, LocalDate.parse("2020-01-01"), pr2, 1, 22.22, false, 0.00);
        when(mockPostRepository.getPost(2)).thenReturn(p2);


        ProductDTO pr3 = new ProductDTO(1, "product1", "1", "brand1", "color1", "notes1");
        PostWithoutDiscountDTO p1Dto = new PostWithoutDiscountDTO(1, 1, LocalDate.parse("2021-11-25"), pr3, 1, 22.22);
        when(mockPostMapper.postDTOToPostWithoutDiscount(p1)).thenReturn(p1Dto);

        ProductDTO pr4 = new ProductDTO(2, "product1", "1", "brand1", "color1", "notes1");
        PostWithoutDiscountDTO p2Dto = new PostWithoutDiscountDTO(2, 2, LocalDate.parse("2020-01-01"), pr4, 1, 22.22);

        /*AC*/
        FollowedSellerPostDTO fspd = userAndPostService.followedSellersPost(2, "date_asc");

        /*AS*/
        Assertions.assertEquals(1, fspd.getPosts().size());
    }

}

