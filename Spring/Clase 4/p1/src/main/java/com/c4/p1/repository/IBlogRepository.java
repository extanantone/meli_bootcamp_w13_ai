package com.c4.p1.repository;

import com.c4.p1.exceptions.AlreadyExistsException;
import com.c4.p1.exceptions.NotFoundException;
import com.c4.p1.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    List<EntradaBlog> recuperarListadoEntradas();
    EntradaBlog recuperarEntrada(Integer id) throws NotFoundException;
    void insertarEntrada(EntradaBlog entradaBlog) throws AlreadyExistsException;
}
