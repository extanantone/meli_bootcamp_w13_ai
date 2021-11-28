package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.entity.Buyer;
import com.bootcamp.SocialMeli.entity.Post;
import com.bootcamp.SocialMeli.entity.Seller;
import com.bootcamp.SocialMeli.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

    private Buyer user1, user2;
    private Seller user3, user4;
    private List<Post> posts;

    @Mock
    private UserRepositoryImpl mockUserRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        this.user1 = new Buyer(1, "Leon Comprador");
        this.user2 = new Buyer(2, "Juan Comprador");
        this.user3 = new Seller(3, "Manuel Vendedor");
        this.user4 = new Seller(4, "Pedro Vendedor");
        this.posts = new ArrayList<>();

    }

}

