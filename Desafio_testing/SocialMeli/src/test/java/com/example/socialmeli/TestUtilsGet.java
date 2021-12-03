package com.example.socialmeli;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.ProductDTO;
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

    public static User getBarbara() {
        User barbaraUser = new User();
        barbaraUser.setUserId(602);
        barbaraUser.setUserName("Barbara");
        barbaraUser.setFollowersId(new ArrayList<>());
        return barbaraUser;
    }
    public static User getJuan() {
        User JuanUser = new User();
        JuanUser.setUserId(612);
        JuanUser.setUserName("Juan");
        JuanUser.setFollowersId(new ArrayList<>());
        return JuanUser;
    }
    public static User getManuel() {
        User manuelUser = new User();
        manuelUser.setUserId(62);
        manuelUser.setUserName("Manuel");
        manuelUser.setFollowersId(new ArrayList<>());
        return manuelUser;
    }

    public static User getUser1() {
        User getUser1 = new User();
        getUser1.setUserId(1);
        getUser1.setUserName("Marco");
        getUser1.setFollowersId(Collections.emptyList());
        return getUser1;
    }

    public static User getUser2() {
        User getUser2 = new User();
        getUser2.setUserId(2);
        getUser2.setUserName("Aylen");
        getUser2.setFollowersId(Collections.emptyList());
        return getUser2;
    }

    public static User getUser3() {
        User getUser3 = new User();
        getUser3.setUserId(3);
        getUser3.setUserName("Jose");
        getUser3.setFollowersId(Collections.emptyList());
        return getUser3;
    }

    public static User getUser80() {
        User user80 = new User();
        user80.setUserId(80);
        user80.setUserName("Usuario N80");
        user80.setFollowersId(Collections.emptyList());
        return user80;
    }
    public static User getUser81() {
        User user81 = new User();
        user81.setUserId(80);
        user81.setUserName("Usuario N81");
        user81.setFollowersId(Collections.emptyList());
        return user81;
    }
    public static User getUser82() {
        User user82 = new User();
        user82.setUserId(80);
        user82.setUserName("Usuario N82");
        user82.setFollowersId(Collections.emptyList());
        return user82;
    }
    public static User getUser83() {
        User user83 = new User();
        user83.setUserId(80);
        user83.setUserName("Usuario N83");
        user83.setFollowersId(Collections.emptyList());
        return user83;
    }





        public static List<UserDTO> getUnsortedUserDTOList() {
        List<User> users = List.of(getUser1(), getUser2(), getUser3());
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

    public static Post getSilla() {
        Post silla = new Post();

        silla.setUserId(81);
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


    public static PostDTO getMesa() {
        PostDTO mesa = new PostDTO();

        mesa.setUserId(81);
        Date mesaDate = Date.from(LocalDate.of(2021, 12, 01).atStartOfDay(ZoneId.systemDefault()).toInstant());
        mesa.setDate(mesaDate);
        mesa.setCategory(17);
        mesa.setIdPost(100);
        mesa.setPrice(2500);

        ProductDTO mesaDetail = new ProductDTO();
        mesaDetail.setProductId(3);
        mesaDetail.setProductName("mesa");
        mesaDetail.setBrand("Muebles S.A.");
        mesaDetail.setColor("Black");
        mesaDetail.setType("Stantard");
        mesa.setDetail(mesaDetail);

        return mesa;
    }
    public static Post getTaza() {
        Post taza = new Post();

        taza.setUserId(82);
        Date tazaDate = Date.from(LocalDate.of(2021, 11, 20).atStartOfDay(ZoneId.systemDefault()).toInstant());
        taza.setDate(tazaDate);
        taza.setCategory(17);
        taza.setIdPost(30);
        taza.setPrice(350);

        Product tazaDetail = new Product();
        tazaDetail.setProductId(3);
        tazaDetail.setProductName("taza");
        tazaDetail.setBrand("Coders");
        tazaDetail.setColor("Black");
        tazaDetail.setType("Nerd");
        tazaDetail.setNotes("Mugs for geeks");
        taza.setDetail(tazaDetail);

        return taza;
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

