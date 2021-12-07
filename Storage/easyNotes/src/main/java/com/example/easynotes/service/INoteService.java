package com.example.easynotes.service;

import com.example.easynotes.dto.ThankDTO;
import com.example.easynotes.dto.NoteRequestDTO;
import com.example.easynotes.dto.NoteResponseWithAuthorDTO;
import com.example.easynotes.model.Note;

import java.util.List;
import java.util.Set;

public interface INoteService {

    List<NoteResponseWithAuthorDTO> getAllNotes();

    NoteResponseWithAuthorDTO createNote(NoteRequestDTO noteRequestDTO);

    NoteResponseWithAuthorDTO getNoteById(Long noteId);

    NoteResponseWithAuthorDTO updateNote(Long noteId, Note noteDetailsDTO);

    void deleteNote(Long noteId);

    void addReviser(Long id, Long authorId);

    Set<ThankDTO> getThanks(Long id);
}
