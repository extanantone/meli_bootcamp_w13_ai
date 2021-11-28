package com.example.socialmeli;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class TestUtilsPreload {
    public static void restoreUsersFile() throws JsonProcessingException {
        TestUtilsFileHandling.writeToUsersFile(
                List.of(
                        TestUtilsGet.getManuel(),
                        TestUtilsGet.getAzul(),
                        TestUtilsGet.getFede()
                ));
    }
}
