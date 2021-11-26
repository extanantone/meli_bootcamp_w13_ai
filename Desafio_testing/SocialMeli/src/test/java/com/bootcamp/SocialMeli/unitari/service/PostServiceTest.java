package com.bootcamp.SocialMeli.unitari.service;

import com.bootcamp.SocialMeli.dto.PublicacionesDTO;
import com.bootcamp.SocialMeli.mapper.PostMater;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import com.bootcamp.SocialMeli.service.PostService;
import com.bootcamp.SocialMeli.util.PostUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    PostService service;

    UserServicieTest userTest = new UserServicieTest();

    //T-0006 -1
    @Test
    void whengetPublicacionesOrderThenOrderFechaAscOK(){

        //Arrange
        PublicacionesDTO expected = new PublicacionesDTO();
        expected.setUser_id(3);
        expected.setPosts(PostUtil.postsDTOSOrderAsc());

        //
        Mockito.when(repository.getPosts(3)).thenReturn(PostUtil.posts());

        PublicacionesDTO current = service.getPublicaciones(3,"date_asc");

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.getPosts().get(0).getDate(),current.getPosts().get(0).getDate()),
                () -> Assertions.assertEquals(expected.getPosts().get(1).getDate(),current.getPosts().get(1).getDate()),
                () -> Assertions.assertEquals(expected.getPosts().get(2).getDate(),current.getPosts().get(2).getDate())
        );


    }

    //T-0006 -2
    @Test
    void whengetPublicacionesOrderThenOrderFechaDescOK(){

        //Arrange
        PublicacionesDTO expected = new PublicacionesDTO();
        expected.setUser_id(3);
        expected.setPosts(PostUtil.postsDTOSOrderDesc());

        //Mocks
        Mockito.when(repository.getPosts(3)).thenReturn(PostUtil.posts());

        PublicacionesDTO current = service.getPublicaciones(3,"date_desc");

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.getPosts().get(0).getDate(),current.getPosts().get(0).getDate()),
                () -> Assertions.assertEquals(expected.getPosts().get(1).getDate(),current.getPosts().get(1).getDate()),
                () -> Assertions.assertEquals(expected.getPosts().get(2).getDate(),current.getPosts().get(2).getDate())
        );


    }

    //T-0008
    User userSeguidor = new User(1,"Juan");
    User userSeguido = new User(3,"Pedro");
    @Test
    void whengetPublicacionesThenDatenoOlderThan14Days(){

        //Arrange

        Mockito.when(repository.getSegidor()).thenReturn(userTest.seguidors);
        Mockito.when(repository.getUser(3)).thenReturn(userSeguido);
        Mockito.when(repository.getPosts(3)).thenReturn(PostUtil.posts());
        Mockito.when(repository.getPost(1)).thenReturn(PostUtil.post1);
        Mockito.when(repository.getPost(2)).thenReturn(PostUtil.post2);
        Mockito.when(repository.getPost(3)).thenReturn(PostUtil.post3);
        //act
        PublicacionesDTO current = service.getPublicaciones(2);
        //Assert

        Assertions.assertEquals(2,current.getPosts().size());

    }


}
