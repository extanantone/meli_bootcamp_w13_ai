package com.example.socialmeli;

import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

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
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/usersSocialMeli.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static void restoreUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/usersSocialMeli.json"));
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

}

