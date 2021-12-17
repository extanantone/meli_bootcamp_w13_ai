package com.example.easynotes.service;

import com.example.easynotes.dto.*;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.Thank;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.repository.ThankRepository;
import com.example.easynotes.repository.UserRepository;
import com.example.easynotes.utils.ListMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

    UserRepository userRepository;

    NoteRepository noteRepository;

    ThankRepository thankRepository;

    ModelMapper modelMapper;

    ListMapper listMapper;

    @PersistenceContext
    EntityManager entityManager;

    UserService(UserRepository userRepository,
                NoteRepository noteRepository,
                ThankRepository thankRepository,
                ModelMapper modelMapper,
                ListMapper listMapper) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
        this.thankRepository = thankRepository;
        this.listMapper = listMapper;


        Converter<Long, User> authorIdToUserConverter = new AbstractConverter<Long, User>() {
            @Override
            protected User convert(Long authorId) throws ResourceNotFoundException {
                return userRepository.findById(authorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId));
            }
        };
        //Load converter to modelMapper used when we want convert from User to UserResponseWithCantNotesDTO
        modelMapper.typeMap(NoteRequestDTO.class, Note.class).addMappings( (mapper) ->
                mapper.using(authorIdToUserConverter)
                        .map(NoteRequestDTO::getAuthorId, Note::setAuthor)
        );

        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> listUsers = userRepository.findAll();
        return listMapper.mapList(listUsers, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseWithNotesDTO> getAllUsersWithNotes() {
        List<User> listUsers = userRepository.findAll();
        return listMapper.mapList(listUsers, UserResponseWithNotesDTO.class);
    }

    @Override
    public List<UserResponseWithCantNotesDTO> getAllUsersWithCantNotes() {
        List<User> listUsers = userRepository.findAll();
        return listMapper.mapList(listUsers, UserResponseWithCantNotesDTO.class);
    }

    @Override
    public UserResponseDTO createUSer(UserRequestDTO userRequestDTO) {
        User user = modelMapper.map(userRequestDTO, User.class);
        return modelMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseWithNotesDTO getUserWithNotesById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return modelMapper.map(user, UserResponseWithNotesDTO.class);
    }
    @Override
    public UserResponseWithCantNotesDTO getUserWithCantNotesById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return modelMapper.map(user, UserResponseWithCantNotesDTO.class);
    }


    @Override
    public UserResponseDTO updateUser(Long userId,
                                      UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());

        return modelMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

    }

    @Override
    public List<UserResponseDTO> getUsersLastNameLike(String lastName) {
        List<?> map =  userRepository.countByFirstName(lastName);

        return null;
    }

    @Override
    public List<UserResponseWithNotesDTO> getUsersByNoteTitleLike(String title) {
        List<User> users = userRepository.findUserByNoteTitleLike(title);

        return listMapper.mapList(users, UserResponseWithNotesDTO.class);
    }

    @Override
    public List<UserResponseWithNotesDTO> getUsersByNoteCreatedAfterDate(Date date) {
        List<User> users = userRepository.findUserByNoteCreatedAtLessOrEqualDate(date);

        return listMapper.mapList(users, UserResponseWithNotesDTO.class);
    }

    @Override
    public void createThank(Long userId, Long noteId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        Thank thank = new Thank(user, note);

        thankRepository.save(thank);
    }

//    @Override
//    public List<UserResponseDTO> getUsersLastNameLikeAndFirstNameLike(String lastName, String firstName) {
//        List<User> users = userRepository.findUserByLastNameLikeAndFirstNameContains(lastName, firstName);
//
//        return listMapper.mapList(users, UserResponseDTO.class);
//    }




    // NOTA: MALA PRACTICA 1 (entityManager)
    @Override
    public UserResponseDTO getUserById(Integer id) {
        User user = (User) entityManager.createQuery("from user where id = ?1")
                .setParameter(1, id)
                .getSingleResult();

        return modelMapper.map(user, UserResponseDTO.class);
    }


    // NOTA: MALA PRACTICA 2 (@NameQuery y entityManager)
    @Override
    public UserResponseDTO getUserByLastName(String lastName) {
        TypedQuery<User> query = entityManager.createNamedQuery("getUserByLastName", User.class);

        query.setParameter("lastName", lastName);

        User user = query.getSingleResult();

        return modelMapper.map(user, UserResponseDTO.class);
    }
}
