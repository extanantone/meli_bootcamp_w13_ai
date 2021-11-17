package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.model.Usuarios;
import com.example.socialmeli.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUsuarioRepository;

    @Override
    public Usuarios createUser(Usuarios v) {
        return null;
    }

    @Override
    public DTOUsuario getUserByUserId(int id) {

        Usuarios searchedUser = new Usuarios();
        DTOUsuario searchedUserDTO = new DTOUsuario();

        searchedUser = iUsuarioRepository.getUserByUserId(id);

        if(searchedUser == null)
            return null;

        searchedUserDTO.setUserId(searchedUser.getId());
        searchedUserDTO.setUserName(searchedUser.getUserName());

        return searchedUserDTO;
    }
}
