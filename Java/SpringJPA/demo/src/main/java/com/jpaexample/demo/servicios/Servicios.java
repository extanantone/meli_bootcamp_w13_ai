package com.jpaexample.demo.servicios;

import com.jpaexample.demo.dto.UsuarioDto;
import com.jpaexample.demo.modelos.one_to_many.Usuarios;
import com.jpaexample.demo.repositorios.IRepositorioNotas;
import com.jpaexample.demo.repositorios.IRepositorioUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicios {

    IRepositorioUsuario repoUsuario;

    IRepositorioNotas repoNotas;

    ModelMapper mapper;

    public Servicios(IRepositorioUsuario repoUsuario, IRepositorioNotas repoNotas, ModelMapper mapper) {
        this.repoUsuario = repoUsuario;
        this.repoNotas = repoNotas;
        this.mapper = mapper;
    }

    public UsuarioDto crearUsuario(UsuarioDto userNuevo){
        Usuarios user = mapper.map(userNuevo,Usuarios.class);
        return mapper.map(repoUsuario.save(user),UsuarioDto.class);
    }

    public UsuarioDto findByDni(String dni)
    {
        Usuarios userSalida = repoUsuario.findByDni(dni);
        return mapper.map(userSalida,UsuarioDto.class);
    }

    public List<UsuarioDto> obtenerTodos()
    {
        List<UsuarioDto> salida = new ArrayList<>();
        List<Usuarios> data = repoUsuario.findAll();
        data.stream().forEach(x->{
            salida.add(mapper.map(x,UsuarioDto.class));
        });

        return salida;
    }

    public UsuarioDto updateUser(UsuarioDto userInput) {
        repoUsuario.findByDni(userInput.getDni());
        Usuarios userUpdate = mapper.map(userInput,Usuarios.class);
        Usuarios salida = repoUsuario.save(userUpdate);
        return mapper.map(salida,UsuarioDto.class);
    }

    public boolean borrarUsuarios(String dni){
        Usuarios datoBorrar = repoUsuario.findByDni(dni);
        if(datoBorrar!=null)
        {
            repoUsuario.delete(datoBorrar);
            return true;
        }
        else
            return false;
    }
}
