package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    void insertarEntrada(EntradaBlog nuevaEntrada);

    EntradaBlog buscarEntrada(Integer id);

    List<EntradaBlog> getAllEntradas();
}
