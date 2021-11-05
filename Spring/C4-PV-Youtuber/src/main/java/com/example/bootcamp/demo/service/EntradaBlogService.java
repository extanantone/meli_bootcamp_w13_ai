package com.example.bootcamp.demo.service;


import com.example.bootcamp.demo.dto.EntradaBlogDTO;
import com.example.bootcamp.demo.exception.DuplicateException;
import com.example.bootcamp.demo.exception.NotFoundException;
import com.example.bootcamp.demo.mapper.EntradaMapper;
import com.example.bootcamp.demo.model.Blog;
import com.example.bootcamp.demo.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    @Autowired
    IEntradaBlogRepository entradaBlogRepository;

    @Autowired
    EntradaMapper entradaMapper;


    @Override
    public EntradaBlogDTO nuevoBlog(EntradaBlogDTO entradaBlogDTO) {

        if(entradaBlogRepository.getBlog(entradaBlogDTO.getId()) != null){
            throw new DuplicateException();
        }

        Blog entradaBlog = entradaBlogRepository.nuevoBlog(entradaMapper.entradaBlogDTOToEntradaBlog(entradaBlogDTO));

        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);
    }

    @Override
    public EntradaBlogDTO getBlog(Long id) {

        Blog entradaBlog = entradaBlogRepository.getBlog(id);

        if(entradaBlog == null)
            throw new NotFoundException();

        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);
    }

    @Override
    public List<EntradaBlogDTO> getBlogs() {
        return entradaBlogRepository.getBlogs().stream().map(e -> entradaMapper.entradaBlogToEntradaBlogDTO(e)).collect(Collectors.toList());
    }
}
