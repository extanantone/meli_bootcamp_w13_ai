package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.exceptions.GlobalExceptionHandler;
import com.SocialMeli.SocialMeli.exceptions.NotFoundException;
import com.SocialMeli.SocialMeli.model.Buyer;
import com.SocialMeli.SocialMeli.model.Post;
import com.SocialMeli.SocialMeli.model.Seller;
import com.SocialMeli.SocialMeli.repository.ISocialMeliRepository;
import lombok.SneakyThrows;
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
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SocialMeliController {

    @InjectMocks
    SocialMeliService service;

    @Mock
    ISocialMeliRepository repository;

    @Test
    void T_0001_Follow_Ok() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        Buyer buy = new Buyer("Tom", 1);
        ResponseUserDTO ext = new ResponseUserDTO("The buyer " + buy.getUser_id() + " has successfully followed the seller " + sell.getUser_id(), 200);
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);
        when(repository.searchFollower(sell.getFollowers(), buy.getUser_id())).thenReturn(null);
        when(repository.follow(buy, sell)).thenReturn(true);

        // act
        ResponseUserDTO ac = service.follow(buy.getUser_id(), sell.getUser_id());

        // assert
        verify(repository, atLeastOnce()).searchSeller(sell.getUser_id());
        assertAll("msg", () -> assertEquals(ext.getStatusCode(), ac.getStatusCode()),
                () -> assertEquals(ext.getMsg(), ac.getMsg()));
    }

    @Test
    void T_0001_Follow_NoOk() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        Buyer buy = new Buyer("Tom", 1);
        when(repository.searchSeller(sell.getUser_id())).thenReturn(null);
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);

        // assert
        assertThrows(NotFoundException.class, () -> service.follow(buy.getUser_id(), sell.getUser_id()));
        verify(repository, atLeastOnce()).searchSeller(sell.getUser_id());
    }

    @SneakyThrows
    @Test
    void T_0002_UnfollowOk() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        Buyer buy = new Buyer("Tom", 1);
        ResponseUserDTO expected = new ResponseUserDTO("The buyer " + buy.getUser_id() + " has successfully unfollowed the seller " + sell.getUser_id(), 200);
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);
        when(repository.searchFollower(sell.getFollowers(), buy.getUser_id())).thenReturn(java.util.Optional.of(buy));
        when(repository.unfollow(buy, sell)).thenReturn(true);

        // act
        ResponseUserDTO actual = service.unfollow(buy.getUser_id(), sell.getUser_id());

        // assert
        verify(repository, atLeastOnce()).searchSeller(sell.getUser_id());
        assertAll("rta", () -> assertEquals(expected.getStatusCode(), actual.getStatusCode()),
                () -> assertEquals(expected.getMsg(), actual.getMsg()));
    }

    @Test
    void T_0002_UnfollowNoOk() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        Buyer buy = new Buyer("Tom", 1);
        when(repository.searchSeller(sell.getUser_id())).thenReturn(null);
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);

        // assert
        assertThrows(NotFoundException.class, () -> service.unfollow(buy.getUser_id(), sell.getUser_id()));
        verify(repository, atLeastOnce()).searchSeller(sell.getUser_id());
    }

    @Test
    void T_0003_OrderOk() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        BuyersFollowedDTO buy = new BuyersFollowedDTO(10, "Tom");
        List<BuyersFollowedDTO> buyers = new ArrayList<>();
        buyers.add(buy);
        sell.getFollowers().add(new Buyer(buy.getUser_name(), buy.getUser_id()));
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);

        // act
        FollowersDTO act = service.searchFollower(sell.getUser_id(), "name_asc");
        List<BuyersFollowedDTO> buyersa = act.getFollowers();

        // assert
        verify(repository, atLeastOnce()).searchSeller(sell.getUser_id());
        assertEquals(1, buyersa.size());


    }

    @Test
    void T_0003_OrderNoOk() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        BuyersFollowedDTO buy = new BuyersFollowedDTO(1, "Tom");
        List<BuyersFollowedDTO> buyers = new ArrayList<>();
        buyers.add(buy);
        sell.getFollowers().add(new Buyer(buy.getUser_name(), buy.getUser_id()));
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);


        // assert
        assertThrows(NullPointerException.class, () -> service.searchFollowed(sell.getUser_id(), null));

    }

    @Test
    void T_0004_ascFollowers() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        BuyersFollowedDTO buy = new BuyersFollowedDTO(1, "Tom");
        List<BuyersFollowedDTO> buyers = new ArrayList<>();
        buyers.add(buy);
        sell.getFollowers().add(new Buyer(buy.getUser_name(), buy.getUser_id()));
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);

        // act
        FollowersDTO act = service.searchFollower(sell.getUser_id(), "name_asc");
        List<BuyersFollowedDTO> buyersa = act.getFollowers();


        // assert
        verify(repository, atLeastOnce()).searchSeller(sell.getUser_id());
        assertAll("followers", () -> assertEquals(buyersa.get(0).getUser_id(), act.getUser_id()));
    }

    @Test
    void T_0004_ascFollowed() throws NotFoundException {
        // arrange
        Buyer buy = new Buyer("Raul", 1);
        BuyersFollowedDTO buye = new BuyersFollowedDTO(1, "Tom");
        List<BuyersFollowedDTO> buyers = new ArrayList<>();
        buyers.add(buye);
        buy.getFollowed().add(new Seller(buye.getUser_name(), buye.getUser_id()));
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);

        // act
        FollowedDTO act = service.searchFollowed(buy.getUser_id(), "name_asc");
        List<SellersFollowedDTO> buyersa = act.getFollowed();


        // assert
        verify(repository, atLeastOnce()).searchSeller(buy.getUser_id());
        assertAll("followeds", () -> assertEquals(buyers.get(0).getUser_id(), buyersa.get(0).getUser_id()));
    }

    @Test
    void T_0004_DescFollowers() throws NotFoundException {
        // arrange
        Seller sell = new Seller("Raul", 1);
        BuyersFollowedDTO buy = new BuyersFollowedDTO(1, "Tom");
        List<BuyersFollowedDTO> buyers = new ArrayList<>();
        buyers.add(buy);
        sell.getFollowers().add(new Buyer(buy.getUser_name(), buy.getUser_id()));
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);

        // act
        FollowersDTO act = service.searchFollower(sell.getUser_id(), "name_desc");
        List<BuyersFollowedDTO> buyersa = act.getFollowers();


        // assert
        verify(repository, atLeastOnce()).searchSeller(sell.getUser_id());
        assertAll("followers", () -> assertEquals(buyersa.get(0).getUser_id(), act.getUser_id()));
    }

    @Test
    void T_0004_DescFollowed() throws NotFoundException {
        // arrange
        Buyer buy = new Buyer("Raul", 1);
        BuyersFollowedDTO buye = new BuyersFollowedDTO(1, "Tom");
        List<BuyersFollowedDTO> buyers = new ArrayList<>();
        buyers.add(buye);
        buy.getFollowed().add(new Seller(buye.getUser_name(), buye.getUser_id()));
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);

        // act
        FollowedDTO act = service.searchFollowed(buy.getUser_id(), "name_desc");
        List<SellersFollowedDTO> buyersa = act.getFollowed();


        // assert
        verify(repository, atLeastOnce()).searchSeller(buy.getUser_id());
        assertAll("followeds", () -> assertEquals(buyers.get(0).getUser_id(), buyersa.get(0).getUser_id()));
    }

    @Test
    void T_0005_dateOrderOk() throws NotFoundException {
        // arrange
        Utils util = new Utils();
        Buyer buy = util.OkOrden();
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);
        // act
        List<PostDTO> actual = service.searchPost(buy.getUser_id(), "date_desc");
        // assert
        verify(repository, atLeastOnce()).searchBuyer(buy.getUser_id());
        assertEquals(1,actual.size());
    }

    @Test
    void T_0005_dateOrderNoOk() throws NotFoundException {
        // arrange
        Utils util = new Utils();
        Buyer buy = util.OkOrden();
        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);
        // assert
        assertThrows(NullPointerException.class, ()->service.searchPost(buy.getUser_id(),null));
    }

    @Test
    void T_0006_dateAsc() throws NotFoundException {
        // arrange
        Utils utils = new Utils();
        String date = utils.returDate();
        Buyer buy = utils.OkOrder();
        Seller sell = new Seller("Raul",23);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date1 = LocalDate.parse(date, formatter);


        ProductDTO prod = new ProductDTO(1,"mesa","pino", "pa","blanca","coto");
        PostDTO post = new PostDTO(1,2,date1, prod,100,1000);

        when(repository.searchBuyer(buy.getUser_id())).thenReturn(buy);
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);
        when(repository.searchPost(sell.getPosts(),post.getId_post())).thenReturn(null);

        // act
        service.createPost(post);
        List<PostDTO> actual = service.searchPost(buy.getUser_id(), "date_asc");

        // assert
        verify(repository, atLeastOnce()).searchBuyer(buy.getUser_id());
        assertAll("posts", () -> assertEquals(date, actual.get(0).getId_post()));
    }
    @Test
    void T_0006_dateDesc() throws NotFoundException {
        // arrange
        Utils utils = new Utils();
        String date = utils.returDate();
        Buyer buy = utils.OkOrder();
        Seller sell = new Seller("Raul",23);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date1 = LocalDate.parse(date, formatter);

        // act
        List<PostDTO> actual = service.searchPost(buy.getUser_id(), "date_desc");

        // assert
        verify(repository, atLeastOnce()).searchBuyer(buy.getUser_id());
        assertAll("posts", () -> assertEquals(date, actual.get(0).getId_post()));
    }

    @Test
    void T_0007() throws NotFoundException {
        // arrange
        CountFollowDTO exp = new CountFollowDTO(1, "Tom", 1) ;
        Seller sell = new Seller("Tom", 1);
        Buyer buy = new Buyer("Raul", 1);
        when(repository.searchSeller(sell.getUser_id())).thenReturn(sell);
        sell.getFollowers().add(buy);
        // act
        CountFollowDTO act = service.count(sell.getUser_id());

        // assert
        assertAll("msg", () -> assertEquals(exp.getUser_id(), act.getUser_id()),
                () -> assertEquals(exp.getFollowers_count(), act.getFollowers_count()));
    }


    @Test
    void T_0008() throws NotFoundException {
        // arrange
        Utils utils = new Utils();
        String date = utils.returDate();
        Buyer buy = utils.OkOrder();
        Seller sell = new Seller("Raul", 23);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date1 = LocalDate.parse(date, formatter);


        ProductDTO prod = new ProductDTO(1, "mesa", "pino", "pa", "blanca", "coto");
        PostDTO post = new PostDTO(1, 2, date1, prod, 100, 1000);
        sell.getPosts().add(new PostDTO(1, 2, date1, prod, 100, 1000));
        buy.getFollowed().add(sell);

        // act
        List<PostDTO> act = service.searchPost(buy.getUser_id(), "date_asc");


        // assert
        assertAll("posts", () -> assertEquals(date, act.get(0).getId_post()));
    }

}
