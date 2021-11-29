package meli.bootcamp.socialmeli.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.mapper.UserMapper;
import meli.bootcamp.socialmeli.mapper.UserMapperImpl;
import meli.bootcamp.socialmeli.model.*;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestUtils {
    private static String SCOPE;
    private static ObjectWriter writer;

    @Autowired
    UserMapper userMapper;

    public static void emptyObjectFile(String fileName){
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + "test" + "/resources/" + fileName + ".json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static ProductsPostDTO getPostWithOneProductToUser1(int id) {
        LocalDate productDate = LocalDate.of(2020, 12, 1);

        ProductsDTO newProduct= new ProductsDTO(
                id,
                "Arroz",
                "Comida",
                "ROA",
                "Blanco",
                "Alta pureza"
        );

        return new ProductsPostDTO(
                1,
                1,
                "2020-12-01",
                newProduct,
                "Comida",
                1500.0
        );
    }

    public static User createNewUserWithName(String name) {
        Random userId= new Random();
        int a = 20;
        return new User(
                userId.nextInt(4200-2100)+2100,
                name + "PErez21",
                name,
                "Perez",
                userId.nextInt(99-10)
        );
    }

    public static PromoPost getPromoPostWithRandomPostIDForAnyUser() {
        LocalDate productDate = LocalDate.of(2020, 12, 1);
        Random userId= new Random();

        Product newProduct= new Product(
                userId.nextInt(5000-0),
                "Arroz",
                "Comida",
                "ROA",
                "Blanco",
                "Alta pureza"
        );

        return new PromoPost(
                userId.nextInt(2100-1)+1,
                1,
                productDate,
                newProduct,
                "Comida",
                1500.0,
                true,
                0.5
        );
    }

    public static Post getPostWithRandomPostIDForAnyUser() {
        LocalDate productDate = LocalDate.of(2020, 12, 1);
        Random userId= new Random();

        Product newProduct= new Product(
                userId.nextInt(5000-0),
                "Arroz",
                "Comida",
                "ROA",
                "Blanco",
                "Alta pureza"
        );

        return new Post(
                userId.nextInt(2100-1)+1,
                1,
                productDate,
                newProduct,
                "Comida",
                1500.0
        );
    }

    public static FollowedListDTO getNFollowedUserListToDTO(User user, int followersCant){
        List<UserDTO> list= new ArrayList<>();
        for (int i = 0; i < followersCant; i++) {
            Random random = new Random();
            final StringBuilder sb = new StringBuilder();
            for (int o = 0; o < 8; o++) {
                sb.append((char) (random.nextInt(26) + 'A'));
            }

            User tempUser= TestUtils.createNewUserWithName(sb.toString());
            list.add(new UserDTO(
                    tempUser.getUserId(),
                    tempUser.getUserName()
            ));
        }
        return new FollowedListDTO(
                user.getUserId(),
                user.getUserName(),
                list);
    }

    public static FollowersListDTO getNFollowersUserListToDTO(User user, int followersCant){
        List<UserDTO> list= new ArrayList<>();
        for (int i = 0; i < followersCant; i++) {
            Random random = new Random();
            final StringBuilder sb = new StringBuilder();
            for (int o = 0; o < 8; o++) {
                sb.append((char) (random.nextInt(26) + 'A'));
            }

            User tempUser= TestUtils.createNewUserWithName(sb.toString());
            list.add(new UserDTO(
                    tempUser.getUserId(),
                    tempUser.getUserName()
            ));
        }
        return new FollowersListDTO(
                user.getUserId(),
                user.getUserName(),
                list);
    }

    public static List<UserFollow> setUserFollowerRelationsByFollowedListDTO(FollowedListDTO followedListDTO){
        List<UserFollow> userFollowsList= new ArrayList<>();
        for (UserDTO user :
                followedListDTO.getFollowed()) {
            userFollowsList.add(new UserFollow(
                    followedListDTO.getUserId(),
                    user.getUserID()
            ));
        }
        return userFollowsList;
    }

    public static void appendNewObject(Object objectDTO, String fileName) {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter methodWriter = null;

        try {
            String content = Files.readString(new File("./src/" + SCOPE + "/resources/" + fileName + ".json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            methodWriter = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/" + fileName + ".json"));

            try {
                String studentAsString = writer.writeValueAsString(objectDTO);
                methodWriter.print(content.substring(0, content.length()-1));
                if (content.length()>2) methodWriter.print(", ");
                methodWriter.print(studentAsString);
                methodWriter.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        methodWriter.close();
    }

    public static String getUserNameFromList(FollowedListDTO followedListDTO, UserFollow userID) {
        return followedListDTO.getFollowed()
                .stream()
                .filter((userDTO -> userDTO.getUserID()==userID.getFollowedUser()))
                .findFirst()
                .get().getUserName();
    }

    public static List<Post> setTwoProductsForAllFollowedUser(FollowedListDTO followedListDTO) {
        List<Post> responseList= new ArrayList<>();
        Random random = new Random();
        Product tempProduct= new Product(
                random.nextInt(1000),
                "Celular Samsung",
                "Celular",
                "Samsung",
                "Negro",
                "Esta rayado por detras"
        );

        LocalDate start = LocalDate.of(2021, Month.OCTOBER, 1);
        LocalDate end = LocalDate.now();

        for (UserDTO user :
                followedListDTO.getFollowed()) {
            LocalDate randomDate = TestUtils.between(start, end);
            responseList.add(new Post(
                    user.getUserID(), /////
                    random.nextInt(3100),
                    randomDate,
                    tempProduct,
                    "Tecnologia",
                    50000.0
            ));

            LocalDate randomDate2 = TestUtils.between(start, end);
            responseList.add(new Post(
                    user.getUserID(), /////
                    random.nextInt(3100),
                    randomDate2,
                    tempProduct,
                    "Tecnologia",
                    54300.0
            ));
        }

        return responseList;
    }

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public static List<UserFollow> setUserFollowerRelationsByFollowersListDTO(FollowersListDTO followersListDTO) {
        List<UserFollow> userFollowsList= new ArrayList<>();
        for (UserDTO user :
                followersListDTO.getFollowers()) {
            userFollowsList.add(
                    new UserFollow(
                            user.getUserID(),
                            followersListDTO.getUserId()
                    )
            );
        }
        return userFollowsList;
    }
}

