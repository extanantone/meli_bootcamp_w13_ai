package com.meli.SocialMeli.unit.service;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.exception.BadRequestException;
import com.meli.SocialMeli.helper.Helper;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.Promo;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.reposity.IRepository;
import com.meli.SocialMeli.service.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {
    @Mock
    IRepository mockRepository;

    @InjectMocks
    SocialMeliService service;

    @DisplayName("T-0001: Verificar que el usuario a seguir exista (Comportamiento: Permite continuar con normalidad)")
    @Test
    public void verifyUserExistence(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;

        User userIdExpected = new User(1, "Gabriela");
        User userIdToFollowExpected = new User(3, "Magali");
        //Mock
        Mockito.when(mockRepository.findUser(userId)).thenReturn(userIdExpected);
        Mockito.when(mockRepository.findUser(userIdToFollow)).thenReturn(userIdToFollowExpected);

        //Act & Assert
        Assertions.assertDoesNotThrow(()->service.addFollow(userId, userIdToFollow));
    }


    @DisplayName("T-0001: Verificar que el usuario a seguir exista (Comportamiento: Notifica la no existencia mediante una excepción)")
    @Test
    public void verifyUserNotExistence(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 8;

        User userIdExpected = new User(1, "Gabriela");
        User userIdToFollowExpected = null;
        BadRequestException userIdToFollowBadCurrent = new BadRequestException("Usuario "+userIdToFollow+" no encontrado");

        //Mock
        Mockito.when(mockRepository.findUser(userId)).thenReturn(userIdExpected);
        Mockito.when(mockRepository.findUser(userIdToFollow)).thenReturn(userIdToFollowExpected);

        //Act & Assert
        BadRequestException userIdToFollowBadExpected = Assertions.assertThrows(BadRequestException.class, ()->service.addFollow(userId, userIdToFollow));
        Assertions.assertEquals(userIdToFollowBadExpected.getMensaje(), userIdToFollowBadCurrent.getMensaje());
    }

    @DisplayName("T-0002: Verificar que el usuario a dejar de seguir exista (Comportamiento: Permite continuar con normalidad).")
    @Test
    public void verifyUserExistenceToUnfollow(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;

        User userIdExpected = new User(1, "Gabriela");
        User userIdToFollowExpected = new User(3, "Magali");

        List<User> followers = userIdExpected.getFollowers();
        followers.add(userIdToFollowExpected);
        userIdExpected.setFollowers(followers);

        List<User> followed = userIdToFollowExpected.getFollowed();
        followed.add(userIdExpected);
        userIdToFollowExpected.setFollowed(followed);
        MensajeDTO msjCurrent = new MensajeDTO("Usuario "+userId+" dejó de seguir al usuario "+userIdToFollow, 1);

        //Mock
        Mockito.when(mockRepository.findUser(userId)).thenReturn(userIdExpected);
        Mockito.when(mockRepository.findUser(userIdToFollow)).thenReturn(userIdToFollowExpected);
        Mockito.when(mockRepository.containFollower(userIdToFollow,userId)).thenReturn(true);
        Mockito.doNothing().when(mockRepository).unfollow(userId, userIdToFollow);

        //Act & Assert
        Assertions.assertDoesNotThrow(()->service.unfollow(userId, userIdToFollow));
    }

    @DisplayName("T-0002: Verificar que el usuario a dejar de seguir exista (Comportamiento: Notificar la existencia mediante una excepción)")
    @Test
    public void verifyUserNotExistenceToUnfollow(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;

        User userIdExpected = new User(1, "Gabriela");
        User userIdToFollowExpected = new User(3, "Magali");
        BadRequestException userIdToFollowBadCurrent = new BadRequestException("Usuario "+userId+" no se encuentra siguiendo al usuario "+userIdToFollow);
        //Mock
        Mockito.when(mockRepository.findUser(userId)).thenReturn(userIdExpected);
        Mockito.when(mockRepository.findUser(userIdToFollow)).thenReturn(userIdToFollowExpected);

        //Act & Assert
        BadRequestException userIdToFollowBadExpected = Assertions.assertThrows(BadRequestException.class, ()->service.unfollow(userId, userIdToFollow));
        Assertions.assertEquals(userIdToFollowBadExpected.getMensaje(), userIdToFollowBadCurrent.getMensaje());
    }

    @DisplayName("T-0003 Verificar que el tipo de ordenamiento alfabético exista (Comportamiento: Permite continuar con normalidad)")
    @Test
    public void verifyThatExistTypeOfOrder(){
        //Arrange
        String orderAsc = "name_asc";
        String orderDesc = "name_desc";
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());
        User userId3 = new User(3, "Magali", new LinkedList<User>(), new LinkedList<User>());
        //Seguidos por User1
        LinkedList<User> listCurrentOrdered = new LinkedList<>();
        listCurrentOrdered.add(userId2);
        listCurrentOrdered.add(userId3);
        userId1.setFollowed(listCurrentOrdered);
        //Siguen a User1
        LinkedList<User> listCurrentOrdered2 = new LinkedList<>();
        listCurrentOrdered2.add(userId2);
        listCurrentOrdered2.add(userId3);
        userId1.setFollowers(listCurrentOrdered2);

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);


        // Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertNotNull(orderAsc),
                ()->Assertions.assertNotNull(orderDesc),
                ()->Assertions.assertDoesNotThrow(()->service.listFollowers(userId1.getUserId(), orderAsc)),
                ()->Assertions.assertDoesNotThrow(()->service.listFollowed(userId1.getUserId(), orderAsc)),
                ()->Assertions.assertDoesNotThrow(()->service.listFollowers(userId1.getUserId(), orderDesc)),
                ()->Assertions.assertDoesNotThrow(()->service.listFollowed(userId1.getUserId(), orderDesc))
        );
    }

    @DisplayName("T-0003 Verificar que el tipo de ordenamiento alfabético exista (Comportamiento: Notificar la no existencia Mediante una Excepción)")
    @Test
    public void verifyThatNotExistTypeOfOrder(){
        //Arrange
        String orderAsc = null;
        String orderDesc = null;
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);


        // Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertThrows(BadRequestException.class, ()->service.listFollowers(userId1.getUserId(), orderAsc)),
                ()->Assertions.assertThrows(BadRequestException.class, ()->service.listFollowers(userId1.getUserId(), orderDesc))
        );
    }

    @DisplayName("T-0004 (ASC): Verificar el correcto ordenamiento ascendente por nombre (Comportamiento: devuelve la lista ordenada segun el criterio solicitado)")
    @Test
    public void verifyCorrectOrderListAsc(){
        //Arrange
        String order = "name_asc";
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());
        User userId3 = new User(3, "Magali", new LinkedList<User>(), new LinkedList<User>());
        //Seguidos por User1
        LinkedList<User> listCurrentOrdered = new LinkedList<>();
        listCurrentOrdered.add(userId2);
        listCurrentOrdered.add(userId3);
        userId1.setFollowed(listCurrentOrdered);
        //Siguen a User1
        LinkedList<User> listCurrentOrdered2 = new LinkedList<>();
        listCurrentOrdered2.add(userId2);
        listCurrentOrdered2.add(userId3);
        userId1.setFollowers(listCurrentOrdered2);

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);

        //Act
        FollowersDTO followerOrder = service.listFollowers(userId1.getUserId(), order);
        FollowedDTO followedOrder = service.listFollowed(userId1.getUserId(), order);

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(Helper.listFollowersToFollowers(userId1).getFollowers(), followerOrder.getFollowers()),
                ()->Assertions.assertEquals(Helper.listFollowedToFollowed(userId1).getFollowed(), followedOrder.getFollowed())
        );
    }

    @DisplayName("T-0004 (DESC): Verificar el correcto ordenamiento descendiente por nombre (Comportamiento: devuelve la lista ordenada segun el criterio solicitado)")
    @Test
    public void verifyCorrectOrderListDesc(){
        //Arrange
        String order = "name_desc";
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());
        User userId3 = new User(3, "Magali", new LinkedList<User>(), new LinkedList<User>());
        LinkedList<User> listCurrentOrdered = new LinkedList<>();
        listCurrentOrdered.add(userId3);
        listCurrentOrdered.add(userId2);
        userId1.setFollowed(listCurrentOrdered);

        LinkedList<User> listCurrentOrdered2 = new LinkedList<>();
        listCurrentOrdered2.add(userId3);
        listCurrentOrdered2.add(userId2);
        userId1.setFollowers(listCurrentOrdered2);

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);

        //Act
        FollowersDTO followerOrder = service.listFollowers(userId1.getUserId(), order);
        FollowedDTO followedOrder = service.listFollowed(userId1.getUserId(), order);

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(Helper.listFollowersToFollowers(userId1).getFollowers(), followerOrder.getFollowers()),
                ()->Assertions.assertEquals(Helper.listFollowedToFollowed(userId1).getFollowed(), followedOrder.getFollowed())
        );

    }

    @DisplayName("T-0005 Verificar que el tipo de ordenamiento por fecha exista (Comportamiento: Permite continuar con normalidad)")
    @Test
    public void verifyThatExistTypeOfOrderDate(){
        //Arrange
        String orderAsc = "date_asc";
        String orderDesc = "date_desc";
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);


        // Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertNotNull(orderAsc),
                ()->Assertions.assertNotNull(orderDesc),
                ()->Assertions.assertDoesNotThrow(()->service.listPostFollowed(userId1.getUserId(), orderAsc)),
                ()->Assertions.assertDoesNotThrow(()->service.listPostFollowed(userId1.getUserId(), orderDesc))
        );
    }

    @DisplayName("T-0005 Verificar que el tipo de ordenamiento alfabético exista " +
            "(Comportamiento: Notifica la no existencia mediante una excepción)")
    @Test
    public void verifyThatNotExistTypeOfOrderDate(){
        //Arrange
        String orderAsc = null;
        String orderDesc = null;
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);

        // Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertThrows(BadRequestException.class, ()->service.listPostFollowed(userId1.getUserId(), orderAsc)),
                ()->Assertions.assertThrows(BadRequestException.class, ()->service.listPostFollowed(userId1.getUserId(), orderDesc))
        );
    }

    @DisplayName("T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha " +
            "(Comportamiento: devuelve la lista ordenada segun el criterio solicitado)")
    @Test
    public void verifyCorrectOrderListPost(){
        //Arrange
        String orderAsc = "date_asc";
        String orderDesc = "date_desc";
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());
        //Seguidos por User1
        LinkedList<User> listCurrentOrdered = new LinkedList<>();
        listCurrentOrdered.add(userId2);
        userId1.setFollowed(listCurrentOrdered);
        //Siguen a User1
        LinkedList<User> listCurrentOrdered2 = new LinkedList<>();
        listCurrentOrdered2.add(userId2);
        userId1.setFollowers(listCurrentOrdered2);
        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post1 = new Post(2,1, LocalDate.of(2021, 11, 26),3,1540.0, prod1);

        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Post post2 = new Post(2,2, LocalDate.of(2021, 11, 28),2,2450.67, prod2);

        Product prod3 = new Product(3, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Post post3 = new Post(2,3, LocalDate.of(2021, 10, 29),100,2345.0, prod3);
        List<Post> postsAsc = new LinkedList<>();
        postsAsc.add(post1);
        postsAsc.add(post2);
        postsAsc.add(post3);

        List<Post> postsDesc = new LinkedList<>();
        postsDesc.add(post2);
        postsDesc.add(post3);
        postsDesc.add(post1);

        List<Post> postsAscCurrent = new LinkedList<>();
        postsAscCurrent.add(post1);
        postsAscCurrent.add(post2);

        List<Post> postsDescCurrent = new LinkedList<>();
        postsDescCurrent.add(post2);
        postsDescCurrent.add(post1);

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);
        Mockito.when(mockRepository.listPostUsr(userId2.getUserId())).thenReturn(postsAsc);
        Mockito.when(mockRepository.listPostUsr(userId2.getUserId())).thenReturn(postsDesc);

        //Act
        ListPostsDTO listPostAsc = service.listPostFollowed(userId1.getUserId(), orderAsc);
        ListPostsDTO listPostDesc = service.listPostFollowed(userId1.getUserId(), orderDesc);

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(listPostAsc, Helper.listPostToListPostDTO(postsAscCurrent,userId1.getUserId())),
                ()->Assertions.assertEquals(listPostDesc, Helper.listPostToListPostDTO(postsDescCurrent,userId1.getUserId())),
                ()->Assertions.assertTrue(listPostAsc.getPosts().size()==Helper.listPostToListPostDTO(postsAscCurrent,userId1.getUserId()).getPosts().size()),
                ()->Assertions.assertTrue(listPostDesc.getPosts().size()==Helper.listPostToListPostDTO(postsDescCurrent,userId1.getUserId()).getPosts().size())
        );
    }

    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta " +
            "(Comportamiento: Devuelve el calculo correcto del total de la cantidad de seguidores que posee un usuario)")
    @Test
    public void verifyCorrectSizeListFollowers(){
        //Arrange
        String order = "name_asc";
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());
        User userId3 = new User(3, "Magali", new LinkedList<User>(), new LinkedList<User>());

        //Siguen a User1
        LinkedList<User> listCurrentOrdered2 = new LinkedList<>();
        listCurrentOrdered2.add(userId2);
        listCurrentOrdered2.add(userId3);
        userId1.setFollowers(listCurrentOrdered2);

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);

        //Act
        CountDTO followersCount = service.countFollowers(userId1.getUserId());

        // Assert
        Assertions.assertEquals(followersCount.getFollowersCount(), userId1.getFollowed().size());
    }

    @DisplayName("T-0008: Verificar que la consulta de publicaciones realizadas en las ultimas dos semanas " +
            "de un determinadovendedor sean efectivamente de las ultimas dos semanas " +
            "(Comportamiento: Devuelveúnicamente los datos de las publicaciones que tengan decha de " +
            "publicaciones dentro de las ultimas dos semanas a partir del dia de la fecha.)")
    @Test
    public void verifyReturnPostOfLastTwoWeeks(){
        //Arrange
        String orderAsc = null;
        String orderDesc = null;
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());
        //Seguidos por User1
        LinkedList<User> listCurrentOrdered = new LinkedList<>();
        listCurrentOrdered.add(userId2);
        userId1.setFollowed(listCurrentOrdered);
        //Siguen a User1
        LinkedList<User> listCurrentOrdered2 = new LinkedList<>();
        listCurrentOrdered2.add(userId2);
        userId1.setFollowers(listCurrentOrdered2);
        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post1 = new Post(2,1, LocalDate.of(2021, 11, 26),3,1540.0, prod1);

        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Post post2 = new Post(2,2, LocalDate.of(2021, 11, 28),2,2450.67, prod2);

        Product prod3 = new Product(3, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Post post3 = new Post(2,3, LocalDate.of(2021, 10, 29),100,2345.0, prod3);
        List<Post> postsAsc = new LinkedList<>();
        postsAsc.add(post1);
        postsAsc.add(post2);
        postsAsc.add(post3);

        List<Post> postsDesc = new LinkedList<>();
        postsDesc.add(post2);
        postsDesc.add(post3);
        postsDesc.add(post1);

        List<Post> postsAscCurrent = new LinkedList<>();
        postsAscCurrent.add(post1);
        postsAscCurrent.add(post2);

        List<Post> postsDescCurrent = new LinkedList<>();
        postsDescCurrent.add(post2);
        postsDescCurrent.add(post1);

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);
        Mockito.when(mockRepository.listPostUsr(userId2.getUserId())).thenReturn(postsAsc);
        Mockito.when(mockRepository.listPostUsr(userId2.getUserId())).thenReturn(postsDesc);

        //Act
        ListPostsDTO listPostAsc = service.listPostFollowed(userId1.getUserId(), orderAsc);
        ListPostsDTO listPostDesc = service.listPostFollowed(userId1.getUserId(), orderDesc);

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertTrue(listPostAsc.getPosts().size()==2),
                ()->Assertions.assertTrue(listPostDesc.getPosts().size()==2)
        );
    }

    @DisplayName("Verificar que al agregar un post no se genera una excepción")
    @Test
    public void verifyAddPost(){
        //Arrange
        User userId = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        Product prod = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post = new Post(userId.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod);

        //Mock
        Mockito.when(mockRepository.containPost(post.getIdPost())).thenReturn(false);
        Mockito.when(mockRepository.containProduct(userId.getUserId(), post.getDetail().getProductId())).thenReturn(false);

        //Act & Assert
        Assertions.assertDoesNotThrow(()->service.addPost(Helper.postToPostDTO(post)));
    }

    @DisplayName("Verificar que al agregar una promo no se genera una excepción")
    @Test
    public void verifyAddPromo(){
        //Arrange
        User userId = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(1, "Silla Gamer","Silla", "Chip", "Negro","");
        PromoDTO promoDTO = new PromoDTO(userId.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod, true, 10.0);
        Promo promo = Helper.promoDTOToPromo(promoDTO);
        //Mock
        Mockito.when(mockRepository.findUser(userId.getUserId())).thenReturn(userId);
        Mockito.when(mockRepository.containPromo(promo.getIdPost())).thenReturn(false);
        Mockito.when(mockRepository.containProductPromo(userId.getUserId(), promo.getDetail().getProductId())).thenReturn(false);

        //Act & Assert
        Assertions.assertDoesNotThrow(()->service.addPromo(promoDTO));
    }

    @DisplayName("Verificar excepcion al agregar una promo con usuario inexistente")
    @Test
    public void verifyExceptionsUserAddPromo(){
        //Arrange
        User user = new User(10, "Vanesa", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(1, "Silla Gamer","Silla", "Chip", "Negro","");
        PromoDTO promoDTO = new PromoDTO(user.getUserId(),1, LocalDate.of(2021, 11, 26),3,13900.0, prod, true, 10.0);
        Promo promo = Helper.promoDTOToPromo(promoDTO);

        BadRequestException exceptionUserCurrent = new BadRequestException("Usuario "+user.getUserId()+" invalido");

        //Act
        BadRequestException exceptionUserExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.addPromo(promoDTO));

        //Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(exceptionUserExpected, exceptionUserCurrent)
        );
    }

    @DisplayName("Verificar excepcion al agregar una promo con id_promo negativo")
    @Test
    public void verifyExceptionsNegativeIdPostAddPromo(){
        //Arrange
        User user = new User(1, "Vanesa", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(1, "Silla Gamer","Silla", "Chip", "Negro","");
        PromoDTO promoDTO = new PromoDTO(user.getUserId(),-1, LocalDate.of(2021, 11, 26),3,13900.0, prod, true, 10.0);
        Promo promo = Helper.promoDTOToPromo(promoDTO);

        BadRequestException exceptionUserCurrent = new BadRequestException("id_post debe ser un número mayor que cero.");
        //Mock
        Mockito.when(mockRepository.findUser(user.getUserId())).thenReturn(user);

        //Act
        BadRequestException exceptionUserExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.addPromo(promoDTO));

        //Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(exceptionUserExpected, exceptionUserCurrent)
        );
    }

    @DisplayName("Verificar excepcion al agregar una promo con precio menor que cero")
    @Test
    public void verifyExceptionsNegativePriceAddPromo(){
        //Arrange
        User user = new User(1, "Vanesa", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(1, "Silla Gamer","Silla", "Chip", "Negro","");
        PromoDTO promoDTO = new PromoDTO(user.getUserId(),1, LocalDate.of(2021, 11, 26),3,-13900.0, prod, true, 10.0);
        Promo promo = Helper.promoDTOToPromo(promoDTO);

        BadRequestException exceptionUserCurrent = new BadRequestException("price debe ser mayor que cero.");
        //Mock
        Mockito.when(mockRepository.findUser(user.getUserId())).thenReturn(user);

        //Act
        BadRequestException exceptionUserExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.addPromo(promoDTO));

        //Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(exceptionUserExpected, exceptionUserCurrent)
        );
    }

    @DisplayName("Verificar excepcion al agregar una promo con descuenta fuera de rango")
    @Test
    public void verifyExceptionsDiscountOutRangeAddPromo(){
        //Arrange
        User user = new User(1, "Vanesa", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(1, "Silla Gamer","Silla", "Chip", "Negro","");
        PromoDTO promoDTO = new PromoDTO(user.getUserId(),1, LocalDate.of(2021, 11, 26),3,13900.0, prod, true, 120.0);
        Promo promo = Helper.promoDTOToPromo(promoDTO);

        BadRequestException exceptionUserCurrent = new BadRequestException("Discount debe ser mayor que cero y menor que 100 para considerarse en promoción.");
        //Mock
        Mockito.when(mockRepository.findUser(user.getUserId())).thenReturn(user);

        //Act
        BadRequestException exceptionUserExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.addPromo(promoDTO));

        //Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(exceptionUserExpected, exceptionUserCurrent)
        );
    }

    @DisplayName("Verificar excepcion al agregar una promo con has_promo false")
    @Test
    public void verifyExceptionsHasPromoFalseAddPromo(){
        //Arrange
        User user = new User(1, "Vanesa", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(1, "Silla Gamer","Silla", "Chip", "Negro","");
        PromoDTO promoDTO = new PromoDTO(user.getUserId(),1, LocalDate.of(2021, 11, 26),3,13900.0, prod, false, 10.0);
        Promo promo = Helper.promoDTOToPromo(promoDTO);

        BadRequestException exceptionUserCurrent = new BadRequestException("has_promo es false, por lo cual no se considera promo y no se almacenará.");
        //Mock
        Mockito.when(mockRepository.findUser(user.getUserId())).thenReturn(user);

        //Act
        BadRequestException exceptionUserExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.addPromo(promoDTO));

        //Act & Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(exceptionUserExpected, exceptionUserCurrent)
        );
    }

    @DisplayName("Verificar el listado de Promos de un usuario.")
    @Test
    public void verifyCorrectReturnListPromoOfAUser(){
        //Arrange
        String order = null;
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Promo post1 = new Promo(userId2.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1, true, 10.0);

        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Promo post2 = new Promo(userId2.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2, true, 10.0);

        Product prod3 = new Product(1, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Promo post3 = new Promo(userId1.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3, true, 10.0);

        List<Promo> promoUser1 = new LinkedList<>();
        promoUser1.add(post3);

        List<Promo> promoUser2 = new LinkedList<>();
        promoUser2.add(post1);
        promoUser2.add(post2);

        ListPromoDTO promoUser1Current = Helper.listPromoToListPromoDTO(promoUser1, userId1);

        ListPromoDTO promoUser2Current= Helper.listPromoToListPromoDTO(promoUser2, userId2);

        //Mock
        Mockito.when(mockRepository.findUser(userId1.getUserId())).thenReturn(userId1);
        Mockito.when(mockRepository.findUser(userId2.getUserId())).thenReturn(userId2);
        Mockito.when(mockRepository.listPromoUsr(userId1.getUserId())).thenReturn(promoUser1);
        Mockito.when(mockRepository.listPromoUsr(userId2.getUserId())).thenReturn(promoUser2);

        //Act
        ListPromoDTO listPromoExpectedUser1 = service.listPromo(userId1.getUserId(),order);
        ListPromoDTO listPromoExpectedUser2 = service.listPromo(userId2.getUserId(),order);

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(listPromoExpectedUser1, promoUser1Current),
                ()->Assertions.assertEquals(listPromoExpectedUser2, promoUser2Current)
        );
    }

    @DisplayName("Verificar el correcto orden ascendente, descendente, null del listado de Promos de un usuario.")
    @Test
    public void verifyCorrectOrderListPromoOfAUser(){
        //Arrange
        String orderAsc = "date_asc";
        String orderDesc = "date_desc";
        String orderNull = null;
        User user = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Promo post1 = new Promo(user.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1, true, 10.0);

        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Promo post2 = new Promo(user.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2, true, 10.0);

        Product prod3 = new Product(3, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Promo post3 = new Promo(user.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3, true, 10.0);

        List<Promo> promoUser = new LinkedList<>();
        promoUser.add(post1);
        promoUser.add(post2);
        promoUser.add(post3);

        List<Promo> promoUserCurrentAsc = new LinkedList<>();
        promoUserCurrentAsc.add(post3);
        promoUserCurrentAsc.add(post1);
        promoUserCurrentAsc.add(post2);
        ListPromoDTO promoDTOUserCurrentAsc = Helper.listPromoToListPromoDTO(promoUserCurrentAsc, user);

        List<Promo> promoUserCurrentDesc = new LinkedList<>();
        promoUserCurrentDesc.add(post2);
        promoUserCurrentDesc.add(post1);
        promoUserCurrentDesc.add(post3);
        ListPromoDTO promoDTOUserCurrentDesc = Helper.listPromoToListPromoDTO(promoUserCurrentDesc, user);

        ListPromoDTO promoDTOUserCurrentNull = Helper.listPromoToListPromoDTO(promoUser, user);

        //Mock
        Mockito.when(mockRepository.findUser(user.getUserId())).thenReturn(user);
        Mockito.when(mockRepository.listPromoUsr(user.getUserId())).thenReturn(promoUser);

        //Act
        ListPromoDTO listPromoAscExpected = service.listPromo(user.getUserId(), orderAsc);
        ListPromoDTO listPromoDescExpected = service.listPromo(user.getUserId(),orderDesc);
        ListPromoDTO listPromoNullExpected = service.listPromo(user.getUserId(),orderNull);

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(listPromoAscExpected, promoDTOUserCurrentAsc),
                ()->Assertions.assertEquals(listPromoDescExpected, promoDTOUserCurrentDesc),
                ()->Assertions.assertEquals(listPromoNullExpected, promoDTOUserCurrentNull)
        );
    }

    @DisplayName("Verificar excepciones en listado de Promos de un usuario por no existencia de usuario.")
    @Test
    public void verifyNotExistenceUsuarioListPromos(){
        //Arrange
        String order = null;
        User user = new User(10, "Vanesa", new LinkedList<User>(), new LinkedList<User>());
        BadRequestException exceptionCurrent = new BadRequestException("Usuario "+user.getUserId()+" no encontrado");

        //Act & Assert
        BadRequestException exceptionExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.listPromo(user.getUserId(), order));
        Assertions.assertEquals(exceptionExpected, exceptionCurrent);
    }

    @DisplayName("Verificar excepciones en listado de Promos de un usuario por no hacer match con order.")
    @Test
    public void verifyNotMatchOrderInListPromos(){
        //Arrange
        String order = "asc_date";
        User user = new User(1, "Vanesa", new LinkedList<User>(), new LinkedList<User>());
        BadRequestException exceptionCurrent = new BadRequestException("order: "+order+" es inválido, solo acepta date_asc o date_desc.");

        //Mock
        Mockito.when(mockRepository.findUser(user.getUserId())).thenReturn(user);

        //Act & Assert
        BadRequestException exceptionExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.listPromo(user.getUserId(), order));
        Assertions.assertEquals(exceptionExpected, exceptionCurrent);
    }

    @DisplayName("Verificar que la cantidad de promos de un usuario sea correcta.")
    @Test
    public void verifyCorrectCountPromoUser(){
        //Arrange
        User user = new User(1, "Anibal", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Promo post1 = new Promo(user.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1, true, 10.0);

        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Promo post2 = new Promo(user.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2, true, 10.0);

        Product prod3 = new Product(3, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Promo post3 = new Promo(user.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3, true, 10.0);

        List<Promo> promoUser = new LinkedList<>();
        promoUser.add(post1);
        promoUser.add(post2);
        promoUser.add(post3);

        int countCurrent= 3;

        //Mock
        Mockito.when(mockRepository.findUser(user.getUserId())).thenReturn(user);
        Mockito.when(mockRepository.listPromoUsr(user.getUserId())).thenReturn(promoUser);

        //Act
        CountDTO countDto = service.countPromos(user.getUserId());

        // Assert
        Assertions.assertEquals(countDto.getProductPromoCount(), countCurrent);
    }

    @DisplayName("Verificar existencia de un usuario al consultar la cantidad de Promos.")
    @Test
    public void verifyUserExistForCountPromos(){
        //Arrange
        User user = new User(6, "Vanesa", new LinkedList<User>(), new LinkedList<User>());

        BadRequestException exceptionCurrent = new BadRequestException("Usuario "+user.getUserId()+" no encontrado");

        //Act
        BadRequestException exceptionExpected =  Assertions.assertThrows(BadRequestException.class, ()->service.countPromos(user.getUserId()));

        //Assert
        Assertions.assertEquals(exceptionExpected, exceptionCurrent);
    }



}
