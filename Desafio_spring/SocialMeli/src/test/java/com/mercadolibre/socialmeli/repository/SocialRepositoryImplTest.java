package com.mercadolibre.socialmeli.repository;

import com.mercadolibre.socialmeli.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class SocialRepositoryImplTest {

    static SocialRepositoryImpl socialRepository = new SocialRepositoryImpl();
    private final static String NAME_ASC = "name_asc";
    private final static String NAME_DESC = "name_desc";
    private final static String DATE_ASC = "date_asc";
    private final static String DATE_DESC = "date_desc";
    private static List<User> followersList;

    @BeforeAll
    public static void setUp(){
        // esto me sirve para comparar que tanto la listade foolower como el user followed(id,name) esten bien
        socialRepository.users.put(4, new User(4,"Otro"));
        socialRepository.followers.put(4,followersList); //Recibe la lista desordenada de los followers
        followersList = new ArrayList<>();
        followersList.add(new User(2, "Pepe"));
        followersList.add(new User(1, "Maga"));
        followersList.add(new User(3, "Fulanito"));
    }

    @Test
    void followToUser() {
        //Arrange
        Follow follow = new Follow(1, 2);
        int idUser = 1;
        int idUserToFollow = 2;
        //Act
        Follow reponse = socialRepository.followToUser(idUser, idUserToFollow);
        //Asserts
        Assertions.assertEquals(follow,reponse);
    }
    @Test
    void userIsAlreadyFollowingAnotherUser() {
        //Arrange
        Follow follow = new Follow(1, 2);
        int idUser = 1;
        int idUserToFollow = 2;
        List<User>followersAdd = new ArrayList<>();
        followersAdd.add(new User(3, "Fulanito"));
        List<User>followedsAdd = new ArrayList<>();
        followedsAdd.add(new User(1, "Pepe"));
        //Act
        socialRepository.followed.put(1, followersAdd);
        socialRepository.followers.put(3, followedsAdd);
        Follow reponse = socialRepository.followToUser(idUser, idUserToFollow);
        //Asserts
        Assertions.assertEquals(follow,reponse);
    }

    //TODO Verificar que el usuario a seguir NO exista. (US-0001)
    @Test
    void userNotFound(){ //Debería Lanzar una excepcion
        int idUser = 6;
        User response = socialRepository.findUserById(idUser);
        Assertions.assertNull(response);
    }

    //Verificar que el usuario a seguir exista. (US-0001)
    @Test
    void findUserById() {
        //Arrange
        int idUser = 1;
        //Act
        User response = socialRepository.findUserById(idUser);
        //Assert
        Assertions.assertNotNull(response);
    }

    @DisplayName("OrderFollowersFromUserByAlphabeticAsc")
    @Test
    void orderAphabeticFollowersAsc() {

        Followers payload = new Followers();
        payload.setId(4);
        payload.setName("Otro");
        payload.setUsers(followersList);

        //Lo que espero
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(3, "Fulanito"));
        expectedList.add(new User(1, "Maga"));
        expectedList.add(new User(2, "Pepe"));

        Followers expected = new Followers();
        expected.setUsers(expectedList);
        expected.setId(4);
        expected.setName("Otro");
        //Carga el usuario 4 a la lista de usuarios,
        // esto me sirve para comparar que tanto la listade foolower como el user followed(id,name) esten bien
        socialRepository.users.put(4, new User(4,"Otro"));
        socialRepository.followers.put(4,followersList); //Recibe la lista desordenada de los followers

        Followers current = socialRepository.orderingUsersFollowers(payload.getId(), NAME_ASC);
        Assertions.assertEquals(expected,current);
    }

    @DisplayName("OrderFollowersFromUserByAlphabeticDesc")
    @Test
    void orderAphabeticFollowersDesc() {
        Followers payload = new Followers();
        payload.setId(4);
        payload.setName("Otro");
        payload.setUsers(followersList);

        //Lo que espero
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(2, "Pepe"));
        expectedList.add(new User(1, "Maga"));
        expectedList.add(new User(3, "Fulanito"));

        Followers expected = new Followers();
        expected.setUsers(expectedList);
        expected.setId(4);
        expected.setName("Otro");
        //Carga el usuario 4 a la lista de usuarios,
        // esto me sirve para comparar que tanto la listade foolower como el user followed(id,name) esten bien
        socialRepository.users.put(4, new User(4,"Otro"));
        socialRepository.followers.put(4, followersList); //Recibe la lista desordenada de los followers

        Followers current = socialRepository.orderingUsersFollowers(payload.getId(), NAME_DESC);
        Assertions.assertEquals(expected,current);
    }

    @DisplayName("OrderAphabeticFollowersWithParamNull")
    @Test
    void orderAphabeticFollowersNull() {

        Followers payload = new Followers();
        payload.setId(4);
        payload.setName("Otro");
        payload.setUsers(followersList);

        //Lo que espero
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(3, "Fulanito"));
        expectedList.add(new User(1, "Maga"));
        expectedList.add(new User(2, "Pepe"));

        Followers expected = new Followers();
        expected.setUsers(expectedList);
        expected.setId(4);
        expected.setName("Otro");
        //Carga el usuario 4 a la lista de usuarios,
        // esto me sirve para comparar que tanto la listade foolower como el user followed(id,name) esten bien
        socialRepository.users.put(4, new User(4,"Otro"));
        socialRepository.followers.put(4,followersList); //Recibe la lista desordenada de los followers

        Followers current = socialRepository.orderingUsersFollowers(payload.getId(), null);
        Assertions.assertEquals(expected,current);
    }

    //S06 Lista de publicaciones de mas antigua a mas reciente no tiene limites fecha
    @DisplayName("OrderPublicatiosUserFollowedByDateAsc")
    @Test
    void orderPublicatiosByDateAsc() {

        //Creo productos publicados
        Product p1 = new Product(1,"papa","verdura","nose","marron","Papitas ricas");
        Product p2 = new Product(2,"Zapallo","verdura","nose","Verde","");
        Product p3 = new Product(3,"Tomate","verdura","nose","Rojo","Tomates cherry");

        //Fecha de publicaciones
        LocalDate date1 = LocalDate.of(2021,11,25);
        LocalDate date2 = LocalDate.of(2021,10,15);
        LocalDate date3 = LocalDate.of(2021,11,17);

        //Lista de publicaciones
        List<Publication>publications = new ArrayList<>();
        publications.add(new Publication(1,1, date1, p1,1,100.00));
        publications.add(new Publication(1,3, date2, p2,1,20.05));
        publications.add(new Publication(1,2, date3, p3,1,80.00));

        PublicationsFollowed publicationsFollowed = new PublicationsFollowed();
        publicationsFollowed.setUserId(4);
        publicationsFollowed.setPosts(publications);

        //Expect publications
        PublicationsFollowed pFollowedExpected = new PublicationsFollowed();
        List<Publication>publicationsExpected = new ArrayList<>();
        publicationsExpected.add(new Publication(1,3, date2, p2,1,20.05));
        publicationsExpected.add(new Publication(1,2, date3, p3,1,80.00));
        publicationsExpected.add(new Publication(1,1, date1, p1,1,100.00));
        pFollowedExpected.setUserId(4);
        pFollowedExpected.setPosts(publicationsExpected);
        //Agrego las publicaciones del usuario con id 1
        socialRepository.publications.put(1, publications);

        //Cargo los vendedores a los que sigue el usuario con id 4
        socialRepository.followed.put(4,followersList); // Al usuario con id 4 lo siguen los usuarios de followersList
        //sortPublicationsSellers
        PublicationsFollowed pubFollewedCurrent = socialRepository.sortPublicationsSellers(4, DATE_ASC);
        Assertions.assertEquals(pFollowedExpected,pubFollewedCurrent);
    }

    //S06 Lista de publicaciones de mas antigua a mas reciente no tiene limites fecha
    @DisplayName("OrderPublicatiosUserFollowedByDateDesc")
    @Test
    void orderPublicatiosByDateDesc() {

        //Creo productos publicados
        Product p1 = new Product(1,"papa","verdura","nose","marron","Papitas ricas");
        Product p2 = new Product(2,"Zapallo","verdura","nose","Verde","");
        Product p3 = new Product(3,"Tomate","verdura","nose","Rojo","Tomates cherry");

        //Fecha de publicaciones
        LocalDate date1 = LocalDate.of(2021,11,25);
        LocalDate date2 = LocalDate.of(2021,10,15);
        LocalDate date3 = LocalDate.of(2021,11,17);

        //Lista de publicaciones
        List<Publication>publications = new ArrayList<>();
        publications.add(new Publication(1,1, date1, p1,1,100.00));
        publications.add(new Publication(1,3, date2, p2,1,20.05));
        publications.add(new Publication(1,2, date3, p3,1,80.00));

        PublicationsFollowed publicationsFollowed = new PublicationsFollowed();
        publicationsFollowed.setUserId(4);
        publicationsFollowed.setPosts(publications);

        //Expect publications
        PublicationsFollowed pFollowedExpected = new PublicationsFollowed();
        List<Publication>publicationsExpected = new ArrayList<>();
        publicationsExpected.add(new Publication(1,1, date1, p1,1,100.00));
        publicationsExpected.add(new Publication(1,2, date3, p3,1,80.00));
        publicationsExpected.add(new Publication(1,3, date2, p2,1,20.05));
        pFollowedExpected.setUserId(4);
        pFollowedExpected.setPosts(publicationsExpected);
        //Agrego las publicaciones del usuario con id 1
        socialRepository.publications.put(1, publications);

        //Cargo los vendedores a los que sigue el usuario con id 4
        socialRepository.followed.put(4, followersList); // Al usuario con id 4 lo siguen los usuarios de followersList
        //sortPublicationsSellers
        PublicationsFollowed pubFollewedCurrent = socialRepository.sortPublicationsSellers(4, DATE_DESC);
        Assertions.assertEquals(pFollowedExpected,pubFollewedCurrent);
    }

    @DisplayName("OrderPublicatiosUserFollowedByDateNull")
    @Test
    void orderPublicatiosByDateNull() {

        //Creo productos publicados
        Product p1 = new Product(1,"papa","verdura","nose","marron","Papitas ricas");
        Product p2 = new Product(2,"Zapallo","verdura","nose","Verde","");
        Product p3 = new Product(3,"Tomate","verdura","nose","Rojo","Tomates cherry");

        //Fecha de publicaciones
        LocalDate date1 = LocalDate.of(2021,11,25);
        LocalDate date2 = LocalDate.of(2021,10,15);
        LocalDate date3 = LocalDate.of(2021,11,17);

        //Lista de publicaciones
        List<Publication>publications = new ArrayList<>();
        publications.add(new Publication(1,1, date1, p1,1,100.00));
        publications.add(new Publication(1,3, date2, p2,1,20.05));
        publications.add(new Publication(1,2, date3, p3,1,80.00));

        PublicationsFollowed publicationsFollowed = new PublicationsFollowed();
        publicationsFollowed.setUserId(4);
        publicationsFollowed.setPosts(publications);

        //Expect publications
        PublicationsFollowed pFollowedExpected = new PublicationsFollowed();
        List<Publication>publicationsExpected = new ArrayList<>();
        publicationsExpected.add(new Publication(1,1, date1, p1,1,100.00));
        publicationsExpected.add(new Publication(1,2, date3, p3,1,80.00));
        publicationsExpected.add(new Publication(1,3, date2, p2,1,20.05));
        pFollowedExpected.setUserId(4);
        pFollowedExpected.setPosts(publicationsExpected);
        //Agrego las publicaciones del usuario con id 1
        socialRepository.publications.put(1, publications);

        //Cargo los vendedores a los que sigue el usuario con id 4
        socialRepository.followed.put(4, followersList); // Al usuario con id 4 lo siguen los usuarios de followersList
        //sortPublicationsSellers
        PublicationsFollowed pubFollewedCurrent = socialRepository.sortPublicationsSellers(4, null);
        Assertions.assertEquals(pFollowedExpected,pubFollewedCurrent);
    }

    @Test
    void followersCount(){
        //Arrange
        Followers followersUser = new Followers();
        followersUser.setUsers(followersList);
        followersUser.setId(4);
        followersUser.setName("Otro");
        Long expected = (long) followersList.size();
        //ACT
        socialRepository.followers.put(4,followersList);
        Long countCurrent = socialRepository.countFollowers(4);
        //ASSERTIONS
        Assertions.assertEquals(expected, countCurrent);
    }

    @Test
    void userWithoutFollowers(){
        //Arrange
        Followers followersUser = new Followers();
        List<User> followersExpeted = new ArrayList<>();
        followersUser.setUsers(followersExpeted);
        followersUser.setId(4);
        followersUser.setName("Otro");
        Long expected = 0L;
        //ACT
        socialRepository.followers.put(4,followersExpeted);
        Long countCurrent = socialRepository.countFollowers(4);
        //ASSERTIONS
        Assertions.assertEquals(expected, countCurrent);
    }

    @DisplayName("lastTwoWeeksOfFollowedSellersPosts")
    @Test
    void latestPublicationsSellers(){

        //Creo productos publicados
        Product p1 = new Product(1,"papa","verdura","nose","marron","Papitas ricas");
        Product p2 = new Product(2,"Zapallo","verdura","nose","Verde","");
        Product p3 = new Product(3,"Tomate","verdura","nose","Rojo","Tomates cherry");

        //Fecha de publicaciones
        LocalDate date1 = LocalDate.of(2021,11,25);
        LocalDate date2 = LocalDate.of(2021,10,15);
        LocalDate date3 = LocalDate.of(2021,11,17);

        //Lista de publicaciones
        List<Publication>publications = new ArrayList<>();
        publications.add(new Publication(1,1, date1, p1,1,100.00));
        publications.add(new Publication(1,3, date2, p2,1,20.05));
        publications.add(new Publication(1,2, date3, p3,1,80.00));

        PublicationsFollowed publicationsFollowed = new PublicationsFollowed();
        publicationsFollowed.setUserId(4);
        publicationsFollowed.setPosts(publications);

        //Expect publications
        PublicationsFollowed pFollowedExpected = new PublicationsFollowed();
        List<Publication>publicationsExpected = new ArrayList<>();
        publicationsExpected.add(new Publication(1,2, date3, p3,1,80.00));
        publicationsExpected.add(new Publication(1,1, date1, p1,1,100.00));
        pFollowedExpected.setUserId(4);
        pFollowedExpected.setPosts(publicationsExpected);
        //Agrego las publicaciones del usuario con id 1
        socialRepository.publications.put(1, publications);

        //Cargo los vendedores a los que sigue el usuario con id 4
        socialRepository.followed.put(4,followersList); // Al usuario con id 4 lo siguen los usuarios de followersList
        //sortPublicationsSellers
        PublicationsFollowed pubFollewedCurrent = socialRepository.latestPublications(4);
        Assertions.assertEquals(pFollowedExpected,pubFollewedCurrent);
    }


}