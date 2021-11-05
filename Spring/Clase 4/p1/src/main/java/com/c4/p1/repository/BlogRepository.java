package com.c4.p1.repository;

import com.c4.p1.exceptions.AlreadyExistsException;
import com.c4.p1.exceptions.NotFoundException;
import com.c4.p1.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{
    List<EntradaBlog> blogs;

    public BlogRepository(){
        blogs = new ArrayList<>();
    }

    @Override
    public List<EntradaBlog> recuperarListadoEntradas() {
        return blogs;
    }

    @Override
    public EntradaBlog recuperarEntrada(Integer id) throws NotFoundException {
        EntradaBlog entradaBlog = blogs.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        if (entradaBlog == null)
            throw new NotFoundException("Entrada no encontrada");
        return entradaBlog;
    }

    @Override
    public void insertarEntrada(EntradaBlog entradaBlog) throws AlreadyExistsException {
        if(blogs.stream().noneMatch(e -> e.getId().equals(entradaBlog.getId())))
            blogs.add(entradaBlog);
        else
            throw new AlreadyExistsException("Ya existe una entrada con ese id");
    }
}
