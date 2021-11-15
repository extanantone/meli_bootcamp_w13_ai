package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.UsuarioDTO;
import com.example.socialmeli.demo.model.Usuario;
import com.example.socialmeli.demo.model.Usuarios;
import com.example.socialmeli.demo.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Override
    public Usuarios createUser(Usuarios v) {
        return null;
    }

    @Override
    public UsuarioDTO getUserByUserId(int id) {

        Usuario searchedUser = new Usuarios();
        UsuarioDTO searchedUserDTO = new UsuarioDTO();

        searchedUser = iUsuarioRepository.obtenerUsuarioPorID(id);
        searchedUserDTO.setUser_id(searchedUser.getId());
        searchedUserDTO.setUser_name(searchedUser.getUsername());

        return searchedUserDTO;
    }
}
