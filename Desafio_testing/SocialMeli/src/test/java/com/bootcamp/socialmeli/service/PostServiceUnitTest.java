package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.mapper.Mapper;
import com.bootcamp.socialmeli.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceUnitTest {


    Mapper mapper;

    @InjectMocks
    PostService service;

    @BeforeEach
    void setUp() {
        mapper = new Mapper(null);
    }

    @Test
    public void whenInvalidOrderThrowException() {
        LocalDate[] dates = {
                LocalDate.of(2020, 2, 1),
                LocalDate.of(2020, 3, 1),
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 4, 1)
        };
        List<PostDTO> posts = new ArrayList<>();
        for (int i=0; i<dates.length; i++) {
            posts.add(TestUtilsGenerator.getPostDTOWithCustomDate(i, dates[i]));
        }
        String order = "invalid";

        // This test won't pass
        assertThrows(RuntimeException.class, () -> {
            service.orderPostsByDate(posts, order);
        });
    }

    @Test
    public void whenValidAscOrderSortPosts() {
        LocalDate[] dates = {
                LocalDate.of(2020, 2, 1),
                LocalDate.of(2020, 3, 1),
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 4, 1)
        };
        List<PostDTO> posts = new ArrayList<>();
        for (int i=0; i<dates.length; i++) {
            posts.add(TestUtilsGenerator.getPostDTOWithCustomDate(i, dates[i]));
        }
        List<LocalDate> expectedSortedDates = Arrays.stream(dates).sorted().collect(Collectors.toList());
        String order = "asc";

        List<LocalDate> actualSortedDates = service.orderPostsByDate(posts, order).stream()
                .map(u -> u.getDate()).collect(Collectors.toList());

        assertAll(() -> {
            for (int i=0; i<dates.length; i++) {
                assertEquals(expectedSortedDates.get(i), actualSortedDates.get(i));
            }
        });
    }

    @Test
    public void checkLast2WeekPosts() {
        LocalDate now = LocalDate.now();
        LocalDate[] dates = {
                now.minusDays(5),
                now.minusDays(10),
                now.minusDays(30),
                now.minusDays(500),
        };
        List<PostDTO> posts = new ArrayList<>();
        for (int i=0; i<4; i++) {
            posts.add(TestUtilsGenerator.getPostDTOWithCustomDate(i, dates[i]));
        }
        int weeks = 2;
        LocalDate[] expectedDates = {dates[0], dates[1]};

        List<LocalDate> actualDates = service.getLatestPosts(posts, weeks).stream().map(
                PostDTO::getDate
        ).collect(Collectors.toList());

        assertAll(
                () -> assertEquals(expectedDates.length, actualDates.size()),
                () -> {
                    for (LocalDate expectedDate : expectedDates) {
                        assertTrue(actualDates.contains(expectedDate));
                    }
                }
        );

    }
}