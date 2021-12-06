package com.example.easynotes.service;

import com.example.easynotes.dto.NoteRequestDTO;
import com.example.easynotes.dto.NoteResponseWithAuthorDTO;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<NoteResponseWithAuthorDTO> getAllNotes() {
        return null;
    }

    @Override
    public NoteResponseWithAuthorDTO createNote(NoteRequestDTO noteRequestDTO) {
        Note note = mapper.map(noteRequestDTO, Note.class);

        return mapper.map(
                noteRepository.save(note),
                NoteResponseWithAuthorDTO.class);
    }

    @Override
    public NoteResponseWithAuthorDTO getNoteById(Long noteId) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("note","id",noteId) );


        return mapper.map(note, NoteResponseWithAuthorDTO.class);
    }

    @Override
    public NoteResponseWithAuthorDTO updateNote(Long noteId, Note noteDetailsDTO) {
        return null;
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}
