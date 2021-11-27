package com.example.socialmeli;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class TestUtilsGenerator {

    public static User getManuel() {
        User manuel = new User();
        manuel.setUserId(1);
        manuel.setUserName("Manuel");
        return manuel;
    }
    public static User getAzul() {
        User azul = new User();
        azul.setUserId(2);
        azul.setUserName("Azul");
        return azul;
    }

    public static User getFede() {
        User fede = new User();
        fede.setUserId(2);
        fede.setUserName("Fede");
        return fede;
    }


    public static List<UserDTO> getUnsortedUserDTOList() {
        ModelMapper mapper = new ModelMapper();
        List<User> users = List.of(getManuel(), getAzul(), getFede());
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
        ModelMapper mapper = new ModelMapper();

        List<Post> posts = List.of(getZapatillas(), getSilla(), getComputadora());

        return posts.stream().map(u -> mapper.map(u, PostDTO.class)).collect(Collectors.toList());
    }

    public static List<Post> getUnsortedPostList() {
        ModelMapper mapper = new ModelMapper();

        return getUnsortedPostDTOList().stream().map(u -> mapper.map(u, Post.class)).collect(Collectors.toList());
    }

    public static List<Post> getOldPostList() {
        List<Post> postList = getUnsortedPostList();
        for (Post p:postList) {
            p.setDate(threeWeeksAgo());
        }

        return postList;
    }

    public static List<Post> getRecentPostList() {

        Date now = new Date();

        List<Post> postList = getUnsortedPostList();
        for (Post p:postList) {
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

    public static void emptyUsersFile() {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/main/resources/usersSocialMeli.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static void restoreUsersFile() {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/main/resources/usersSocialMeli.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[\n" +
                "  {\n" +
                "    \"userName\": \"Leon Comprador\",\n" +
                "    \"userId\": 1,\n" +
                "    \"followersId\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"Juan Comprador\",\n" +
                "    \"userId\": 2,\n" +
                "    \"followersId\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"Manuel Vendedor\",\n" +
                "    \"userId\": 3,\n" +
                "    \"followersId\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"Pedro Vendedor\",\n" +
                "    \"userId\": 4,\n" +
                "    \"followersId\": []\n" +
                "  }\n" +
                "]");
        writer.close();
    }

    public static void emptyPostsFile() {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/main/resources/postsSocialMeli.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

}

