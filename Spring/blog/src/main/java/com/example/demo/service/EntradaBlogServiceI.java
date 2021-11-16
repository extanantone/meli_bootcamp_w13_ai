package com.example.demo.service;

import com.example.demo.dtos.EntradaBlogDTO;
import com.example.demo.exception.NotFoundException;

import java.util.List;

public interface EntradaBlogServiceI {

    EntradaBlogDTO crearNuevoBLog(EntradaBlogDTO entradaBlogDTO);

    EntradaBlogDTO getBlog(Long id);

    List<EntradaBlogDTO> getBlogs();
}
