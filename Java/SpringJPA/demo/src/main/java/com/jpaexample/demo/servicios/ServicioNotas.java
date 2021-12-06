package com.jpaexample.demo.servicios;

import com.jpaexample.demo.dto.NotasDto;
import com.jpaexample.demo.modelos.one_to_many.Notas;
import com.jpaexample.demo.repositorios.IRepositorioNotas;
import com.jpaexample.demo.repositorios.IRepositorioUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ServicioNotas {

    IRepositorioUsuario repoUsuario;

    IRepositorioNotas repoNotas;

    ModelMapper mapper;

    public ServicioNotas(IRepositorioUsuario repoUsuario, IRepositorioNotas repoNotas, ModelMapper mapper) {
        this.repoUsuario = repoUsuario;
        this.repoNotas = repoNotas;
        this.mapper = mapper;
    }

    public NotasDto crearNotas(NotasDto notaNuevo)
    {
        Notas notaCreada = repoNotas.save(mapper.map(notaNuevo,Notas.class));
        return mapper.map(notaCreada,NotasDto.class);
    }


}
