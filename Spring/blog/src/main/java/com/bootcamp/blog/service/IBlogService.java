package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogService {

    Integer crearEntrada(EntradaBlogDTO nuevaEntrada);

    EntradaBlog getEntrada(Integer id);

    List<EntradaBlog> getAllEntradas();
}
