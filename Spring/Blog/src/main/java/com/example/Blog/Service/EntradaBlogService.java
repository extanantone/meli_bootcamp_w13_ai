package com.example.Blog.Service;

import com.example.Blog.DTO.EntradaBlogDTO;
import com.example.Blog.Exception.DuplicateException;
import com.example.Blog.Exception.NotFoundException;
import com.example.Blog.Mapper.EntradaMapper;
import com.example.Blog.Model.EntradaBlog;
import com.example.Blog.Repository.EntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements EntradaBlogServiceI {

    @Autowired
    private EntradaBlogRepository entradaBlogRepository;

    @Autowired
    private EntradaMapper entradaMapper;

    @Override
    public EntradaBlogDTO crearNuevoBLog(EntradaBlogDTO entradaBlogDTO) {
        if(entradaBlogRepository.findById(entradaBlogDTO.getId()) != null){
            throw new DuplicateException(entradaBlogDTO.getId());
        }
        EntradaBlog entradaBlog = entradaBlogRepository.nuevoBlog(entradaMapper.entradaBlogDTOToEntradaBlog(entradaBlogDTO));
        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);

    }

    @Override
    public EntradaBlogDTO getBlog(Long id) {
        EntradaBlog entradaBlog = entradaBlogRepository.findById(id);
        if(entradaBlog == null){
            throw new NotFoundException(id);
        }
        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);
    }

    @Override
    public List<EntradaBlogDTO> getBlogs() {
        return entradaBlogRepository.getBlogs().stream().map(e -> entradaMapper.entradaBlogToEntradaBlogDTO(e)).collect(Collectors.toList());
    }
}

