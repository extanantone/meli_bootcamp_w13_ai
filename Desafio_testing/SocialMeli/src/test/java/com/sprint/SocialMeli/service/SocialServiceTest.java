package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.UserDto;
import com.sprint.SocialMeli.dto.out.*;
import com.sprint.SocialMeli.exceptions.InvalidOrderException;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;
import com.sprint.SocialMeli.model.Buyer;
import com.sprint.SocialMeli.model.Post;
import com.sprint.SocialMeli.model.Seller;
import com.sprint.SocialMeli.model.User;
import com.sprint.SocialMeli.repository.SocialRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Not;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SocialServiceTest {

    @Mock
    SocialRepository socialRepository;

    @InjectMocks
    SocialService socialService;

    //T-0001 CUMPLE
    @Test
    void followExistingSeller() throws Exception {
        // Creo un comprador y un vendedor. No se siguen
        Buyer buyer = new Buyer(1, "Pepe");
        Seller seller = new Seller(3, "Brenda");

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        socialService.followSeller(buyer.getUserId(), seller.getUserId());

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).putUser(buyer);
        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).putUser(seller);

        assertTrue(buyer.getFollowedIds().contains(seller.getUserId()));
        assertTrue(seller.getFollowersIds().contains(buyer.getUserId()));

    }

    //T-0001 NO CUMPLE
    @Test
    void followUnexistingSellerThrowNotFoundException() throws Exception {
        // Creo un comprador valido y solo el id del vendedor que no existe
        Buyer buyer = new Buyer(1, "Pepe");
        int unexistingSellerId = 3;

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.existsUser(unexistingSellerId)).thenReturn(false);

        Assertions.assertThrows(NotFoundException.class, () -> socialService.followSeller(buyer.getUserId(), unexistingSellerId));

        verify(socialRepository, atLeastOnce()).existsUser(unexistingSellerId);
    }

    //T-0002 CUMPLE
    @Test
    void unfollowExistingSeller() throws Exception {
        // Creo un comprador y un vendedor. Agrego cada uno a la lista de seguidor - seguido segun corresponda
        Buyer buyer = new Buyer(1, "Pepe");
        buyer.addFollowed(3);
        Seller seller = new Seller(3, "Brenda");
        seller.addFollower(1);

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        socialService.unfollowSeller(buyer.getUserId(), seller.getUserId());

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).putUser(buyer);
        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).putUser(seller);

        assertFalse(buyer.getFollowedIds().contains(seller.getUserId()));
        assertFalse(seller.getFollowersIds().contains(buyer.getUserId()));
    }

    //T-0002 NO CUMPLE
    @Test
    void unfollowUnexistingSellerThrowNotFoundException() throws Exception {
        // Creo un comprador valido y solo el id del vendedor que no existe
        Buyer buyer = new Buyer(1, "Pepe");
        int unexistingSellerId = 3;

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.existsUser(unexistingSellerId)).thenReturn(false);

        Assertions.assertThrows(NotFoundException.class, () -> socialService.unfollowSeller(buyer.getUserId(), unexistingSellerId));

        verify(socialRepository, atLeastOnce()).existsUser(unexistingSellerId);
    }


    //T-0003 CUMPLE NAME_ASC (se hace solo para los seguidores, ya que en la US de los seguidos se usa la misma funcion de ordenamiento)
    @Test
    void verifySellerFollowersListRunWithAscOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo vendedor con tal que lo valide y pueda ver si anda el ordenamiento
        Seller seller = new Seller(3, "Brenda");

        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        socialService.getSellerFollowersList(seller.getUserId(), "name_asc");

        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());

        //Si pasa bien sin romperse es porque tomo bien el tipo de orden
    }

    //T-0003 CUMPLE NAME_DESC (se hace solo para los seguidores, ya que en la US de los seguidos se usa la misma funcion de ordenamiento)
    @Test
    void verifySellerFollowersListRunWithDescOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo vendedor con tal que lo valide y pueda ver si anda el ordenamiento
        Seller seller = new Seller(3, "Brenda");

        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        socialService.getSellerFollowersList(seller.getUserId(), "name_desc");

        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        //Si pasa bien sin romperse es porque tomo bien el tipo de orden
    }

    //T-0003 CUMPLE NULO (se hace solo para los seguidores, ya que en la US de los seguidos se usa la misma funcion de ordenamiento)
    @Test
    void verifySellerFollowersListRunWithNullOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo vendedor con tal que lo valide y pueda ver si anda el ordenamiento
        Seller seller = new Seller(3, "Brenda");

        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        // Se toma como válido el nulo
        socialService.getSellerFollowersList(seller.getUserId(), null);

        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        //Si pasa bien sin romperse es porque tomo bien el tipo de orden
    }

    //T-0003 NO CUMPLE (se hace solo para los seguidores, ya que en la US de los seguidos se usa la misma funcion de ordenamiento)
    @Test
    void verifySellerFollowersListThrowNotValidOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo vendedor con tal que lo valide y pueda ver si anda el ordenamiento
        Seller seller = new Seller(3, "Brenda");

        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        // Se toma como válido el nulo, por lo que algo inválido sería un String diferente a los propuestos anteriormente
        Assertions.assertThrows(InvalidOrderException.class, () -> socialService.getSellerFollowersList(seller.getUserId(), "name"));

        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
    }

    //T-0004 CUMPLE NAME_ASC (se hace solo para los seguidores, ya que en la US de los seguidos se usa la misma funcion de ordenamiento)
    @Test
    void getSellerFollowersListCorrectWithAscOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo vendedores y varios compradores que lo sigan, con tal que se puedan ordenar
        Buyer buyer = new Buyer(1, "Pepe");
        Buyer buyer2 = new Buyer(2, "Mariano");
        Buyer buyer3 = new Buyer(0, "Nando");
        Seller seller = new Seller(3, "Brenda");
        seller.addFollower(1);
        seller.addFollower(2);
        seller.addFollower(0);

        // Creo la lista esperada con el ordenamiento que deseo obtener
        List<UserDto> expectedUserListDto = new LinkedList<>();
        expectedUserListDto.add(new UserDto(buyer2.getUserId(), buyer2.getUserName()));
        expectedUserListDto.add(new UserDto(buyer3.getUserId(), buyer3.getUserName()));
        expectedUserListDto.add(new UserDto(buyer.getUserId(), buyer.getUserName()));

        // Creo el dto esperado
        FollowersListDto expectedFollowersListDto = new FollowersListDto(seller.getUserId(), seller.getUserName(), expectedUserListDto);

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.getUser(buyer2.getUserId())).thenReturn(buyer2);
        Mockito.when(socialRepository.getUser(buyer3.getUserId())).thenReturn(buyer3);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        FollowersListDto followersListDto = socialService.getSellerFollowersList(seller.getUserId(), "name_asc");

        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer2.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer3.getUserId());

        Assertions.assertEquals(expectedFollowersListDto, followersListDto);
    }

    //T-0004 CUMPLE NAME_DESC (se hace solo para los seguidores, ya que en la US de los seguidos se usa la misma funcion de ordenamiento)
    @Test
    void getSellerFollowersListCorrectWithDescOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo vendedores y varios compradores que lo sigan, con tal que se puedan ordenar
        Buyer buyer = new Buyer(1, "Pepe");
        Buyer buyer2 = new Buyer(2, "Mariano");
        Buyer buyer3 = new Buyer(0, "Nando");
        Seller seller = new Seller(3, "Brenda");
        seller.addFollower(1);
        seller.addFollower(2);
        seller.addFollower(0);

        // Creo la lista esperada con el ordenamiento que deseo obtener
        List<UserDto> expectedUserListDto = new LinkedList<>();
        expectedUserListDto.add(new UserDto(buyer.getUserId(), buyer.getUserName()));
        expectedUserListDto.add(new UserDto(buyer3.getUserId(), buyer3.getUserName()));
        expectedUserListDto.add(new UserDto(buyer2.getUserId(), buyer2.getUserName()));

        // Creo el dto esperado
        FollowersListDto expectedFollowersListDto = new FollowersListDto(seller.getUserId(), seller.getUserName(), expectedUserListDto);

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.getUser(buyer2.getUserId())).thenReturn(buyer2);
        Mockito.when(socialRepository.getUser(buyer3.getUserId())).thenReturn(buyer3);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        FollowersListDto followersListDto = socialService.getSellerFollowersList(seller.getUserId(), "name_desc");

        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer2.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer3.getUserId());

        Assertions.assertEquals(expectedFollowersListDto, followersListDto);
    }

    //T-0005 CUMPLE DATE_ASC
    @Test
    void verifyLastTwoWeeksPostsFromFollowedRunWithAscOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo comprador sin seguidores con tal que lo valide bien solamente para que tome el ordenamiento
        Buyer buyer = new Buyer(1, "Pepe");

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);

        socialService.getLastTwoWeeksPostsFromFollowed(buyer.getUserId(), "date_asc");

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        //Si pasa bien sin romperse es porque tomo bien el tipo de orden
    }

    //T-0005 CUMPLE DATE_DESC
    @Test
    void verifyLastTwoWeeksPostsFromFollowedRunWithDescOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo comprador sin seguidores con tal que lo valide bien solamente para que tome el ordenamiento
        Buyer buyer = new Buyer(1, "Pepe");

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);

        socialService.getLastTwoWeeksPostsFromFollowed(buyer.getUserId(), "date_desc");

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        //Si pasa bien sin romperse es porque tomo bien el tipo de orden
    }

    //T-0005 NO CUMPLE
    @Test
    void verifyLastTwoWeeksPostsFromFollowedRunWithInvalidOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Creo un solo comprador sin seguidores con tal que lo valide bien solamente para que tome el ordenamiento
        Buyer buyer = new Buyer(1, "Pepe");

        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);

        Assertions.assertThrows(InvalidOrderException.class, () ->  socialService.getLastTwoWeeksPostsFromFollowed(buyer.getUserId(), "date"));

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
    }

    //T-0006 DATE_ASC
    @Test
    void verifyLastTwoWeeksPostsFromFollowedRunCorrectlyWithAscOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Para una mejor prueba creo dos vendedores, los cuales son seguidos por un comprador
        Buyer buyer = new Buyer(1, "Pepe");
        Seller seller = new Seller(3, "Brenda");
        Seller seller2 = new Seller(4, "Ramon");
        buyer.addFollowed(3);
        buyer.addFollowed(4);

        // Creo todos los post de prueba, están adentro de las últimas dos semanas todos
        Post post1 = new Post();
        post1.setIdPost(11);
        post1.setDate(LocalDate.now().minusDays(2).minusWeeks(1));
        Post post2 = new Post();
        post2.setIdPost(23);
        post2.setDate(LocalDate.now().minusDays(1));
        Post post3 = new Post();
        post3.setIdPost(634);
        post3.setDate(LocalDate.now().minusDays(5));

        // Agrego los ids de los posts a los vendedores que seguía el comprador
        seller.addPost(11);
        seller.addPost(23);
        seller2.addPost(634);

        // Creo la lista esperada de post en el orden que debería ser según sus fechas
        List<PostDtoOut> expectedPostDtoOutList = new LinkedList<>();
        expectedPostDtoOutList.add(new PostDtoOut(post1));
        expectedPostDtoOutList.add(new PostDtoOut(post3));
        expectedPostDtoOutList.add(new PostDtoOut(post2));

        FollowedPostListDto expectedFollowedPostListDto = new FollowedPostListDto(buyer.getUserId(), expectedPostDtoOutList);

        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.getUser(seller2.getUserId())).thenReturn(seller2);
        Mockito.when(socialRepository.getPost(post1.getIdPost())).thenReturn(post1);
        Mockito.when(socialRepository.getPost(post2.getIdPost())).thenReturn(post2);
        Mockito.when(socialRepository.getPost(post3.getIdPost())).thenReturn(post3);

        FollowedPostListDto followedPostListDto = socialService.getLastTwoWeeksPostsFromFollowed(buyer.getUserId(), "date_asc");

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller2.getUserId());
        verify(socialRepository, atLeastOnce()).getPost(post1.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post2.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post3.getIdPost());

        Assertions.assertEquals(expectedFollowedPostListDto, followedPostListDto);
    }

    //T-0006 DATE_DESC
    @Test
    void verifyLastTwoWeeksPostsFromFollowedRunCorrectlyWithDescOrder() throws WrongTypeException, NotFoundException, InvalidOrderException {
        // Para una mejor prueba creo dos vendedores, los cuales son seguidos por un comprador
        Buyer buyer = new Buyer(1, "Pepe");
        Seller seller = new Seller(3, "Brenda");
        Seller seller2 = new Seller(4, "Ramon");
        buyer.addFollowed(3);
        buyer.addFollowed(4);

        // Creo todos los post de prueba, están adentro de las últimas dos semanas todos
        Post post1 = new Post();
        post1.setIdPost(11);
        post1.setDate(LocalDate.now().minusDays(2).minusWeeks(1));
        Post post2 = new Post();
        post2.setIdPost(23);
        post2.setDate(LocalDate.now().minusDays(1));
        Post post3 = new Post();
        post3.setIdPost(634);
        post3.setDate(LocalDate.now().minusDays(5));

        // Agrego los ids de los posts a los vendedores que seguía el comprador
        seller.addPost(11);
        seller.addPost(23);
        seller2.addPost(634);

        // Creo la lista esperada de post en el orden que debería ser según sus fechas
        List<PostDtoOut> expectedPostDtoOutList = new LinkedList<>();
        expectedPostDtoOutList.add(new PostDtoOut(post2));
        expectedPostDtoOutList.add(new PostDtoOut(post3));
        expectedPostDtoOutList.add(new PostDtoOut(post1));

        FollowedPostListDto expectedFollowedPostListDto = new FollowedPostListDto(buyer.getUserId(), expectedPostDtoOutList);

        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.getUser(seller2.getUserId())).thenReturn(seller2);
        Mockito.when(socialRepository.getPost(post1.getIdPost())).thenReturn(post1);
        Mockito.when(socialRepository.getPost(post2.getIdPost())).thenReturn(post2);
        Mockito.when(socialRepository.getPost(post3.getIdPost())).thenReturn(post3);

        FollowedPostListDto followedPostListDto = socialService.getLastTwoWeeksPostsFromFollowed(buyer.getUserId(), "date_desc");

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller2.getUserId());
        verify(socialRepository, atLeastOnce()).getPost(post1.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post2.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post3.getIdPost());

        Assertions.assertEquals(expectedFollowedPostListDto, followedPostListDto);
    }

    //T-0007
    @Test
    void verifyCorrectFollowersNumber() throws WrongTypeException, NotFoundException {
        Seller seller = new Seller(3, "Brenda");

        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);

        // Tomo los iniciales para verificar que realmente sea 0
        Integer initialFollowers = socialService.getSellerFollowersCount(seller.getUserId()).getFollowersCount();

        // Le agrego seguidores
        seller.addFollower(1);
        seller.addFollower(2);
        seller.addFollower(0);

        // Tomo el numero final
        Integer finalFollowers = socialService.getSellerFollowersCount(seller.getUserId()).getFollowersCount();

        verify(socialRepository, atLeastOnce()).existsUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());

        // Compruebo tanto el numero inicial como final de seguidores
        Assertions.assertEquals(0, initialFollowers);
        Assertions.assertEquals(3, finalFollowers);
    }

    //T-0008
    @Test
    void verifyLastTwoWeeksPostsFromFollowedGetCorrectlyPostsDate() throws WrongTypeException, InvalidOrderException, NotFoundException {
        // Para una mejor prueba creo dos vendedores, los cuales son seguidos por un comprador
        Buyer buyer = new Buyer(1, "Pepe");
        Seller seller = new Seller(3, "Brenda");
        Seller seller2 = new Seller(4, "Ramon");
        buyer.addFollowed(3);
        buyer.addFollowed(4);

        // Creo los posts
        Post post1 = new Post();
        post1.setIdPost(11);
        post1.setDate(LocalDate.now().minusDays(2).minusWeeks(1));
        Post post2 = new Post();
        post2.setIdPost(23);
        post2.setDate(LocalDate.now().minusDays(1));
        Post post3 = new Post();
        post3.setIdPost(634);
        post3.setDate(LocalDate.now().minusDays(5));
        // Agrego este adicional a diferencia de los otros test, el cual está justo antes de las dos semanas por lo que no debería contarlo
        Post post4 = new Post();
        post4.setIdPost(151);
        post4.setDate(LocalDate.now().minusWeeks(2).minusDays(1));

        // Agrego los ids de los posts a los vendedores
        seller.addPost(11);
        seller.addPost(23);
        seller2.addPost(634);
        seller2.addPost(151);

        // Devuelvo la lista con el orden deseado sin el post que tiene más de dos semanas de antigüedad
        List<PostDtoOut> expectedPostDtoOutList = new LinkedList<>();
        expectedPostDtoOutList.add(new PostDtoOut(post2));
        expectedPostDtoOutList.add(new PostDtoOut(post3));
        expectedPostDtoOutList.add(new PostDtoOut(post1));

        FollowedPostListDto expectedFollowedPostListDto = new FollowedPostListDto(buyer.getUserId(), expectedPostDtoOutList);

        Mockito.when(socialRepository.existsUser(buyer.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.getUser(buyer.getUserId())).thenReturn(buyer);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.getUser(seller2.getUserId())).thenReturn(seller2);
        Mockito.when(socialRepository.getPost(post1.getIdPost())).thenReturn(post1);
        Mockito.when(socialRepository.getPost(post2.getIdPost())).thenReturn(post2);
        Mockito.when(socialRepository.getPost(post3.getIdPost())).thenReturn(post3);
        Mockito.when(socialRepository.getPost(post4.getIdPost())).thenReturn(post4);

        FollowedPostListDto followedPostListDto = socialService.getLastTwoWeeksPostsFromFollowed(buyer.getUserId(), "date_desc");

        verify(socialRepository, atLeastOnce()).existsUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(buyer.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getUser(seller2.getUserId());
        verify(socialRepository, atLeastOnce()).getPost(post1.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post2.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post3.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post4.getIdPost());

        Assertions.assertEquals(expectedFollowedPostListDto, followedPostListDto);
    }

    // ADICIONAL PARA MAS COVERAGE
    @Test
    void verifyTwoPromoPostList() throws WrongTypeException, NotFoundException {
        // Para una mejor prueba creo dos vendedores, los cuales son seguidos por un comprador
        Seller seller = new Seller(3, "Brenda");

        // Creo los posts
        Post post1 = new Post();
        post1.setIdPost(11);
        post1.setDate(LocalDate.now().minusDays(2).minusWeeks(1));
        post1.setHasPromo(true);
        post1.setDiscount(0.10);
        Post post2 = new Post();
        post2.setIdPost(23);
        post2.setDate(LocalDate.now().minusDays(1));
        post2.setHasPromo(true);
        post2.setDiscount(0.25);

        // Agrego los ids de los posts a los vendedores
        seller.addPost(11);
        seller.addPost(23);
        Mockito.when(socialRepository.existsUser(seller.getUserId())).thenReturn(true);
        Mockito.when(socialRepository.getUser(seller.getUserId())).thenReturn(seller);
        Mockito.when(socialRepository.getPost(post1.getIdPost())).thenReturn(post1);
        Mockito.when(socialRepository.getPost(post2.getIdPost())).thenReturn(post2);

        PromoPostList promoPostList = socialService.getPromoPostList(seller.getUserId());

        verify(socialRepository, atLeastOnce()).getUser(seller.getUserId());
        verify(socialRepository, atLeastOnce()).getPost(post1.getIdPost());
        verify(socialRepository, atLeastOnce()).getPost(post2.getIdPost());

        Assertions.assertTrue(promoPostList.getPosts().contains(new PromoPostDtoOut(post1)));
        Assertions.assertTrue(promoPostList.getPosts().contains(new PromoPostDtoOut(post2)));
    }
}