package com.meli.SocialMeli.unit.repository;

import com.meli.SocialMeli.dto.ListPostsDTO;
import com.meli.SocialMeli.helper.Helper;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.Promo;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.reposity.IRepository;
import com.meli.SocialMeli.reposity.RepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class RepositoryImplTest {

    IRepository repository;

    @BeforeEach
    private void setUp() {
        this.repository = new RepositoryImpl();
    }

    @DisplayName("Existencia de un usuario (Caso Exitoso)")
    @Test
    public void verifyUserExistence(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;

        //Act
        User userIdExpected = repository.findUser(userId);
        User userIdToFollowExpected = repository.findUser(userIdToFollow);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userIdExpected.getUserId(), userId),
                () -> Assertions.assertEquals(userIdToFollowExpected.getUserId(), userIdToFollow)
        );

    }

    @DisplayName("Existencia de un usuario (Caso no exitoso)")
    @Test
    public void verifyUserNotExistence(){
        //Arrange
        int userId = 10;
        int userIdToFollow = 8;
        User userIdCurrent = null;
        User userIdToFollowCurrent = null;

        //Act
        User userIdExpected = repository.findUser(userId);
        User userIdToFollowExpected = repository.findUser(userIdToFollow);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userIdExpected, userIdCurrent),
                () -> Assertions.assertEquals(userIdToFollowExpected, userIdToFollowCurrent)
        );
    }

    @DisplayName("Comprobar si un usuario ya sigue a otro (Caso en lo siga)")
    @Test
    public void verifyContainUser(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;
        repository.addFollower(userId,userIdToFollow);

        //Act & Assert
        Assertions.assertTrue(repository.containFollower(userIdToFollow, userId));
    }

    @DisplayName("Comprobar si un usuario ya sigue a otro (Caso en que no lo siga)")
    @Test
    public void verifyNotContainUser(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;

        //Act & Assert
        Assertions.assertFalse(repository.containFollower(userIdToFollow, userId));
    }

    @DisplayName("Verificar la lista de usuarios que segui un determinado usuario (listFollowers)")
    @Test
    public void verifyListFollowers(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;
        int userIdToFollow2 = 4;
        repository.addFollower(userId, userIdToFollow);
        repository.addFollower(userId, userIdToFollow2);
        List<User> listFollowesCurrent = new LinkedList<>();
        listFollowesCurrent.add(repository.findUser(3));
        listFollowesCurrent.add(repository.findUser(4));

        //Act
        List<User> followersExpected = repository.listFollowers(userId);

        // Assert
        Assertions.assertEquals(followersExpected, listFollowesCurrent);
    }

    @DisplayName("usuario no sigue a nadie (listFollowers)")
    @Test
    public void verifyNotReturnListFollowers(){
        //Arrange
        int userId = 1;
        List<User> listFollowesCurrent = new LinkedList<>();

        //Act
        List<User> followersExpected = repository.listFollowers(userId);

        // Assert
        Assertions.assertEquals(followersExpected, listFollowesCurrent);
    }

    @DisplayName("Verificar que no hay error al agregar un usuario")
    @Test
    public void verifyAddFollower(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;

        //Act & Assert
        Assertions.assertDoesNotThrow(()->repository.addFollower(userId, userIdToFollow));
    }

    @DisplayName("Verificar la lista de usuarios que me siguen(listFollowers)")
    @Test
    public void verifyListFollowed(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;
        int userIdToFollow2 = 4;
        repository.addFollower(userId, userIdToFollow);
        repository.addFollower(userId, userIdToFollow2);
        List<User> listFollowesCurrent = new LinkedList<>();
        listFollowesCurrent.add(repository.findUser(3));
        listFollowesCurrent.add(repository.findUser(4));

        //Act
        List<User> followersExpected = repository.listFollowed(userId);

        // Assert
        Assertions.assertEquals(followersExpected, listFollowesCurrent);
    }

    @DisplayName("Verificar que no hay error al almacenar un post")
    @Test
    public void verifyAddPost(){
        //Arrange
        int userId = 1;
        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post1 = new Post(userId,1, LocalDate.of(2021, 11, 26),3,1540.0, prod1);

        //Act & Assert
        Assertions.assertDoesNotThrow(()->repository.addPost(post1));
    }

    @DisplayName("Verificar la correcta devolución de lista de post de un usuario")
    @Test
    public void verifyCorrectListPostUser(){
        //Arrange
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post1 = new Post(userId2.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1);
        repository.addPost(post1);
        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Post post2 = new Post(userId2.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2);
        repository.addPost(post2);
        Product prod3 = new Product(3, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Post post3 = new Post(userId1.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3);
        repository.addPost(post3);

        List<Post> postsCurrentUser1 = new LinkedList<>();
        postsCurrentUser1.add(post3);
        List<Post> postsCurrentUser2 = new LinkedList<>();
        postsCurrentUser2.add(post1);
        postsCurrentUser2.add(post2);

        //Act
        List<Post> postsExpected = repository.listPostUsr(userId1.getUserId());
        List<Post> postsExpected2 = repository.listPostUsr(userId2.getUserId());

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(postsExpected, postsCurrentUser1),
                ()->Assertions.assertEquals(postsExpected.size(), 1),
                ()->Assertions.assertEquals(postsExpected2, postsCurrentUser2),
                ()->Assertions.assertEquals(postsExpected2.size(), 2)
        );
    }

    @DisplayName("Verificar si el ID de un Post ya existe, con ID existente")
    @Test
    public void verifyExistPost(){
        //Arrange
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post1 = new Post(userId2.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1);
        repository.addPost(post1);
        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Post post2 = new Post(userId2.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2);
        repository.addPost(post2);

        Product prod3 = new Product(1, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Post post3WithSameIDAtPost1 = new Post(userId1.getUserId(),1, LocalDate.of(2021, 10, 29),100,2345.0, prod3);

        //Act &Assert
        Assertions.assertTrue(repository.containPost(post3WithSameIDAtPost1.getIdPost()));
    }

    @DisplayName("Verificar si el ID de un producto de un Post ya existe para un usuario, con ID existente")
    @Test
    public void verifyExistProductPostForUser(){
        //Arrange
        User userId = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post1 = new Post(userId.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1);
        repository.addPost(post1);
        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Post post2 = new Post(userId.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2);
        repository.addPost(post2);

        Product prod3 = new Product(1, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Post post3WithSameIDAtPost1 = new Post(userId.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3);

        //Act &Assert
        Assertions.assertTrue(repository.containProduct(userId.getUserId(), post3WithSameIDAtPost1.getDetail().getProductId()));
    }

    @DisplayName("Verificar si el ID de un Post ya existe, con ID no existente")
    @Test
    public void verifyNotExistPost(){
        //Arrange
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Post post1 = new Post(userId2.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1);
        repository.addPost(post1);
        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Post post2 = new Post(userId2.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2);
        repository.addPost(post2);

        Product prod3 = new Product(1, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Post post3 = new Post(userId1.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3);

        //Act &Assert
        Assertions.assertFalse(repository.containPost(post3.getIdPost()));
    }

    @DisplayName("Verificar que no hay error al dejar de seguir un usuario")
    @Test
    public void verifyUnfollower(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;
        int userIdOtherToFollow = 4;
        repository.addFollower(userId, userIdToFollow);
        repository.addFollower(userId, userIdOtherToFollow);

        //Act & Assert
        Assertions.assertDoesNotThrow(()->repository.unfollow(userId, userIdToFollow));
    }

    @DisplayName("Verificar que no hay error al almacenar una Promo")
    @Test
    public void verifyAddPromo(){
        //Arrange
        int userId = 1;
        Product prod = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Promo promo = new Promo(userId,1, LocalDate.of(2021, 11, 26),3,1540.0, prod, true, 20);

        //Act & Assert
        Assertions.assertDoesNotThrow(()->repository.addPromo(promo));
    }

    @DisplayName("Verificar la correcta devolución de lista de promo de un usuario")
    @Test
    public void verifyCorrectListPromoUser(){
        //Arrange
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Promo promo1 = new Promo(userId2.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1, true, 10);
        repository.addPromo(promo1);
        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Promo promo2 = new Promo(userId2.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2, true, 15);
        repository.addPromo(promo2);
        Product prod3 = new Product(3, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Promo promo3 = new Promo(userId1.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3, true, 10);
        repository.addPromo(promo3);

        List<Promo> promosCurrentUser1 = new LinkedList<>();
        promosCurrentUser1.add(promo3);
        List<Promo> promosCurrentUser2 = new LinkedList<>();
        promosCurrentUser2.add(promo1);
        promosCurrentUser2.add(promo2);

        //Act
        List<Promo> promosExpected = repository.listPromoUsr(userId1.getUserId());
        List<Promo> promosExpected2 = repository.listPromoUsr(userId2.getUserId());

        // Assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(promosExpected, promosCurrentUser1),
                ()->Assertions.assertEquals(promosExpected.size(), 1),
                ()->Assertions.assertEquals(promosExpected2, promosCurrentUser2),
                ()->Assertions.assertEquals(promosExpected2.size(), 2)
        );
    }

    @DisplayName("Verificar si el ID de un Promo ya existe, con ID existente")
    @Test
    public void verifyExistPromo(){
        //Arrange
        User userId1 = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());
        User userId2 = new User(2, "Anibal", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Promo promo1 = new Promo(userId2.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1, true, 10);
        repository.addPromo(promo1);
        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Promo promo2 = new Promo(userId2.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2, true, 15);
        repository.addPromo(promo2);

        Product prod3 = new Product(1, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Promo promo3WithSameIDAtPromo1 = new Promo(userId1.getUserId(),1, LocalDate.of(2021, 10, 29),100,2345.0, prod3, true, 10);

        //Act &Assert
        Assertions.assertTrue(repository.containPromo(promo3WithSameIDAtPromo1.getIdPost()));
    }

    @DisplayName("Verificar si el ID de un producto de una Promo ya existe para un usuario, con ID existente")
    @Test
    public void verifyExistProductPromoForUser(){
        //Arrange
        User userId = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        Product prod1 = new Product(1, "Silla Gamer","Silla", "Chip", "Negro","");
        Promo promo1 = new Promo(userId.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod1, true, 10);
        repository.addPromo(promo1);
        Product prod2 = new Product(2, "Silla Gamer 2","Silla", "Chip", "Negro","");
        Promo promo2 = new Promo(userId.getUserId(),2, LocalDate.of(2021, 11, 28),2,2450.67, prod2, true, 15);
        repository.addPromo(promo2);

        Product prod3 = new Product(1, "Silla Gamer 3","Silla", "Chip", "Negro","");
        Promo promo3WithSameIDAtPromo1 = new Promo(userId.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod3, true, 10);

        //Act &Assert
        Assertions.assertTrue(repository.containProductPromo(userId.getUserId(),promo3WithSameIDAtPromo1.getDetail().getProductId()));
    }

}
