package com.example.socialmeli.utils;

import com.example.socialmeli.dto.UserDTO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Sorter getInstance(String sorter)  {

        if( sorter != null ) {
            if( sorter.equals("name_asc"))
                return new AlphaAscSorter();
            if( sorter.equals("name_desc"))
                return new AlphaDescSorter();
            if( sorter.equals("date_desc"))
                return new DateDescSorter();
            if( sorter.equals("date_asc"))
                return new DateAscSorter();
        }

        return (a, b) -> 0; // all is equal

    }

}
