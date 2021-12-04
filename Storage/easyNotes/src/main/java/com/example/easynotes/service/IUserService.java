package com.example.easynotes.service;

import com.example.easynotes.dto.UserRequestDTO;
import com.example.easynotes.dto.UserResponseDTO;
import com.example.easynotes.dto.UserResponseWithCantNotesDTO;
import com.example.easynotes.dto.UserResponseWithNotesDTO;

import java.util.List;

public interface IUserService {
    List<UserResponseDTO> getAllUsers();

    List<UserResponseWithNotesDTO> getAllUsersWithNotes();

    List<UserResponseWithCantNotesDTO> getAllUsersWithCantNotes();

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    UserResponseDTO getUserById(Long userId);

    UserResponseWithNotesDTO getUserWithNotesById(Long userId);

    UserResponseWithCantNotesDTO getUserWithCantNotesById(Long userId);

    UserResponseDTO updateUser(Long userId,
                               UserRequestDTO userRequestDTO);

    void deleteUser(Long userId);
}
