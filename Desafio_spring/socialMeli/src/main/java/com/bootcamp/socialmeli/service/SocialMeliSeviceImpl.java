package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.exception.NotFoundUsuarioException;
import com.bootcamp.socialmeli.entitiy.Comprador;
import com.bootcamp.socialmeli.entitiy.Vendedor;
import com.bootcamp.socialmeli.repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialMeliSeviceImpl implements ISocialMeliService{

    final ISocialMeliRepository repositorio;


    public SocialMeliSeviceImpl(ISocialMeliRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public boolean addFollowed(Integer id_comprador, Integer id_vendedor)
    {

     Comprador c = repositorio.getComprador(id_comprador);
     Vendedor v = repositorio.getVendedor(id_vendedor);

     if(c == null)
     {
         throw new NotFoundUsuarioException(id_comprador);
     }
     if(v == null)
     {
         throw new NotFoundUsuarioException(id_vendedor);
     }

        return repositorio.follow(id_comprador,id_vendedor);
    }
}
