package com.example.easynotes.controller;

import com.example.easynotes.dto.*;
import com.example.easynotes.service.IUserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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

    @GetMapping("/all/notes")
    public List<UserResponseWithNotesDTO> getAllUsersWithNotes() {
        return userService.getAllUsersWithNotes();
    }

    @GetMapping("/all/notes/cant")
    public List<UserResponseWithCantNotesDTO> getAllUsersWithCantNotes() {
        return userService.getAllUsersWithCantNotes();
    }

    @PostMapping()
    public UserResponseDTO createUSer(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUSer(userRequestDTO);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable(value = "id") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/{id}/notes")
    public UserResponseWithNotesDTO getUserWithNotesById(@PathVariable(value = "id") Long userId) {
        return userService.getUserWithNotesById(userId);
    }

    @GetMapping("like/lastName/{lastName}")
    public List<UserResponseDTO> getUsersLastNameLike(@PathVariable(value = "lastName") String lastName) {
        return userService.getUsersLastNameLike(lastName);
    }

    @GetMapping("/like/notes/title/{title}")
    public @ResponseBody List<UserResponseWithNotesDTO> fetchResult(@PathVariable("title") String title) {
        return userService.getUsersByNoteTitleLike(title);
    }

    @GetMapping("/afterDate/notes/createdAt/{date}")
    public @ResponseBody List<UserResponseWithNotesDTO> fetchResult(@PathVariable("date") @DateTimeFormat(pattern="dd-MM-yyyy") Date date) {
        return userService.getUsersByNoteCreatedAfterDate(date);
    }

    @PostMapping("/{id}/thank!/{noteId}")
    public ResponseEntity<?> createGreat(@PathVariable(value = "id") Long userId,
                                         @PathVariable(value = "noteId") Long noteId) {
        userService.createThank(userId, noteId);
        return ResponseEntity.ok().build();
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


    //Metodos de Jean para HQL

//    @GetMapping("like/{lastName}/{firstName}")
//    public List<UserResponseDTO> getUsersLastNameLikeAndFirstNameLike(@PathVariable(value = "lastName") String lastName,
//                                                                      @PathVariable(value = "firstName") String firstName) {
//        return userService.getUsersLastNameLikeAndFirstNameLike(lastName, firstName);
//    }
}
