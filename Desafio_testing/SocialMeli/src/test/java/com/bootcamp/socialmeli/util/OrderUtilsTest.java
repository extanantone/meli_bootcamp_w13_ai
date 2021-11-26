package com.bootcamp.socialmeli.util;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.exception.IllegalRequestParamException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderUtilsTest {

    @InjectMocks
    private OrderUtils orderUtils;

    @Test
    void orderingParamIllegalValueTest1(){
        orderingParamIllegalValueTest(new FollowerListResponseDTO(1L, "Juan", new ArrayList<>()), "");
    }

    @Test
    void orderingParamIllegalValueTest2(){
        orderingParamIllegalValueTest(new FollowerListResponseDTO(1L, "Juan", new ArrayList<>()), "name_");
    }

    void orderingParamIllegalValueTest(FollowerListResponseDTO list, String order){
        FollowerListResponseDTO followersList = new FollowerListResponseDTO(1L, "Juan", new ArrayList<>());
        Exception exception = Assertions.assertThrows(IllegalRequestParamException.class, () -> orderUtils.order(list, order));
        String expectedMessage = "Valor ilegal para el request param order";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void orderingParamFollowerTest1(){
        UserDTO user1 = new UserDTO(2L, "Laura");
        UserDTO user2 = new UserDTO(3L, "Camila");
        UserDTO user3 = new UserDTO(4L, "Daniel");
        UserDTO user4 = new UserDTO(5L, "Lautaro");
        FollowerListResponseDTO dto = new FollowerListResponseDTO(1L, "Juan", new ArrayList<>(List.of(user1,user2,user3,user4)));
        orderingParamFollowerTest(dto, "name_asc", "asc");
    }

    @Test
    void orderingParamFollowerTest2(){
        UserDTO user1 = new UserDTO(2L, "Laura");
        UserDTO user2 = new UserDTO(3L, "Camila");
        UserDTO user3 = new UserDTO(4L, "Daniel");
        UserDTO user4 = new UserDTO(5L, "Lautaro");
        FollowerListResponseDTO dto = new FollowerListResponseDTO(1L, "Juan", new ArrayList<>(List.of(user1,user2,user3,user4)));
        orderingParamFollowerTest(dto, "name_desc", "desc");
    }

    void orderingParamFollowerTest(FollowerListResponseDTO list, String order, String realOrder){
        FollowerListResponseDTO actual = orderUtils.order(list, order);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
        if(realOrder.equals("desc")){
            comparator = comparator.reversed();
        }
        Collections.sort(list.getFollowers(), comparator);
        Assertions.assertEquals(list, actual);
    }

    @Test
    void orderingParamFollowedTest1(){
        UserDTO user1 = new UserDTO(2L, "Laura");
        UserDTO user2 = new UserDTO(3L, "Camila");
        UserDTO user3 = new UserDTO(4L, "Daniel");
        UserDTO user4 = new UserDTO(5L, "Lautaro");
        FollowedListResponseDTO dto = new FollowedListResponseDTO(1L, "Juan", new ArrayList<>(List.of(user1,user2,user3,user4)));
        orderingParamFollowedTest(dto, "name_asc", "asc");
    }

    @Test
    void orderingParamFollowedTest2(){
        UserDTO user1 = new UserDTO(2L, "Laura");
        UserDTO user2 = new UserDTO(3L, "Camila");
        UserDTO user3 = new UserDTO(4L, "Daniel");
        UserDTO user4 = new UserDTO(5L, "Lautaro");
        FollowedListResponseDTO dto = new FollowedListResponseDTO(1L, "Juan", new ArrayList<>(List.of(user1,user2,user3,user4)));
        orderingParamFollowedTest(dto, "name_desc", "desc");
    }

    void orderingParamFollowedTest(FollowedListResponseDTO list, String order, String realOrder){
        FollowedListResponseDTO actual = orderUtils.order(list, order);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
        if(realOrder.equals("desc")){
            comparator = comparator.reversed();
        }
        Collections.sort(list.getFollowed(), comparator);
        Assertions.assertEquals(list, actual);
    }

    @Test
    void orderingParamOrdenableTest1(){
        ListedPostDTO post1 = new ListedPostDTO(1L, LocalDate.of(2021,5,30),null,null,null,null,null);
        ListedPostDTO post2 = new ListedPostDTO(2L, LocalDate.of(2021,6,30),null,null,null,null,null);
        ListedPostDTO post3 = new ListedPostDTO(3L, LocalDate.of(2021,2,28),null,null,null,null,null);
        ListedPostDTO post4 = new ListedPostDTO(4L, LocalDate.of(2021,8,30),null,null,null,null,null);
        Ordenable dto = new ListedFollowedPostsDTO(1L, new ArrayList<>(List.of(post1,post2,post3,post4)));
        orderingParamOrdenableTest(dto, "date_asc", "asc");
    }

    @Test
    void orderingParamOrdenableTest2(){
        ListedPostDTO post1 = new ListedPostDTO(1L, LocalDate.of(2021,5,30),null,null,null,null,null);
        ListedPostDTO post2 = new ListedPostDTO(2L, LocalDate.of(2021,6,30),null,null,null,null,null);
        ListedPostDTO post3 = new ListedPostDTO(3L, LocalDate.of(2021,2,28),null,null,null,null,null);
        ListedPostDTO post4 = new ListedPostDTO(4L, LocalDate.of(2021,8,30),null,null,null,null,null);
        Ordenable dto = new ListedFollowedPostsDTO(1L, new ArrayList<>(List.of(post1,post2,post3,post4)));
        orderingParamOrdenableTest(dto, "date_desc", "desc");
    }

    void orderingParamOrdenableTest(Ordenable list, String order, String realOrder){
        Ordenable actual = orderUtils.order(list, order);
        Comparator<ListedPostDTO> comparator = Comparator.comparing(ListedPostDTO::getDate);
        if(realOrder.equals("desc")){
            comparator = comparator.reversed();
        }
        Collections.sort(list.getPosts(), comparator);
        Assertions.assertEquals(list, actual);
    }

}
