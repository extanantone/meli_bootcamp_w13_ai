package com.mercadolibre.socialmeli.repository;

import com.mercadolibre.socialmeli.model.Follow;
import com.mercadolibre.socialmeli.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SocialRepositoryImplTest {

    SocialRepositoryImpl socialRepository = new SocialRepositoryImpl();
    private Follow follow;

    @Test
    void followToUser() {
        //Arrange
        follow = new Follow(1,2);
        int idUser = 1;
        int idUserToFollow = 2;
        //Act
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
        int idUser = 1;
        User response = socialRepository.findUserById(idUser);
        Assertions.assertNotNull(response);
    }

    @Test
    void addUserFollower() {
    }

    @Test
    void addUserFollowed() {
    }



    @Test
    void allFollowers() {
    }

    @Test
    void allFollowed() {
    }

    @Test
    void addPublication() {
    }

    @Test
    void countFollowers() {
    }

    @Test
    void latestPublications() {
    }

    @Test
    void unFollowUser() {
    }

    @Test
    void orderingUsersFollowers() {
    }

    @Test
    void orderingUsersFolloweds() {
    }

    @Test
    void sortPublicationsSellers() {
    }

    @Test
    void usuariosDefault() {
    }

    @Test
    void save() {
    }
}