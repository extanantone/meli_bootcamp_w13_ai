package com.example.bootcamp.demo.service;

import com.example.bootcamp.demo.dto.EntradaBlogDTO;

import java.util.List;

public interface IEntradaBlogService {

    public EntradaBlogDTO nuevoBlog(EntradaBlogDTO entradaBlogDTO);
    public EntradaBlogDTO getBlog (Long id);
    public List<EntradaBlogDTO> getBlogs();

}
