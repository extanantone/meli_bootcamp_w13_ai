package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;


public class RepositoryUserTest {

    IUserRepository iUserRepository;

    @BeforeEach
    private void initialize(){
        this.iUserRepository= new UserRepository();
    }

    @Test
    void verifyUserOrderExistence(){

        //Arrange
        List<DTOUser> UserList = new ArrayList<>();

        UserList.add(new DTOUser(4,"Marco"));
        UserList.add(new DTOUser(3,"Gabriela"));
        UserList.add(new DTOUser(1,"Andres"));
        UserList.add(new DTOUser(2,"Anibal"));

        String order = null;

        //Act and Assert
        Assertions.assertThrows(RuntimeException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                List<DTOUser> response = iUserRepository.orderFollowersAndFolloweds(UserList,order);
            }
        });

    }

    @Test
    void verifyUserOrderASC(){

        List<DTOUser> UserListSorted = new ArrayList<>();
        List<DTOUser> UserListNotSorted = new ArrayList<>();


        UserListSorted.add(new DTOUser(1,"Andres"));
        UserListSorted.add(new DTOUser(2,"Anibal"));
        UserListSorted.add(new DTOUser(3,"Gabriela"));
        UserListSorted.add(new DTOUser(4,"Marco"));

        UserListNotSorted.add(new DTOUser(4,"Marco"));
        UserListNotSorted.add(new DTOUser(2,"Anibal"));
        UserListNotSorted.add(new DTOUser(3,"Gabriela"));
        UserListNotSorted.add(new DTOUser(1,"Andres"));

        UserListNotSorted = iUserRepository.orderFollowersAndFolloweds(UserListNotSorted,"name_asc");

        Assertions.assertEquals(UserListSorted,UserListNotSorted);


    }

    @Test
    void verifyUserOrderDESC(){

        List<DTOUser> UserListSorted = new ArrayList<>();
        List<DTOUser> UserListNotSorted = new ArrayList<>();


        UserListSorted.add(new DTOUser(4,"Marco"));
        UserListSorted.add(new DTOUser(3,"Gabriela"));
        UserListSorted.add(new DTOUser(2,"Anibal"));
        UserListSorted.add(new DTOUser(1,"Andres"));

        UserListNotSorted.add(new DTOUser(4,"Marco"));
        UserListNotSorted.add(new DTOUser(3,"Gabriela"));
        UserListNotSorted.add(new DTOUser(1,"Andres"));
        UserListNotSorted.add(new DTOUser(2,"Anibal"));

        UserListNotSorted = iUserRepository.orderFollowersAndFolloweds(UserListNotSorted,"name_desc");

        Assertions.assertEquals(UserListSorted,UserListNotSorted);


    }
}
