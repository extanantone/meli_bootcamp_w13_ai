package com.example.blog.service;

import com.example.blog.dto.LinkDto;
import com.example.blog.model.Link;
import org.springframework.http.ResponseEntity;

public interface ILinkService {
    LinkDto crearLink(String link, String contrasena );
    String redireccionar(int id);
    int estadistica(int id);

}
