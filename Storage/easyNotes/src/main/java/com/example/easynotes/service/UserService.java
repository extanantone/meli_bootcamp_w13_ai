package com.example.easynotes.service;

import com.example.easynotes.dto.UserRequestDTO;
import com.example.easynotes.dto.UserResponseDTO;
import com.example.easynotes.dto.UserResponseWithCantNotesDTO;
import com.example.easynotes.dto.UserResponseWithNotesDTO;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    ModelMapper mapper;

    JpaRepository<User, Long> userRepository;

    public UserService(
            ModelMapper mapper,
            UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return null;
    }

    @Override
    public List<UserResponseWithNotesDTO> getAllUsersWithNotes() {
        return null;
    }

    @Override
    public List<UserResponseWithCantNotesDTO> getAllUsersWithCantNotes() {
        return null;
    }

    //!TODO vivo!
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        User user = mapper.map(userRequestDTO, User.class);

        //user = userRepository.save(user);
        userRepository.save(user);
        //userRepository.findAll();
        //userRepository.findByLastNameAndFirstName("pepe", "surname");

        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        return null;
    }

    @Override
    public UserResponseWithNotesDTO getUserWithNotesById(Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow( () ->
                        new ResourceNotFoundException("user", "id", userId) );

        return mapper.map( user, UserResponseWithNotesDTO.class );
    }

    @Override
    public UserResponseWithCantNotesDTO getUserWithCantNotesById(Long userId) {
        return null;
    }

    @Override
    public UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}

