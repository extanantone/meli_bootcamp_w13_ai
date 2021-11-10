package com.Bootcamp.C4P1EJ1.repository;

import com.Bootcamp.C4P1EJ1.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository {
    private Map<Integer, EntradaBlog> mapaEntradaBlogBD = new HashMap<>();


    @Override
    public EntradaBlog insertEntradaBlog(EntradaBlog entradaBlog) {
        this.mapaEntradaBlogBD.put(entradaBlog.getIdBlog(), entradaBlog);
        return entradaBlog;
    }

    @Override
    public EntradaBlog obtenerEntradaBlog(Integer id) {
        return this.mapaEntradaBlogBD.get(id);
    }

    @Override
    public List<EntradaBlog> obtenerEntradasBlogs() {
        return this.mapaEntradaBlogBD.values()
                .stream()
                .collect(Collectors.toList());
    }
}
