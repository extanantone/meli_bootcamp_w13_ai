package com.example.socialmeli.utils;

import com.example.socialmeli.exceptions.InvalidSortingCriteriaException;

public class MiFactory {

    public static Sorter getInstance(String sorter) throws InvalidSortingCriteriaException {

        if( sorter.equals("name_asc"))
            return new AlphaAscSorter();
        if( sorter.equals("name_desc"))
            return new AlphaDescSorter();
        if( sorter.equals("date_desc"))
            return new DateDescSorter();
        if( sorter.equals("date_asc"))
            return new DateAscSorter();
        //return (a, b) -> 0; // all is equal
        throw new InvalidSortingCriteriaException(sorter);


    }

}
