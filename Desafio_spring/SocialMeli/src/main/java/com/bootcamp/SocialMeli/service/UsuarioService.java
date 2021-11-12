package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.FollowerListDTO;
import com.bootcamp.SocialMeli.dto.UsuarioDTO;
import com.bootcamp.SocialMeli.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

    IUsuarioRepository iUsuarioRepository;

    public UsuarioService(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public void realizarFollow(Integer userId, Integer userIdToFollow) {
        iUsuarioRepository.insertarFollowed(userId, userIdToFollow);
        iUsuarioRepository.insertarFollower(userId, userIdToFollow);
    }

    @Override
    public FollowerCountDTO cantidadFollowers(Integer userId) {
        FollowerCountDTO followerCountDTO = new FollowerCountDTO(iUsuarioRepository.devolverUsuario(userId).getUserId(), iUsuarioRepository.devolverUsuario(userId).getUserName(), iUsuarioRepository.devolverUsuario(userId).getFollowersCount());
        return followerCountDTO;
    }

    @Override
    public FollowerListDTO listaFollowers(Integer userId) {
        FollowerListDTO followerListDTO = new FollowerListDTO(iUsuarioRepository.devolverUsuario(userId).getUserId(), iUsuarioRepository.devolverUsuario(userId).getUserName(), iUsuarioRepository.devolverUsuario(userId)
                .getFollowers()
                .stream()
                .map(usuario -> new UsuarioDTO(usuario.getUserId(),usuario.getUserName()))
                .collect(Collectors.toList()));
        return followerListDTO;
    }

    @Override
    public FollowedListDTO listaFollowed(Integer userId){
        FollowedListDTO followedListDTO = new FollowedListDTO(iUsuarioRepository.devolverUsuario(userId).getUserId(), iUsuarioRepository.devolverUsuario(userId).getUserName(), iUsuarioRepository.devolverUsuario(userId)
                .getFollowed()
                .stream()
                .map(usuario -> new UsuarioDTO(usuario.getUserId(),usuario.getUserName()))
                .collect(Collectors.toList()));
        return followedListDTO;
    }

    
}
