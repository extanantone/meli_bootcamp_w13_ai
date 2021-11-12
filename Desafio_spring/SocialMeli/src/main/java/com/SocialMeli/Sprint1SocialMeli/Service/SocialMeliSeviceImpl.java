package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.Exception.NotFoundUsuarioException;
import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Usuario;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import com.SocialMeli.Sprint1SocialMeli.Repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMeliSeviceImpl implements ISocialMeliService{

    final
    ISocialMeliRepository repositorio;


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
