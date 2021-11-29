package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.Exception.NotFoundException;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import com.bootcamp.SocialMeli.Repository.SocialRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SocialRepositoryTest {
    SocialRepository repo;

    @BeforeEach
    private void initialize(){
        this.repo= new SocialRepository();
    }

    @Test
    @DisplayName(value = "Sigue a un usuario.")
    public void followSeller(){
        //Arrange
        Usuario follower=new Usuario("Mario");
        Usuario followed=new Usuario("Bootcamp");
        Seguidor follow=new Seguidor();
        follow.setIdUser(follower.getUserId());
        follow.setIdUserFollow(followed.getUserId());
        //Act
        Seguidor seguidor=repo.Follow(follow);
        //Assert
        Assertions.assertEquals(follow.getIdUserFollow(),seguidor.getIdUserFollow());
    }

    @Test
    @DisplayName(value = "Deja de seguir a un usuario.")
    public void unFollowSeller(){
        //Arrange
        Usuario follower=new Usuario("Mario");
        Usuario followed=new Usuario("Bootcamp");
        Seguidor unFollow=new Seguidor();
        unFollow.setIdUser(follower.getUserId());
        unFollow.setIdUserFollow(followed.getUserId());
        //Act y actt
        Assertions.assertDoesNotThrow(() -> repo.unFollow(unFollow));
    }

    @Test
    @DisplayName(value = "Consulta a un usuario que existe.")
    public void getUserExist() throws NotFoundException{
        //Arrange
        Integer userId=2;
        //Act
        Usuario resp= repo.getUsuario(userId);
        //Assertions
        Assertions.assertDoesNotThrow(() -> repo.getUsuario(userId));
        //Assertions.assertEquals(userId,resp.getUserId());
    }

    @Test
    @DisplayName(value = "Consulta a un usuario que no existe.")
    public void getUserNoExist() throws NotFoundException{
        //Arrange
        Integer userId=5;  // Este Id no existe
        //Act
        Usuario resp= repo.getUsuario(userId);
        //Assertions
        Assertions.assertNull(resp);
        //Assertions.assertEquals(userId,resp.getUserId());
    }

}
