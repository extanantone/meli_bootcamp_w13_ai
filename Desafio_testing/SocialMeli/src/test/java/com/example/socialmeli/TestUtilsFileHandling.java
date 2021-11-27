package com.example.socialmeli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

public class TestUtilsFileHandling {
    private static ObjectWriter objectWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer().withDefaultPrettyPrinter();

    public static String getScope() {
        //TODO: aplicar singleton para scope y writer?

        Properties properties = new Properties();
        String SCOPE = "";

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SCOPE;
    }

    public static PrintWriter getUsersFileWriter() {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + getScope() + "/resources/usersSocialMeli.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return writer;
    }


    public static void emptyUsersFile() {

        PrintWriter writer = getUsersFileWriter();

        writer.print("[]");
        writer.close();
    }

    public static void restoreUsersFile() throws JsonProcessingException {
        writeToUsersFile(
                List.of(
                        TestUtilsGet.getManuel(),
                        TestUtilsGet.getAzul(),
                        TestUtilsGet.getFede()
                ));
    }

    public static void writeToUsersFile(Object valueToWrite) throws JsonProcessingException {

        PrintWriter writer = getUsersFileWriter();

        try {
            String valueAsString = objectWriter.writeValueAsString(valueToWrite);
            writer.print(valueAsString);
            writer.close();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
