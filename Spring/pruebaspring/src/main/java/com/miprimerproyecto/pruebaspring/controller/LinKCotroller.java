package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.model.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Link")
public class LinKCotroller {


    @PostMapping()
    public ResponseEntity<?> setLink(@RequestBody LinkSetDTO){


    }
}
