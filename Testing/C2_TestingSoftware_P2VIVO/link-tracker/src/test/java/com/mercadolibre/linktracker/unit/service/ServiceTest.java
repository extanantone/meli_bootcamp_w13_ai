package com.mercadolibre.linktracker.unit.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import com.mercadolibre.linktracker.service.LinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    LinkRepository mockLinkRepository;

    @InjectMocks
    LinkServiceImpl linkServiceImpl;

    //public LinkDTO create(LinkDTO link) {
    @Test
    public void testCreateWithCorrectLink(){
        //Ar
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setLinkId(0);


        //Ac
        when(mockLinkRepository.save(linkDTO)).thenReturn(linkDTO);

        LinkDTO linkDTOCurrent = linkServiceImpl.create(linkDTO);

        //As
        Assertions.assertEquals(linkDTO.getLinkId(),linkDTOCurrent.getLinkId());
        verify(mockLinkRepository,atLeast(1)).save(linkDTO);
    }

    //public LinkDTO redirect(Integer linkId) {
    @Test
    public void testRedirectWithCorrectLinkId(){
        //Ar
        Integer linkId = 0;
        Integer countOriginal = 0;
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setLinkId(1);
        linkDTO.setCount(countOriginal);
        linkDTO.setLink("https//www.google.com");
        linkDTO.setPassword("1234");

        //Ac
        when(mockLinkRepository.findLinkByLinkId(linkId)).thenReturn(java.util.Optional.of(linkDTO));
        LinkDTO currentLinkDTO =  linkServiceImpl.redirect(linkId);
        //As
        Assertions.assertEquals(linkDTO.getLinkId(),currentLinkDTO.getLinkId());
        Assertions.assertTrue(currentLinkDTO.getCount()>countOriginal);
        
        verify(mockLinkRepository,atLeast(1)).findLinkByLinkId(linkId);
    }

    @Test
    public void testRedirectWithIncorrectLinkId(){
        //Ar
        Integer linkId = 0;


        //Ac
        when(mockLinkRepository.findLinkByLinkId(linkId)).thenReturn(java.util.Optional.empty());
        LinkDTO currentLinkDTO =  linkServiceImpl.redirect(linkId);
        //As
        Assertions.assertEquals(currentLinkDTO, null);


        verify(mockLinkRepository,atLeast(1)).findLinkByLinkId(linkId);
    }
}
