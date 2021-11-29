package com.example.socialmeli;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class TestUtilsGet {

    private static ModelMapper mapper = new ModelMapper();

    public static User getManuel() {
        User manuel = new User();
        manuel.setUserId(1);
        manuel.setUserName("Manuel");
        manuel.setFollowersId(Collections.emptyList());
        return manuel;
    }

    public static User getAzul() {
        User azul = new User();
        azul.setUserId(2);
        azul.setUserName("Azul");
        azul.setFollowersId(Collections.emptyList());
        return azul;
    }

    public static User getFede() {
        User fede = new User();
        fede.setUserId(3);
        fede.setUserName("Fede");
        fede.setFollowersId(Collections.emptyList());
        return fede;
    }

    public static List<User> getUnsortedUserList() {
        return List.of(getManuel(), getAzul(), getFede());
    }


    public static List<UserDTO> getUnsortedUserDTOList() {
        List<User> users = getUnsortedUserList();
        return users.stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
    }

    public static Post getZapatillas() {
        Post zapatillas = new Post();

        zapatillas.setUserId(1);
        Date zapatillasDate = Date.from(LocalDate.of(2021, 11, 26).atStartOfDay(ZoneId.systemDefault()).toInstant());
        zapatillas.setDate(zapatillasDate);
        zapatillas.setCategory(14);
        zapatillas.setIdPost(1);
        zapatillas.setPrice(100);

        Product zapatillasDetail = new Product();
        zapatillasDetail.setProductId(1);
        zapatillasDetail.setProductName("zapatillas");
        zapatillasDetail.setBrand("Nike");
        zapatillasDetail.setColor("Azul");
        zapatillasDetail.setType("Para correr");
        zapatillas.setDetail(zapatillasDetail);

        return zapatillas;
    }

    public static PostDTO getZapatillasDTO() {
        Post zapatillas = getZapatillas();
        return mapper.map(zapatillas, PostDTO.class);
    }

    public static Post getSilla() {
        Post silla = new Post();

        silla.setUserId(2);
        Date sillaDate = Date.from(LocalDate.of(2021, 11, 25).atStartOfDay(ZoneId.systemDefault()).toInstant());
        silla.setDate(sillaDate);
        silla.setCategory(15);
        silla.setIdPost(2);
        silla.setPrice(1000);

        Product sillaDetail = new Product();
        sillaDetail.setProductId(2);
        sillaDetail.setProductName("silla");
        sillaDetail.setBrand("genérica");
        sillaDetail.setColor("negro");
        sillaDetail.setType("de oficina");
        silla.setDetail(sillaDetail);

        return silla;
    }

    public static Post getComputadora() {
        Post computadora = new Post();

        computadora.setUserId(3);
        Date computadoraDate = Date.from(LocalDate.of(2021, 11, 27).atStartOfDay(ZoneId.systemDefault()).toInstant());
        computadora.setDate(computadoraDate);
        computadora.setCategory(17);
        computadora.setIdPost(3);
        computadora.setPrice(10000);

        Product computadoraDetail = new Product();
        computadoraDetail.setProductId(3);
        computadoraDetail.setProductName("computadora");
        computadoraDetail.setBrand("genérica");
        computadoraDetail.setColor("azul");
        computadoraDetail.setType("gamer");
        computadora.setDetail(computadoraDetail);

        return computadora;
    }


    public static List<PostDTO> getUnsortedPostDTOList() {

        List<Post> posts = List.of(getZapatillas(), getSilla(), getComputadora());

        return posts.stream().map(u -> mapper.map(u, PostDTO.class)).collect(Collectors.toList());
    }

    public static List<Post> getUnsortedPostList() {

        return getUnsortedPostDTOList().stream().map(u -> mapper.map(u, Post.class)).collect(Collectors.toList());
    }

    public static List<Post> getOldPostList() {
        List<Post> postList = getUnsortedPostList();
        for (Post p : postList) {
            p.setDate(threeWeeksAgo());
        }

        return postList;
    }

    public static List<Post> getRecentPostList() {

        Date now = new Date();

        List<Post> postList = getUnsortedPostList();
        for (Post p : postList) {
            p.setDate(now);
        }

        return postList;
    }

    public static List<Post> getPostListWithOneRecentPost() {

        Date now = new Date();

        List<Post> postList = getUnsortedPostList();

        postList.get(0).setDate(now);
        postList.get(1).setDate(threeWeeksAgo());
        postList.get(2).setDate(threeWeeksAgo());

        return postList;
    }

    public static Date threeWeeksAgo() {

        return java.sql.Date.from(LocalDate.now()
                .minusDays(15)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());
    }
}

