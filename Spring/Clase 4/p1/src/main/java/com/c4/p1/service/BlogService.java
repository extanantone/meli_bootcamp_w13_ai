package com.c4.p1.service;

import com.c4.p1.dto.EntradaBlogDto;
import com.c4.p1.dto.EntradaBlogInfoDto;
import com.c4.p1.exceptions.AlreadyExistsException;
import com.c4.p1.exceptions.NotFoundException;
import com.c4.p1.model.EntradaBlog;
import com.c4.p1.repository.BlogRepository;
import com.c4.p1.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{
    IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public List<EntradaBlogDto> recuperarListadoEntradas() {
        return blogRepository.recuperarListadoEntradas().stream().map(EntradaBlogDto::new).collect(Collectors.toList());
    }

    @Override
    public EntradaBlogInfoDto recuperarInfoEntrada(Integer id) throws NotFoundException {
        return new EntradaBlogInfoDto(blogRepository.recuperarEntrada(id));
    }

    @Override
    public Integer insertarEntrada(EntradaBlogDto entradaBlogDto) throws AlreadyExistsException {
        blogRepository.insertarEntrada(new EntradaBlog(entradaBlogDto.getId(), entradaBlogDto.getTitulo(), entradaBlogDto.getAutor(), LocalDate.parse(entradaBlogDto.getFechaPublicacion())));
        return entradaBlogDto.getId();
    }
}
