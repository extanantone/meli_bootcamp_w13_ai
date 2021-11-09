package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.exceptions.DuplicatedBlogException;
import com.bootcamp.blog.exceptions.NotFoundException;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    private IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Integer crearEntrada(EntradaBlogDTO nuevaEntrada){
        if(this.blogRepository.buscarEntrada(nuevaEntrada.getId()) != null){
            throw new DuplicatedBlogException("Ya existe una entrada con ese ID!");
        }
        EntradaBlog entradaBlog = new EntradaBlog(nuevaEntrada.getId(),
                                                nuevaEntrada.getTitulo(),
                                                nuevaEntrada.getAutor(),
                                                nuevaEntrada.getFechaPublicacion());
        this.blogRepository.insertarEntrada(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public EntradaBlog getEntrada(Integer id){
        EntradaBlog entrada = this.blogRepository.buscarEntrada(id);
        if(entrada == null){
            throw new NotFoundException("No se encontró una entrada con ese ID");
        }
        return entrada;
    }

    @Override
    public List<EntradaBlog> getAllEntradas(){
        return this.blogRepository.getAllEntradas();
    }


}
