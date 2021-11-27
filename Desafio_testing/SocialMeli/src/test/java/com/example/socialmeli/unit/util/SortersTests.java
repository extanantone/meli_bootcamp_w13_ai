package com.example.socialmeli.unit.util;

import com.example.socialmeli.TestUtilsGet;
import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.utils.*;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortersTests {
    @Test
    public void sortAlphaAsc(){
        Sorter alphaAsc = new AlphaAscSorter();

        List<UserDTO> unsortedList = TestUtilsGet.getUnsortedUserDTOList();
        //manuel, azul y fede

        List<UserDTO> sortedList = unsortedList.stream().sorted( (u, b) -> alphaAsc.sort(u,b) ).collect(Collectors.toList());

        assertAll(
                () -> assertEquals(sortedList.get(0).getUserName(), "Azul"),
                () -> assertEquals(sortedList.get(1).getUserName(), "Fede"),
                () -> assertEquals(sortedList.get(2).getUserName(), "Manuel")
        );
    }

    @Test
    public void sortAlphaDesc(){
        Sorter alphaDesc = new AlphaDescSorter();

        List<UserDTO> unsortedList = TestUtilsGet.getUnsortedUserDTOList();
        //manuel, azul y fede

        List<UserDTO> sortedList = unsortedList.stream().sorted( (u, b) -> alphaDesc.sort(u,b) ).collect(Collectors.toList());

        assertAll(
                () -> assertEquals(sortedList.get(0).getUserName(), "Manuel"),
                () -> assertEquals(sortedList.get(1).getUserName(), "Fede"),
                () -> assertEquals(sortedList.get(2).getUserName(), "Azul")
        );
    }

    @Test
    public void sortDateAsc(){
        Sorter dateAsc = new DateAscSorter();

        List<PostDTO> unsortedList = TestUtilsGet.getUnsortedPostDTOList();

        List<PostDTO> sortedList = unsortedList.stream().sorted( (u, b) -> dateAsc.sort(u,b) ).collect(Collectors.toList());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        assertAll(
                () -> assertEquals("25-11-2021", formatter.format(sortedList.get(0).getDate())),
                () -> assertEquals( "26-11-2021", formatter.format(sortedList.get(1).getDate())),
                () -> assertEquals( "27-11-2021", formatter.format(sortedList.get(2).getDate()))
        );
    }

    @Test
    public void sortDateDesc(){
        Sorter dateDesc = new DateDescSorter();

        List<PostDTO> unsortedList = TestUtilsGet.getUnsortedPostDTOList();

        List<PostDTO> sortedList = unsortedList.stream().sorted( (u, b) -> dateDesc.sort(u,b) ).collect(Collectors.toList());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        assertAll(
                () -> assertEquals("27-11-2021", formatter.format(sortedList.get(0).getDate())),
                () -> assertEquals( "26-11-2021", formatter.format(sortedList.get(1).getDate())),
                () -> assertEquals( "25-11-2021", formatter.format(sortedList.get(2).getDate()))
        );
    }
}
