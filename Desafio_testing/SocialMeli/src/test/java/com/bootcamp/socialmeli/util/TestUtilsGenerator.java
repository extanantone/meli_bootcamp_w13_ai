package com.bootcamp.socialmeli.util;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.ProductDTO;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static User getVanillaUser(long id, String username) {
        return new User(
                id,
                username,
                "test@test.com",
                "pass",
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    public static List<Object> getPostProduct(long postProductId, long userId, String productName, double discount, boolean isRecent) {
        List<Object> postProduct = new ArrayList<>();
        boolean hasPromo = false;
        if (discount > 0.0) {
            hasPromo = true;
        }
        LocalDate date = LocalDate.now().minusDays(5);
        if (!isRecent) {
            date = date.minusDays(20);
        }
        postProduct.add(new Post(
                postProductId,
                date,
                1,
                100.0,
                hasPromo,
                0.0,
                userId,
                postProductId
        ));
        postProduct.add(new Product(
                postProductId,
                productName,
                "type",
                "brand",
                "color",
                "notes"
        ));
        return postProduct;
    }

    public static PostDTO getPostDTOWithCustomDate(long id, LocalDate date) {
        ProductDTO detail = new ProductDTO(
                id,
                "productName",
                "type",
                "brand",
                "color",
                "notes"
        );
        return new PostDTO(id, date, 1, 100.0, 1L, detail);
    }
}
