package com.example.easynotes.service;

import com.example.easynotes.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IUserService {
    List<UserResponseDTO> getAllUsers();

    List<UserResponseWithNotesDTO> getAllUsersWithNotes();

    List<UserResponseWithCantNotesDTO> getAllUsersWithCantNotes();

    UserResponseDTO createUSer(UserRequestDTO userRequestDTO);

    UserResponseDTO getUserById(Long userId);

    UserResponseWithNotesDTO getUserWithNotesById(Long userId);

    UserResponseWithCantNotesDTO getUserWithCantNotesById(Long userId);

    UserResponseDTO updateUser(Long userId,
                               UserRequestDTO userRequestDTO);

    void deleteUser(Long userId);

    List<UserResponseDTO> getUsersLastNameLike(String lastName);

    List<UserResponseWithNotesDTO> getUsersByNoteTitleLike(String title);

    List<UserResponseWithNotesDTO> getUsersByNoteCreatedAfterDate(Date date);

    void createThank(Long userId, Long noteId);
}
