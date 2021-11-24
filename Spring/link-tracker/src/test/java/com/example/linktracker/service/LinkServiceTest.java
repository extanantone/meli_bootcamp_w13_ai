package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.dto.LinkIdDTO;
import com.example.linktracker.dto.LinkUrlPassDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.mapper.LinkMapper;
import com.example.linktracker.repository.LinkRepositorio;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@ExtendWith({MockitoExtension.class})
class LinkServiceTest {

    @Mock
    private LinkRepositorio mockLinkRepositorio;

    @InjectMocks
    private LinkService mockLinkService;

    @Test
    void givenCorrectDto_whenGuardar_thenCreated() {
        LinkUrlPassDTO dto = new LinkUrlPassDTO();
        dto.setUrl("www.google.com");
        dto.setPassword("123");

        Link link = LinkMapper.urlDtoToLink(dto);
        when(mockLinkRepositorio.guardar(link)).thenReturn(link);

        LinkIdDTO response = mockLinkService.guardar(link);
        verify(mockLinkRepositorio, atLeast(1)).guardar(link);

        assertEquals(response.getLinkId(), LinkMapper.linkToIdDTO(link).getLinkId());
    }

    @Test
    void givenCorrectIdPass_whenRedireccionar_thenOk() {
        Link link = new Link();
        link.setLinkId(1);
        link.setUrl("www.google.com");
        link.setPassword("123");

        when(mockLinkRepositorio.obtenerPorId(link.getLinkId())).thenReturn(link);

        String response = mockLinkService.redireccionar(link.getLinkId(), link.getPassword());
        verify(mockLinkRepositorio).obtenerPorId(link.getLinkId());

        assertEquals(response, link.getUrl());
    }

    @Test
    void givenIncorrectIdPass_whenRedireccionar_thenEmptyString() {
        int incorrectId = 2;
        String incorrectPass = "123";

        when(mockLinkRepositorio.obtenerPorId(incorrectId)).thenReturn(null);

        String response = mockLinkService.redireccionar(incorrectId, incorrectPass);
        verify(mockLinkRepositorio).obtenerPorId(incorrectId);

        assertEquals(response, Strings.EMPTY);
    }

    @Test
    void givenCreatedLinkId_whenInvalidar_thenChangeStatus() {
        Link link = new Link();
        link.setLinkId(1);
        link.setEsValido(true);

        when(mockLinkRepositorio.obtenerPorId(link.getLinkId())).thenReturn(link);
        when(mockLinkRepositorio.guardar(link)).thenReturn(link);

        LinkDTO response = mockLinkService.invalidar(link.getLinkId());
        verify(mockLinkRepositorio).obtenerPorId(link.getLinkId());
        verify(mockLinkRepositorio).guardar(link);

        assertEquals(response.getLinkId(), link.getLinkId());
        assertFalse(link.isEsValido());
    }

    @Test
    void givenNotCreatedLinkId_whenInvalidar_thenNull() {
        int invalidId = 2;

        when(mockLinkRepositorio.obtenerPorId(invalidId)).thenReturn(null);

        LinkDTO response = mockLinkService.invalidar(invalidId);
        verify(mockLinkRepositorio).obtenerPorId(invalidId);
        verify(mockLinkRepositorio, never()).guardar(new Link());

        assertNull(response);
    }
}