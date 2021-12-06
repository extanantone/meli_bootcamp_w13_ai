package com.example.easynotes.controller;

import com.example.easynotes.dto.UserRequestDTO;
import com.example.easynotes.dto.UserResponseDTO;
import com.example.easynotes.dto.UserResponseWithCantNotesDTO;
import com.example.easynotes.dto.UserResponseWithNotesDTO;
import com.example.easynotes.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/allWithNotes")
    public List<UserResponseWithNotesDTO> getAllUsersWithNotes() {
        return userService.getAllUsersWithNotes();
    }

    @GetMapping("/allWithCantNotes")
    public List<UserResponseWithCantNotesDTO> getAllUsersWithCantNotes() {
        return userService.getAllUsersWithCantNotes();
    }

    @PostMapping()
    public UserResponseDTO createUSer(
            @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable(value = "id") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/{id}/notes")
    public UserResponseWithNotesDTO getUserWithNotesById(@PathVariable(value = "id") Long userId) {
        return userService.getUserWithNotesById(userId);
    }

    @GetMapping("/{id}/notes/cant")
    public UserResponseWithCantNotesDTO getUserWithCantNotesById(@PathVariable(value = "id") Long userId) {
        return userService.getUserWithCantNotesById(userId);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable(value = "id") Long userId,
                                     @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(userId, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
