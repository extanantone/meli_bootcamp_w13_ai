package com.Bootcamp.C4P1EJ1.repository;

import com.Bootcamp.C4P1EJ1.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    public EntradaBlog insertEntradaBlog(EntradaBlog entradaBlog);
    public EntradaBlog obtenerEntradaBlog(Integer id);
    public List<EntradaBlog> obtenerEntradasBlogs();
}
