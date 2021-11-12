package com.bootcamp.SocialMeli.Service;

import com.bootcamp.SocialMeli.DTO.SeguidorDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresCountDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresDTO;
import com.bootcamp.SocialMeli.DTO.UsuarioDTO;
import com.bootcamp.SocialMeli.Exception.InvalidFollowExceptionUser;
import com.bootcamp.SocialMeli.Exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.Mapper.UsuarioMapper;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import com.bootcamp.SocialMeli.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    IUsuarioRepository iUsuarioRepository;


    @Override
    public SeguidorDTO setSeguidor(int idUser, int idUserFollow) {
        if(iUsuarioRepository.getUsuario(idUser) ==null){
            throw new NotFoundExceptionUsers("No se encuentra el usuario: "+idUser);
        }
        if(iUsuarioRepository.getUsuario(idUserFollow) ==null){
            throw new NotFoundExceptionUsers("No se encuentra el usuario a seguir: "+idUserFollow);
        }
        if(iUsuarioRepository.getSeguidorById(idUser,idUserFollow) != false){
            throw new InvalidFollowExceptionUser("El usuario "+idUser+" ya sigue al vendedor "+idUserFollow);
        }
        if(idUser == idUserFollow){
            throw new InvalidFollowExceptionUser("No se puede seguir a si mismo!");
        }

        iUsuarioRepository.setSeguidor(new Seguidor(idUser,idUserFollow));

        return new SeguidorDTO(iUsuarioRepository.getUsuario(idUser).getUserName(),idUser,iUsuarioRepository.getUsuario(idUserFollow).getUserName(),idUserFollow);

    }

    @Override
    public SeguidoresCountDTO getSequidores(int idUser) {
        if(iUsuarioRepository.getUsuario(idUser) ==null){
            throw new NotFoundExceptionUsers("No se encuentra el usuario: "+idUser);
        }
        int cantidad = (int) iUsuarioRepository.getSeguidor().stream().filter(seguidor -> seguidor.getIdUser()==idUser).count();
        Usuario user = iUsuarioRepository.getUsuario(idUser);

        return new SeguidoresCountDTO(user.getUserId(),user.getUserName(), cantidad);
    }

    @Override
    public SeguidoresDTO getFollowers(int idUser) {
        if(iUsuarioRepository.getUsuario(idUser) == null){
            throw new NotFoundExceptionUsers("No se encuentra el usuario: "+idUser);
        }

        List<UsuarioDTO> usuarioDTO = new ArrayList<>();

        iUsuarioRepository.getSeguidor().stream().filter(seguidor -> seguidor.getIdUserFollow()==idUser).forEach(
                usuario ->{
                    usuarioDTO.add(UsuarioMapper.UsuarioToUsuarioDTO( iUsuarioRepository.getUsuario(usuario.getIdUser())));
                }
        );
        Usuario usuario = iUsuarioRepository.getUsuario(idUser);

        return new SeguidoresDTO(usuario.getUserId(),usuario.getUserName(),usuarioDTO);
    }

    @Override
    public SeguidoresDTO getFollowed(int idUser) {
        if(iUsuarioRepository.getUsuario(idUser) == null){
            throw new NotFoundExceptionUsers("No se encuentra el usuario: "+idUser);
        }

        List<UsuarioDTO> usuarioDTO = new ArrayList<>();

        iUsuarioRepository.getSeguidor().stream().filter(seguidor -> seguidor.getIdUser()==idUser).forEach(
                usuario ->{
                    usuarioDTO.add(UsuarioMapper.UsuarioToUsuarioDTO( iUsuarioRepository.getUsuario(usuario.getIdUserFollow())));
                }
        );
        UsuarioDTO user = UsuarioMapper.UsuarioToUsuarioDTO( iUsuarioRepository.getUsuario(idUser));

        return new SeguidoresDTO(user.getUserId(),user.getUserName(),usuarioDTO);
    }
}
