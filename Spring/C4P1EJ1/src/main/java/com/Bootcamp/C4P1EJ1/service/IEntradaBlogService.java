package com.Bootcamp.C4P1EJ1.service;

import com.Bootcamp.C4P1EJ1.dto.EntradaBlogDTO;
import com.Bootcamp.C4P1EJ1.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {
    public EntradaBlogDTO nuevaEntradaBlog(EntradaBlogDTO entradaBlogDTO);

    public EntradaBlogDTO devolverEntradaBlog(int id);

    public List<EntradaBlogDTO> devolverTodasLasEntradasBlog();
}
