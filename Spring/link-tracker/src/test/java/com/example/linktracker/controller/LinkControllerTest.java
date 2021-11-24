package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.dto.LinkIdDTO;
import com.example.linktracker.dto.LinkUrlPassDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.mapper.LinkMapper;
import com.example.linktracker.service.LinkService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LinkControllerTest {

    @Mock
    private LinkService mockLinkService;

    @InjectMocks
    private LinkController mockLinkController;

    private static LinkUrlPassDTO postDto;

    @BeforeAll
    static void setUp() {
        readPostJson();
    }

    @Test
    void givenPostJson_whenGuardar_thenCreated() {
        LinkIdDTO dto = new LinkIdDTO();
        dto.setLinkId(1);
        Link link = LinkMapper.urlDtoToLink(postDto);

        when(mockLinkService.guardar(link)).thenReturn(dto);

        ResponseEntity<LinkIdDTO> response = mockLinkController.crear(postDto);
        verify(mockLinkService, atLeast(1)).guardar(link);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), dto);
    }

    @Test
    void givenCorrectIdPass_whenRedireccionar_thenOk() {
        int id = 1;
        String pass = "123";

        when(mockLinkService.redireccionar(id, pass)).thenReturn(postDto.getUrl());

        RedirectView redirectViewResponse = mockLinkController.redireccionar(id, pass);
        verify(mockLinkService, atLeast(id)).redireccionar(id, pass);

        assertEquals(redirectViewResponse.getUrl(), "http://" + postDto.getUrl());
    }

    @Test
    void givenCreatedLinkId_whenInvalidar_thenOk() {
        LinkDTO dto = new LinkDTO();
        dto.setLinkId(1);
        dto.setUrl(postDto.getUrl());

        when(mockLinkService.invalidar(dto.getLinkId())).thenReturn(dto);

        ResponseEntity<LinkDTO> response = mockLinkController.invalidar(dto.getLinkId());
        verify(mockLinkService, atLeast(1)).invalidar(dto.getLinkId());

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), dto);
    }

    @Test
    void givenNotCreatedLinkId_whenInvalidar_thenBadRequest() {
        int notCreatedLinkId = 2;

        when(mockLinkService.invalidar(notCreatedLinkId)).thenReturn(null);

        ResponseEntity<LinkDTO> response = mockLinkController.invalidar(notCreatedLinkId);
        verify(mockLinkService, atLeast(1)).invalidar(notCreatedLinkId);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    private static void readPostJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:link_post.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<LinkUrlPassDTO> typeRef = new TypeReference<>() {};

        try {
            postDto = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}