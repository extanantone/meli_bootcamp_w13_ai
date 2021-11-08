package com.example.c4_manejo_excep_vivo_p1.service;

import com.example.c4_manejo_excep_vivo_p1.dto.EntradaBlogDTO;
import com.example.c4_manejo_excep_vivo_p1.exception.DuplicateException;
import com.example.c4_manejo_excep_vivo_p1.exception.NotFoundException;
import com.example.c4_manejo_excep_vivo_p1.mapper.EntradaBlogMapper;
import com.example.c4_manejo_excep_vivo_p1.model.EntradaBlog;
import com.example.c4_manejo_excep_vivo_p1.repository.IBlogRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Blogservice implements IBlogService
{
    @Autowired
    IBlogRepository blogRepository;

    @Autowired
    EntradaBlogMapper entradaBlogMapper;

    @Override
    public List<EntradaBlogDTO> getBlogs()
    {
        return blogRepository.getBlogs().stream().map(entradaBlog -> entradaBlogMapper.entradaBlogToEntradaBlogDTO(entradaBlog)).collect(Collectors.toList());
    }

    @Override
    public EntradaBlogDTO getBlog(Long id)
    {
        if (blogRepository.getMap().containsKey(id))
            return entradaBlogMapper.entradaBlogToEntradaBlogDTO(blogRepository.getMap().get(id));
        else
            throw new NotFoundException(id);
    }

    @Override
    public EntradaBlogDTO createBlog(EntradaBlogDTO entradaBlogDTO)
    {
        if (!blogRepository.getMap().containsKey(entradaBlogDTO.getId()))
        {
            blogRepository.saveBlog(entradaBlogMapper.entradaBlogDTOToEntradaBlog(entradaBlogDTO));
            return entradaBlogDTO;
        }
        throw new DuplicateException(entradaBlogDTO.getId());
    }
}
