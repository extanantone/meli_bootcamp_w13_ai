package com.meliBoot.manejoDeExcepciones.Blog.services;

import com.meliBoot.manejoDeExcepciones.Blog.dtos.EntradaBlogDto;

import java.util.List;

public interface EntradaBlogService {
    List<EntradaBlogDto> getEntradas();
}
