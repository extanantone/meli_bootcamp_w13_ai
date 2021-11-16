package com.example.demo.service;

import com.example.demo.dtos.EntradaBlogDTO;
import com.example.demo.exception.DuplicateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.EntradaMapper;
import com.example.demo.model.EntradaBlog;
import com.example.demo.repository.EntradaBlogRepository;
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

    @Autowired
    private ModelMapper mapper;

    @Override
    public EntradaBlogDTO crearNuevoBLog(EntradaBlogDTO entradaBlogDTO) {
        if(entradaBlogRepository.findById(entradaBlogDTO.getId()) != null){
            throw new DuplicateException(entradaBlogDTO.getId());
        }
        EntradaBlog entradaBlog = entradaBlogRepository.nuevoBlog(entradaMapper.entradaBlogDTOToEntradaBlog(entradaBlogDTO));
        //EntradaBlog entradaBlog2 = entradaBlogRepository.nuevoBlog(mapper.map(entradaBlogDTO, EntradaBlog.class));
        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);

    }

    @Override
    public EntradaBlogDTO getBlog(Long id) {
        EntradaBlog entradaBlog = entradaBlogRepository.findById(id);
        if(entradaBlog == null){
            throw new NotFoundException(id);
        }
        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);
        //return mapper.map(entradaBlog, EntradaBlogDTO.class);
    }

    @Override
    public List<EntradaBlogDTO> getBlogs() {
        return entradaBlogRepository.getBlogs().stream().map(e -> entradaMapper.entradaBlogToEntradaBlogDTO(e)).collect(Collectors.toList());
        //return entradaBlogRepository.getBlogs().stream().map(e -> mapper.map(e, EntradaBlogDTO.class)).collect(Collectors.toList());
    }

    public String a(){
        /* utiliza DTO*/

        /* se mapea el DTO a Objecto de dominio (EntradaBlog)*/

        /* trabajamos con el objeto de dominio */
        /* trabajamos con el objeto de dominio */
        /* trabajamos con el objeto de dominio */

        /* se mapea el Objecto de dominio(EntradaBlog) a DTO*/
        return "";
    }
}

