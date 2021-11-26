package com.example.socialmeli.unit.util;

import com.example.socialmeli.exceptions.InvalidSortingCriteriaException;
import com.example.socialmeli.utils.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SorterFactoryTests {

    @Test
    public void getAlphaAscSorter() throws InvalidSortingCriteriaException {
        Sorter alphaAsc = MiFactory.getInstance("name_asc");

        assertEquals(alphaAsc.getClass(), AlphaAscSorter.class);
    }

    @Test
    public void getAlphaDescSorter() throws InvalidSortingCriteriaException {
        Sorter alphaAsc = MiFactory.getInstance("name_desc");

        assertEquals(alphaAsc.getClass(), AlphaDescSorter.class);
    }

    @Test
    public void getDateAscSorter() throws InvalidSortingCriteriaException {
        Sorter alphaAsc = MiFactory.getInstance("date_asc");

        assertEquals(alphaAsc.getClass(), DateAscSorter.class);
    }

    @Test
    public void getDateDescSorter() throws InvalidSortingCriteriaException {
        Sorter alphaAsc = MiFactory.getInstance("date_desc");

        assertEquals(alphaAsc.getClass(), DateDescSorter.class);
    }

    @Test
    public void TryToGetInvalidSorterAndThrow() {

        Throwable exception = assertThrows(InvalidSortingCriteriaException.class, () -> MiFactory.getInstance("?"));
    }


}
