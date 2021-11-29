package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exception.DuplicateIdException;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.mapper.UserMapper;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServicie implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public SeguidorDTO setSeguidor(int idSeguidor, int idSeguido) {

        if(idSeguidor == idSeguido){throw new DuplicateIdException(idSeguidor,idSeguido);}
        if(iUserRepository.getUser(idSeguidor) ==null){throw new NotFoundExceptionUsers(idSeguidor); }
        if(iUserRepository.getUser(idSeguido) ==null){throw new NotFoundExceptionUsers(idSeguido);}
        if(iUserRepository.getExisteSeguidor(idSeguidor,idSeguido)){throw new DuplicateIdException(idSeguidor,idSeguido);}

        iUserRepository.setSeguidor(new Seguidor(idSeguidor,idSeguido));

        return new SeguidorDTO(iUserRepository.getUser(idSeguidor).getUserName(),idSeguidor,iUserRepository.getUser(idSeguido).getUserName(),idSeguido);
    }

    @Override
    public List<UserDTO> setUser(List<UserDTO> userDTOS) {

        userDTOS.forEach(userDTO ->{
                    User user=  UserMapper.UserDTOToUser(userDTO);
                    if(iUserRepository.getUser(user.getUserId()) !=null)
                    {throw new DuplicateIdException(user.getUserId(),User.class.getSimpleName());}
                    iUserRepository.setUser(user);
                });
        return userDTOS;
    }

    @Override
    public MesiguenCabtidadDTO getSequidores(int id) {

        if(iUserRepository.getUser(id) ==null){throw new NotFoundExceptionUsers(id); }
        int cantidad = (int) iUserRepository.getSegidor().stream().filter(seguidor -> seguidor.getIdSeguido()==id).count();
        User user = iUserRepository.getUser(id);

        return new MesiguenCabtidadDTO(user.getUserId(), user.getUserName(), cantidad);
    }

    @Override
    public MesiguenDTO getMeSiguen(int id) {

        if(iUserRepository.getUser(id) ==null){throw new NotFoundExceptionUsers(id); }
        List<UserDTO> usersDTO = new ArrayList<>();

        iUserRepository.getSegidor().stream().filter(seguidor -> seguidor.getIdSeguido()==id).forEach(
                user ->{
                    usersDTO.add(UserMapper.userToUserDTO( iUserRepository.getUser(user.getIdSeguidor())));
                }
        );
        User user = iUserRepository.getUser(id);

      return new MesiguenDTO(user.getUserId(),user.getUserName(),usersDTO);

    }

    @Override
    public MesiguenDTO getAquienSiguo(int id) {
        if(iUserRepository.getUser(id) ==null){throw new NotFoundExceptionUsers(id); }

        List<UserDTO> usersDTO = new ArrayList<>();

        iUserRepository.getSegidor().stream().filter(seguidor -> seguidor.getIdSeguidor()==id).forEach(
                user ->{
                    usersDTO.add(UserMapper.userToUserDTO( iUserRepository.getUser(user.getIdSeguido())));
                }
        );
        UserDTO user = UserMapper.userToUserDTO( iUserRepository.getUser(id));

        return new MesiguenDTO(user.getUserId(),user.getUserName(),usersDTO);
    }

    @Override
    public SeguidorDTO dejarDeSeguir(int idSeguidor, int idSeguido) {

        if(iUserRepository.getUser(idSeguidor) ==null){throw new NotFoundExceptionUsers(idSeguidor); }
        if(iUserRepository.getUser(idSeguido) ==null){throw new NotFoundExceptionUsers(idSeguido);}

        iUserRepository.dejarDeSeguir(idSeguidor,idSeguido);

        return new SeguidorDTO("",idSeguidor,"",idSeguido);
    }

    @Override
    public MesiguenDTO getOrdenadaMesiguen(int id, String order) {

        MesiguenDTO mesiguenDTO = getMeSiguen(id);

        List<UserDTO> userDTOSorder;
        if(order.equals("name_asc")){
            userDTOSorder= mesiguenDTO.getFollowers().stream().sorted(Comparator.comparing(UserDTO::getUserName)).collect(Collectors.toList());
        }else if(order.equals("name_desc")){
            userDTOSorder= mesiguenDTO.getFollowers().stream().sorted(Comparator.comparing(UserDTO::getUserName).reversed()).collect(Collectors.toList());
        }else
        {
            userDTOSorder = null;
        }
        if(userDTOSorder == null){
            throw new NullPointerException();
        }

        mesiguenDTO.setFollowers(userDTOSorder);

        return mesiguenDTO;
    }

    @Override
    public MesiguenDTO getOrdenadaAquienSigo(int id, String order) {

        MesiguenDTO mesiguenDTO= getAquienSiguo(id);

        List<UserDTO> userDTOSOrder;

        if(order.equals("name_asc")){
            userDTOSOrder = mesiguenDTO.getFollowers().stream().sorted(Comparator.comparing(UserDTO::getUserName)).collect(Collectors.toList());
        }else{
            userDTOSOrder = mesiguenDTO.getFollowers().stream().sorted(Comparator.comparing(UserDTO::getUserName).reversed()).collect(Collectors.toList());
        }
        mesiguenDTO.setFollowers(userDTOSOrder);

        return mesiguenDTO;
    }

}
