package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.mapper.IMapper;
import com.bootcamp.socialmeli.mapper.Mapper;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.repository.IProductRepository;
import com.bootcamp.socialmeli.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
                LocalDate.of(2020, 2,1 ),
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
                LocalDate.of(2020, 2,1 ),
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
}