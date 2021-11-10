package com.Bootcamp.C4P1EJ1.service;

import com.Bootcamp.C4P1EJ1.dto.EntradaBlogDTO;
import com.Bootcamp.C4P1EJ1.exception.DuplicateException;
import com.Bootcamp.C4P1EJ1.exception.NotFoundException;
import com.Bootcamp.C4P1EJ1.mapper.EntradaMapper;
import com.Bootcamp.C4P1EJ1.model.EntradaBlog;
import com.Bootcamp.C4P1EJ1.repository.IEntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService {
    IEntradaBlogRepository iEntradaBlogRepository;
    EntradaMapper entradaMapper;
    ModelMapper modelMapper;

    public EntradaBlogServiceImp(IEntradaBlogRepository iEntradaBlogRepository, EntradaMapper entradaMapper, ModelMapper modelMapper) {
        this.iEntradaBlogRepository = iEntradaBlogRepository;
        this.entradaMapper = entradaMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public EntradaBlogDTO nuevaEntradaBlog(EntradaBlogDTO entradaBlogDTO) {
        if (this.iEntradaBlogRepository.obtenerEntradaBlog(entradaBlogDTO.getIdBlog()) != null) {
            throw new DuplicateException(entradaBlogDTO.getIdBlog(), "¡Error! El ID " + entradaBlogDTO.getIdBlog() + " ya existe.");
        }
        EntradaBlog entradaBlog = this.iEntradaBlogRepository
                .insertEntradaBlog(entradaMapper
                        .entradaBlogDTOAEntradaBlog(entradaBlogDTO));
        return entradaMapper.entradaBlogAEntradaBlogDTO(entradaBlog);
    }

    @Override
    public EntradaBlogDTO devolverEntradaBlog(int id) {
        EntradaBlog entradaBlog = this.iEntradaBlogRepository.obtenerEntradaBlog(id);
        if (entradaBlog==null){
            throw new NotFoundException();
        }
        return entradaMapper.entradaBlogAEntradaBlogDTO(entradaBlog);
    }

    @Override
    public List<EntradaBlogDTO> devolverTodasLasEntradasBlog() {
        List<EntradaBlog> listaEntradasBlogs = this.iEntradaBlogRepository.obtenerEntradasBlogs();
        return listaEntradasBlogs
                .stream()
                .map(entradaBlog -> entradaMapper.entradaBlogAEntradaBlogDTO(entradaBlog))
                .collect(Collectors.toList());
    }
}
