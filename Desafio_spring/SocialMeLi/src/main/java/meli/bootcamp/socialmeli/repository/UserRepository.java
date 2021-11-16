package meli.bootcamp.socialmeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.socialmeli.exceptions.ControllerAdviceExceptions;
import meli.bootcamp.socialmeli.exceptions.UserNotExistException;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    private final List<User> mListUsers;

    public UserRepository(){
        this.mListUsers= loadJSON();
    }

    @Override
    public User findUserById(int userID) {
        ControllerAdviceExceptions ex= new ControllerAdviceExceptions();
        ex.setUser_id(userID);
        return mListUsers.stream()
                .filter(user -> user.getUserId() == userID)
                .findFirst()
                .orElseThrow(UserNotExistException::new);
    }

    private List<User> loadJSON(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:datausers.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> usersDTOS = null;
        try {
            usersDTOS = objectMapper.readValue(file, typeRef);
            System.out.println("Lista de ususarios agregada");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersDTOS;
    }

    @Override
    public String getUserNameById(int userID) {
        return mListUsers.stream()
                .filter(user -> user.getUserId() == userID)
                .findFirst()
                .orElseThrow(UserNotExistException::new)
                .getUserName();
    }

    @Override
    public List<User> findAll() {
        return mListUsers;
    }

    @Override
    public User updateUserById(int userID) {
        return null;
    }

    @Override
    public void deleteUser(int userID) {

    }
}
