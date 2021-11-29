package com.bootcamp.SocialMeli.unit.service.product;

import com.bootcamp.SocialMeli.dto.product.PostDTO;
import com.bootcamp.SocialMeli.dto.product.ProductFollowedListDTO;
import com.bootcamp.SocialMeli.exception.InvalidOrderException;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import com.bootcamp.SocialMeli.service.product.ProductService;
import com.google.common.collect.Comparators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bootcamp.SocialMeli.util.TestUtilsGenerator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    ISocialMeliRepository mockRepository;

    @InjectMocks
    ProductService productService;

    private User mateo;

    private static final String ORDER_DATE_ASC = "date_asc";
    private static final String ORDER_DATE_DESC = "date_desc";
    private static final String ORDER_NOT_FOUND = "not_found";
    private static final int TWO_WEEKS = -2;

    @BeforeEach
    void initializeUser() {
        mateo = new User(1, "Mateo");
    }

    // T-0005
    @Test
    void verifyDateOrderingTypeOfFollowedListExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act & Assert
        assertAll(
                () -> assertDoesNotThrow(() -> productService.followedList(mateo.getUserId(), ORDER_DATE_ASC)),
                () -> assertDoesNotThrow(() -> productService.followedList(mateo.getUserId(), ORDER_DATE_DESC)));
        verify(mockRepository, times(2)).findUser(anyInt());
    }

    // T-0005
    @Test
    void verifyDateOrderingTypeOfFollowedListNotExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act & Assert
        assertThrows(InvalidOrderException.class, () -> productService.followedList(mateo.getUserId(), ORDER_NOT_FOUND));
        verify(mockRepository, times(1)).findUser(anyInt());
    }

    // T-0006
    @Test
    void verifyAscendingOrderingByDateOfFollowedList() {
        // Arrange
        addFollowedWithPosts(mateo);
        Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate);

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act
        ProductFollowedListDTO postListDTO = productService.followedList(mateo.getUserId(), ORDER_DATE_ASC);

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        assertTrue(Comparators.isInOrder(postListDTO.getPosts(), comparator));
    }

    // T-0006
    @Test
    void verifyDescendingOrderingByDateOfFollowedList() {
        // Arrange
        addFollowedWithPosts(mateo);
        Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate);

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act
        ProductFollowedListDTO postListDTO = productService.followedList(mateo.getUserId(), ORDER_DATE_DESC);

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        assertFalse(Comparators.isInOrder(postListDTO.getPosts(), comparator));
    }

    // T-0008
    @Test
    void verifyPostPublicationDateOfFollowedList() {
        // Arrange
        addFollowedWithPosts(mateo);

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act
        ProductFollowedListDTO postListDTO = productService.followedList(mateo.getUserId(), ORDER_DATE_DESC);

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        postListDTO.getPosts().forEach(post -> {
            assertTrue(post.getDate().isBefore(LocalDate.now().minusWeeks(TWO_WEEKS)));
        });
    }
}