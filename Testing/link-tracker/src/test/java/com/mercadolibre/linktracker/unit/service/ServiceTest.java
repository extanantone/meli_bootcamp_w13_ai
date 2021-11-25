package com.mercadolibre.linktracker.unit.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import com.mercadolibre.linktracker.service.LinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    LinkRepository mockLinkRepository;

    @InjectMocks
    LinkServiceImpl linkServiceImpl;

    private Map<Integer, LinkDTO> database = new HashMap<>();

    @BeforeEach
    public void setUp(){
        LinkDTO link0 = new LinkDTO();
        link0.setLinkId(0);
        LinkDTO link1 = new LinkDTO();
        link1.setLinkId(1);
        database.put(link0.getLinkId(), link0);
        database.put(link1.getLinkId(), link1);
    }

    //public LinkDTO create(LinkDTO link) {
    @Test
    public void testCreateWithCorrectLink(){
        //Arrange
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setLinkId(5);

        //Act
        when(mockLinkRepository.save(linkDTO)).thenReturn(linkDTO);
        LinkDTO linkDTOCurrent = linkServiceImpl.create(linkDTO);

        //Assert
        Assertions.assertEquals(linkDTO.getLinkId(), linkDTOCurrent.getLinkId());
        verify(mockLinkRepository, atLeast(1)).save(linkDTO);
    }

    @Test
    public void testWithExistingLink(){
        //Arrange
        LinkDTO linkDuplicated = new LinkDTO();
        linkDuplicated.setLinkId(0);

        //Act and Assert
        when(mockLinkRepository.save(linkDuplicated)).thenReturn(null);
        Assertions.assertThrows(Exception.class, () -> linkServiceImpl.create(linkDuplicated));
    }

    //public LinkDTO redirect(Integer linkId) {
    @Test
    public void testRedirectWithCorrectLinkId(){
        //Arrange
        Integer id = 0;
        Integer countOriginal = 0;
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setLinkId(id);
        linkDTO.setCount(countOriginal);
        linkDTO.setLink("https://www.google.com/");
        linkDTO.setPassword("1234");

        //Act
        when(mockLinkRepository.findLinkByLinkId(id)).thenReturn(Optional.of(linkDTO));
        LinkDTO currentLinkDTO =  linkServiceImpl.redirect(id);

        //Assert
        Assertions.assertEquals(linkDTO.getLinkId(), currentLinkDTO.getLinkId());
        Assertions.assertTrue(currentLinkDTO.getCount() == countOriginal+1);
        
        verify(mockLinkRepository, atLeast(1)).findLinkByLinkId(id);
    }

    @Test
    public void testRedirectWithNotExistingLinkId(){
        //Arrange
        Integer linkId = 100;

        //Act
        when(mockLinkRepository.findLinkByLinkId(linkId)).thenReturn(Optional.empty());
        LinkDTO currentLinkDTO =  linkServiceImpl.redirect(linkId);

        //Assert
        Assertions.assertNull(currentLinkDTO);
        verify(mockLinkRepository, atLeast(1)).findLinkByLinkId(linkId);
    }

    @Test
    public void testRedirectWithCorrectPassword(){
        //Arrange
        Integer id = 0;
        String passwd = "1234";
        Optional<LinkDTO> linkBuscado = Optional.of(new LinkDTO());
        linkBuscado.get().setLinkId(id);
        linkBuscado.get().setPassword("1234");

        //Act
        when(mockLinkRepository.findLinkByLinkId(id)).thenReturn(linkBuscado);
        LinkDTO linkCurrent = linkServiceImpl.redirect(id, passwd);

        //Assert
        Assertions.assertEquals(0, linkCurrent.getLinkId());
        Assertions.assertEquals("1234", linkCurrent.getPassword());
        verify(mockLinkRepository, atLeastOnce()).findLinkByLinkId(id);
    }

    @Test
    public void testRedirectWithInvalidPassword(){
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void testRedirectWithPasswordAndNotExistingLinkId(){
        //Arrange
        Integer linkId = 100;
        String passwd = "1234";

        //Act
        when(mockLinkRepository.findLinkByLinkId(linkId)).thenReturn(Optional.empty());
        LinkDTO currentLinkDTO =  linkServiceImpl.redirect(linkId, passwd);

        //Assert
        Assertions.assertNull(currentLinkDTO);
        verify(mockLinkRepository, atLeast(1)).findLinkByLinkId(linkId);
    }

    @Test
    public void testGetMetricsWithValidId(){
        //Arrange
        Integer id = 0;
        LinkDTO linkExpected = database.get(0);

        //Act
        when(mockLinkRepository.findLinkByLinkId(id)).thenReturn(Optional.ofNullable(linkExpected));
        LinkDTO linkCurrent = linkServiceImpl.metrics(id);

        //Assert
        Assertions.assertEquals(linkExpected, linkCurrent);
        verify(mockLinkRepository, atLeastOnce()).findLinkByLinkId(id);
    }

    @Test
    public void testGetMetricsWithNotFoundId(){
        //Arrange
        Integer id = 555;

        //Act
        when(mockLinkRepository.findLinkByLinkId(id)).thenReturn(Optional.empty());
        LinkDTO linkCurrent = linkServiceImpl.metrics(id);

        //Assert
        Assertions.assertNull(linkCurrent);
        verify(mockLinkRepository, atLeastOnce()).findLinkByLinkId(id);
    }

    @Test
    public void testInvalidateAnExistingId(){
        //Arrange
        Integer id = 0;
        LinkDTO linkToDelete = new LinkDTO();
        linkToDelete.setLinkId(0);

        //Act
        when(mockLinkRepository.findLinkByLinkId(id)).thenReturn(Optional.of(linkToDelete));
        //when(mockLinkRepository.delete(linkToDelete));
        linkServiceImpl.invalidate(id);

        //Assert

    }

    @Test
    public void testInvalidateANotFoundId(){
        //Arrange

        //Act

        //Assert
    }
}
