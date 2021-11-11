package com.example.socialMeli.service;

import com.example.socialMeli.dto.RespuestaSimpleDTO;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Vendedor;
import com.example.socialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMeliService implements  ISocialMeliService{

    @Autowired
    ISocialMeliRepository  SMRepositorio;

    public void cargarDatos(){
        SMRepositorio.agregarVendedores();
        SMRepositorio.agregarCompradores();
    }

    public RespuestaSimpleDTO seguir (int id_comprado, int id_vendedor){
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO();
        Comprador compra = SMRepositorio.buscarComprador(id_comprado);
        Vendedor vende = SMRepositorio.buscarVendedor(id_vendedor);

        if(vende == null ){
            throw new UsuarioNoEncontradoError("El id del usuario vendedor es incorrecto");
        }else if(compra == null){
            throw new UsuarioNoEncontradoError("El id del usuario comprador es incorrecto");
        }else{
            Comprador yaSeguidor = SMRepositorio.buscarSeguidor(vende.getSeguidores(), id_comprado);
            if(yaSeguidor != null){
                throw new UsuarioNoEncontradoError("El comprador "+id_comprado+" ya seguia al vendedor "+id_vendedor);
            }else{
                boolean flag =SMRepositorio.seguir(compra, vende);
                if(flag){
                    rta.setMensaje("El comprador "+id_comprado+" ha seguido con exito al vendedor "+id_vendedor);
                    rta.setStatusCode(200);
                }
            }
        }
        return rta;
    }
}
