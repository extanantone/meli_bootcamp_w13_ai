package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.model.Buyer;
import com.SocialMeli.SocialMeli.model.Seller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocialMeliRepositoryTest {

    SocialMeliRepository repository;

    @BeforeEach
    void c(){
        this.repository = new SocialMeliRepository();
    }

    @Test
    void UserFollowValid(){
        Seller expected = new Seller("Raul", 1);
        Seller act =repository.searchSeller(expected.getUser_id());
        assertAll("sellers", () -> assertEquals(expected.getUser_name(), act.getUser_name()),
                () -> assertEquals(expected.getUser_id(), act.getUser_id()));
    }

    @Test
    void UserUnFollowNoValid(){
        Seller act=repository.searchSeller(42);
        assertEquals(null,act);

    }
}
