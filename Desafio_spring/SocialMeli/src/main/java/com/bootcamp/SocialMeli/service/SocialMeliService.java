package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.response.SuccessDTO;
import com.bootcamp.SocialMeli.exception.AlreadyFollowException;
import com.bootcamp.SocialMeli.exception.NotFollowException;
import com.bootcamp.SocialMeli.exception.UserNotFoundException;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.model.Vendedor;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMeliService implements ISocialMeliService{

    private ISocialMeliRepository socialMeliRepository;

    @Autowired
    public SocialMeliService(ISocialMeliRepository socialMeliRepository) {
        this.socialMeliRepository = socialMeliRepository;
    }

    @Override
    public SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor){
        Usuario seguidor = this.socialMeliRepository.buscarUsuario(idSeguidor);
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(idVendedor);
        //TODO verificar que sea vendedor (tenga publicaciones)
        //TODO verificar que antes no lo seguia
        if(seguidor == null){
            throw new UserNotFoundException("No existe el usuario seguidor");
        }else if(vendedor == null){
            throw new UserNotFoundException("No existe el vendedor");
        }
        boolean loSigo = seguidor.getVendedoresSeguidos().contains(vendedor);
        if(loSigo){ //true = ya lo sigo
            throw new AlreadyFollowException();
        }
        seguidor.seguirVendedor(vendedor);

        return new SuccessDTO("Vendedor seguido correctamente");
    }

    @Override
    public void getCantSeguidores(Integer userId) {
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(userId);
        if(vendedor == null){
            throw new UserNotFoundException("No existe un vendedor con Id: " + userId);
        }
        //vendedor.get
    }

    @Override
    public SuccessDTO unfollowVendedor(Integer idSeguidor, Integer idVendedor) {
        Usuario seguidor = this.socialMeliRepository.buscarUsuario(idSeguidor);
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(idVendedor);
        //TODO verificar que sea vendedor (tenga publicaciones)
        //TODO verificar que antes lo seguia
        if(seguidor == null){
            throw new UserNotFoundException("No existe el usuario seguidor");
        }else if(vendedor == null){
            throw new UserNotFoundException("No existe el vendedor");
        }
        boolean loSeguia = seguidor.dejarDeSeguirVendedor(vendedor);
        if(!loSeguia){
            throw new NotFollowException();
        }
        return new SuccessDTO("Vendedor no seguido correctamente");
    }
}
